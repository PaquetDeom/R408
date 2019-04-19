package fr.paquet.io.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

import fr.paquet.ihm.echaf.PanelEchafaudage;

public class CsvElementEchafReader {

	private PanelEchafaudage pEchaf = null;
	private File file = null;

	/**
	 * Constructeur
	 * 
	 * @param pEchaf
	 * @param file
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public CsvElementEchafReader(PanelEchafaudage pEchaf, File file) throws Exception {

		super();

		setFile(file);

		setPanelEchafaudage(pEchaf);
		// FileReader fr = new FileReader(getFile());
		// TODO Récupérer l'encodage du fichier csv (UTF8, 16...)

		BufferedReader buff;
		buff = new BufferedReader(new InputStreamReader(new FileInputStream(getFile()), "UTF-16"));

		// Création de la liste de String une String par ligne
		addLines(buff);

		buff.close();

	}

	private void setPanelEchafaudage(PanelEchafaudage pEchaf) {
		this.pEchaf = pEchaf;
	}

	private List<String> lines = null;

	private void addLines(BufferedReader buff) {
		try {

			int ligneVide = 0;
			while (ligneVide < 20) {

				// lit 1 ligne du fichier CSV et rempli un tableau de String correspondant aux
				// zones de la ligne
				String ligne = buff.readLine();

				if (ligne == null || ligne.trim().length() == 0)
					ligneVide++;

				else {

					getLines().add(ligne);
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> getLines() {
		if (lines == null)
			lines = new ArrayList<String>();
		return lines;
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
