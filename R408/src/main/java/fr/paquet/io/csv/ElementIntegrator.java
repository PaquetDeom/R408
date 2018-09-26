package fr.paquet.io.csv;

import java.util.*;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.ElementEchaf;
import fr.paquet.echafaudage.TypeEchaf;
import fr.paquet.echafaudage.TypeElement;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.io.csv.CsvElementEchafReader;

public class ElementIntegrator {

	private CsvElementEchafReader elRe = null;
	private List<ElementEchaf> elements = null;

	public ElementIntegrator(CsvElementEchafReader csvElementEchafReader) {
		setElRe(csvElementEchafReader);
		try {
			createElement();
		} catch (Exception e) {

			new AlertWindow(AlertType.ERREUR, e.getMessage());
			e.printStackTrace(System.out);
		}
	}

	private CsvElementEchafReader getElRe() {
		return elRe;
	}

	private void setElRe(CsvElementEchafReader elRe) {
		this.elRe = elRe;
	}

	private void createElement() throws Exception {

		for (String[] args : getElRe().getData()) {

			Constructeur constructeur = new Constructeur(args[1]);

			if (getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage()
					.getConstructeur() == null)
				getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage()
						.setConstructeur(constructeur);
			String name = args[0];

			TypeElement tElement = null;
			for (TypeElement tE : EnumSet.allOf(TypeElement.class)) {
				String string = tE.getName();
				if (name.equals(string))
					tElement = tE;
			}

			String reference = args[2];
			TypeEchaf type = null;
			double poids = 0.0;
			double surface = 0.0;
			int position = 0;

			String[] a = args[3].split(" ");

			if (a.length > 1)
				position = Integer.parseInt(a[1]);
			else
				position = 0;

			if (!args[4].equals("")) {
				char[] tab = args[4].toCharArray();
				for (int i = 0; i < tab.length; i++) {
					if (tab[i] == ',')
						tab[i] = '.';
				}
				poids = Double.parseDouble(String.valueOf(tab));
			}

			if (args.length >= 6 && !args[5].equals("")) {
				String surf[] = args[5].split(" ");
				char[] tab1 = surf[0].toCharArray();
				for (int i = 0; i < tab1.length; i++) {
					if (tab1[i] == ',')
						tab1[i] = '.';
				}
				surface = Double.parseDouble(String.valueOf(tab1));
			}

			ElementEchaf el = new ElementEchaf(constructeur, name, reference, type, poids, surface, tElement);
			getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage()
					.setPositionDesElements(el, position);
			addElement(el);
		}

	}

	private void addElement(ElementEchaf element) {
		getElements().add(element);
	}

	public List<ElementEchaf> getElements() {
		if (elements == null)
			elements = new ArrayList<ElementEchaf>();
		return elements;
	}

}
