package fr.paquet.io.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import au.com.bytecode.opencsv.CSVReader;
import fr.paquet.echafaudage.ElementEchafaudage;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.PanelEchafaudage;

public class CsvElementEchafReader {

	private PanelEchafaudage pEchaf = null;
	private File file = null;
	private static char SEPARATOR = ';';
	private CSVReader csvReader = null;
	private List<String[]> data = new ArrayList<String[]>();

	public CsvElementEchafReader(PanelEchafaudage pEchaf, File file) throws Exception {

		super();
		setFile(file);
		setPanelEchafaudage(pEchaf);
		FileReader fr = new FileReader(getFile());
		setCsvReader(new CSVReader(fr, SEPARATOR));
		addData();
	}

	private void setPanelEchafaudage(PanelEchafaudage pEchaf) {
		this.pEchaf = pEchaf;
	}

	private void setCsvReader(CSVReader cReader) {
		this.csvReader = cReader;
	}

	private CSVReader getCsvReader() {
		return csvReader;
	}

	public List<String[]> getData() {
		if (data == null)
			data = new ArrayList<String[]>();
		return data;
	}

	private void addData() {

		String[] nextLine = null;

		try {

			int ligneVide = 0;
			while (ligneVide < 20) {

				nextLine = getCsvReader().readNext();
				int size = 0;

				if (nextLine != null)
					size = nextLine.length;

				if (nextLine == null || size < 5)
					ligneVide = ligneVide + 1;

				else {

					ligneVide = 0;

					for (int i = 0; i < nextLine.length; i++) {
						String ligne = nextLine[i];
						char[] tab = ligne.toCharArray();

						for (int n = 0; n < tab.length; n++) {
							if (n == 0)
								ligne = new String();
							if (n != 0 && n % 2 != 0) {
								ligne = ligne + tab[n];
							}
						}

						nextLine[i] = ligne;

					}

					String debut = nextLine[0].trim();
					if (debut.equals("") || debut.equals(":"))
						continue;

					for (ElementEchafaudage elt : EnumSet.allOf(ElementEchafaudage.class)) {
						if (nextLine[0].equals(elt.getName()))
							getData().add(nextLine);
					}

				}

			}

		} catch (

		IOException e) {
			new AlertWindow("Erreur", e.getMessage());
			e.printStackTrace(System.out);
		}
	}

	/**
	 * 
	 * @return Le panelEchaf du projet en cours<br/>
	 */
	public PanelEchafaudage getPanelEchafaudage() {
		return pEchaf;
	}

	private File getFile() {
		return file;
	}

	private void setFile(File file) throws Exception {

		// On récupere le chemin du fichier selectionné
		String fichierSelect = file.toString();

		System.out.println("Nom du fichier : " + fichierSelect);
		// si l'utilisateur a entré un point
		if (fichierSelect.lastIndexOf(".") > 0) {
			// On récupère l'extension du fichier
			String ext = fichierSelect.substring(fichierSelect.lastIndexOf("."));
			// Si le fichier n'est pas en .csv on renvoie une exception
			// Sinon on mutte la variable file
			if (!ext.equals(".csv")) {
				throw new Exception("Le fichier sélectionné n'est pas un *.csv");
			} else {
				this.file = file;
			}
		}

	}

}
