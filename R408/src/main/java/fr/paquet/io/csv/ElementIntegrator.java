package fr.paquet.io.csv;

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
import fr.paquet.io.csv.CsvElementEchafReader;

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

		for (int i = 0; i < lines.size(); i++) {
			String[] nextLine = lines.get(i).split(ParameterList.getUniqInstance().getSeparator());
			if (nextLine != null && nextLine.length != 0) {
				if (!nextLine[0].trim().equals("") && !nextLine[0].trim().equals(":")
						&& !nextLine[0].trim().equals(ParameterList.getUniqInstance().getSeparator()))
					// ajoute nextline à data
					getData().add(nextLine);
			}
		}

	}

	private CsvElementEchafReader getElRe() {
		return elRe;
	}

	private void setElRe(CsvElementEchafReader elRe) {
		this.elRe = elRe;
	}

	private void createElement() {

		for (String[] args : getData()) {

			String name = args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.NAME)].trim();

			EltByNameFactory eltF = new EltByNameFactory();
			InstanciationElement instanciation = null;
			EltByName elt = eltF.findEltByNameByName(name);

			if (elt != null)
				instanciation = elt.getIntanc();
			else {
				ChoixDuType ch = new ChoixDuType(eltF, name);
				ch.setVisible(true);

				if (ch.getEltN() != null)
					instanciation = ch.getEltN().getIntanc();
			}

			if (instanciation != null) {

				String reference = null;
				Constructeur constructeur = null;
				TypeEchaf type = null;
				double poids = 0.0;
				double surface = 0.0;
				double longueur = 0.0;
				int position = 0;

				constructeur = new Constructeur(
						args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.CONSTRUCTEUR)]);

				if (getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier()
						.getEchafaudage().getConstructeur() == null)
					getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier()
							.getEchafaudage().setConstructeur(constructeur);

				reference = args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.REFERENCE)];

				// définition de la position de l'élément dans l'échafaudage
				String[] a = args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.POSITION)].split(" ");

				if (a.length > 1)
					position = Integer.parseInt(a[1]);
				else
					position = 0;

				// définition du poids de l'élément
				if (!args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.POIDS)].equals("")) {
					char[] tab = args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.POIDS)]
							.toCharArray();
					for (int i = 0; i < tab.length; i++) {
						if (tab[i] == ',')
							tab[i] = '.';
					}

					poids = Double.parseDouble(String.valueOf(tab));
				}

				// définition de la surface
				if (args.length >= 6
						&& !args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.SURFACE)].equals("")) {
					String surf[] = args[ParameterList.getUniqInstance().getParams().get(ParameterCsv.SURFACE)]
							.split(" ");
					char[] tab1 = surf[0].toCharArray();
					for (int i = 0; i < tab1.length; i++) {
						if (tab1[i] == ',')
							tab1[i] = '.';
					}
					surface = Double.parseDouble(String.valueOf(tab1));
				}

				// définition de la longueur
				String[] lon = name.split(" ");
				if (lon.length > 1) {
					if (lon[lon.length - 1].equals("m"))
						longueur = Double.parseDouble(lon[lon.length - 2]);

				}

				// creation de l'élément
				Element el = null;
				try {
					el = new Element(
							getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier()
									.getEchafaudage(),
							instanciation.instanciationElt(name, reference, constructeur, poids, type, surface,
									longueur),
							instanciation, position);

					addElement(el);

				} catch (Exception e) {
					new AlertWindow(AlertType.ERREUR, "L'élément n'a pas été créé");
					e.printStackTrace(System.out);
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
