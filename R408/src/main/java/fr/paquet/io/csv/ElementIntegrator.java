package fr.paquet.io.csv;

import java.util.*;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.ElementEchaf;
import fr.paquet.echafaudage.TypeEchaf;
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

			new AlertWindow("Erreur", e.getMessage());
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
			String reference = args[2];
			TypeEchaf type = null;
			double poids = 0.0;
			double surface = 0.0;
			int position = 0;

			if (!args[3].equals("Plateau 1") && !args[3].equals("Plateau 2")) {
				position = 0;
			} else {
				if (args[3].equals("Plateau 1"))
					position = 2;
				if (args[3].equals("Plateau 2"))
					position = 1;
			}

			if (!args[4].equals("")) {
				char[] tab = args[4].toCharArray();
				for (int i = 0; i < tab.length; i++) {
					if (tab[i] == ',')
						tab[i] = '.';
				}
				poids = Double.parseDouble(String.valueOf(tab));
			}

			if (!args[5].equals("")) {
				String surf[] = args[5].split(" ");
				char[] tab1 = surf[0].toCharArray();
				for (int i = 0; i < tab1.length; i++) {
					if (tab1[i] == ',')
						tab1[i] = '.';
				}
				surface = Double.parseDouble(String.valueOf(tab1));
			}

			addElement(new ElementEchaf(constructeur, name, reference, type, poids, position));
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
