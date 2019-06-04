package fr.paquet.io.csv.integrator;

import java.util.*;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;
import fr.paquet.echafaudage.element.Element;
import fr.paquet.echafaudage.element.EltByName;
import fr.paquet.echafaudage.element.EltByNameFactory;
import fr.paquet.echafaudage.element.InstanciationElement;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.eltByName.ChoixDuType;
import fr.paquet.io.csv.*;

public class ElementIntegrator {

	private CsvElementEchafReader elRe = null;
	private List<Element> elements = null;
	private List<String[]> data = new ArrayList<String[]>();

	public ElementIntegrator(CsvElementEchafReader csvElementEchafReader) {
		setElRe(csvElementEchafReader);
		addData(getElRe().getLines());
		createElement();
	}

	public List<String[]> getData() {
		if (data == null)
			data = new ArrayList<String[]>();
		return data;
	}

	/**
	 * rempli le tableau data a partir du fichier CSV.
	 */
	private void addData(List<String> lines) {

		// pour i inférieur à la taille de la liste<string> lines
		for (int i = 0; i < lines.size(); i++) {

			// le tableau de string nextline = le premier element de la liste lines converti
			// en tableau en prenant en compte le separateur
			String[] nextLine = lines.get(i).split(ParameterList.getUniqInstance().getSeparator());

			// si delette line == false
			if (deleteLine(nextLine) == false) {
				// rempli le tableau get data
				getData().add(nextLine);
			}
		}

	}

	private boolean deleteLine(String[] line) {

		// true si la ligne est différente de 5 ou 6
		return line.length != 5 && line.length != 6;
	}

	public CsvElementEchafReader getElRe() {
		return elRe;
	}

	private void setElRe(CsvElementEchafReader elRe) {
		this.elRe = elRe;
	}

	private InstanciationElement getInstanciation(String name) {

		EltByNameFactory eltF = new EltByNameFactory();
		InstanciationElement instanciation = null;
		EltByName elt = eltF.findEltByNameByName(name);

		// si elt différent de null
		if (elt != null)

			instanciation = elt.getIntanc();
		else {
			ChoixDuType ch = new ChoixDuType(eltF, name);
			ch.setVisible(true);

			if (ch.getEltN() != null)
				instanciation = ch.getEltN().getIntanc();
		}

		return instanciation;
	}

	private String getArguments(String[] args, Integer pos) {

		if (pos < args.length)
			return args[pos];
		return null;
	}

	private void createElement() {

		for (String[] args : getData()) {

			if (getInstanciation(
					args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.NAME)].trim()) != null) {

				String nom = getArguments(args, ParameterList.getUniqInstance().getParams().get(ParameterCsv.NAME));
				String constructeur = getArguments(args,
						ParameterList.getUniqInstance().getParams().get(ParameterCsv.CONSTRUCTEUR));
				String reference = getArguments(args,
						ParameterList.getUniqInstance().getParams().get(ParameterCsv.REFERENCE));
				String position = getArguments(args,
						ParameterList.getUniqInstance().getParams().get(ParameterCsv.POSITION));
				String poids = getArguments(args, ParameterList.getUniqInstance().getParams().get(ParameterCsv.POIDS));
				String surface = getArguments(args,
						ParameterList.getUniqInstance().getParams().get(ParameterCsv.SURFACE));

				CreateElement cE = new CreateElement(this,
						getInstanciation(
								args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.NAME)].trim()),
						nom, constructeur, reference, position, poids, surface);

				try {
					addElement(cE.getElement());
				} catch (Exception e) {
					e.printStackTrace(System.out);
					new AlertWindow(AlertType.ERREUR, "Element non créé");
				}
			}
		}

	}

	private void addElement(Element element) {
		getElements().add(element);
	}

	public List<Element> getElements() {
		if (elements == null)
			elements = new ArrayList<Element>();
		return elements;
	}

}
