package fr.paquet.io.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import fr.paquet.echafaudage.ElementEchafaudage;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.PanelEchafaudage;

public class CsvElementEchafReader {

	private PanelEchafaudage pEchaf = null;
	private File file = null;
	private static String SEPARATOR = ";";
	private List<String[]> data = new ArrayList<String[]>();

	/**
	 * Constructeur
	 * 
	 * @param pEchaf
	 * @param file
	 * @throws Exception
	 */
	public CsvElementEchafReader(PanelEchafaudage pEchaf, File file) throws Exception {

		super();
		setFile(file);
		setPanelEchafaudage(pEchaf);
		//FileReader fr = new FileReader(getFile());
		//TODO Récupérer l'encodage du fichier csv (UTF8, 16...)
		BufferedReader buff=new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-16"));
		addData(buff);
		buff.close();
	}

	private void setPanelEchafaudage(PanelEchafaudage pEchaf) {
		this.pEchaf = pEchaf;
	}

	public List<String[]> getData() {
		if (data == null)
			data = new ArrayList<String[]>();
		return data;
	}

	/**
	 * rempli le tableau data a partir du fichier CSV.
	 */
	private void addData(BufferedReader buff) {
		try {
			int ligneVide = 0;
			while (ligneVide < 20) {

				// lit 1 ligne du fichier CSV et rempli un tableau de String correspondant aux
				// zones de la ligne
				String ligne=buff.readLine();

				// si la ligne n'existe pas on ajoute 1 au nombre de ligne vide
				String[] nextLine=null;
				if (ligne == null || ligne.trim().length()==0 ||  (nextLine=ligne.split(SEPARATOR)).length==0)
					ligneVide++;

				else {
					// on réinitialise le nombre de ligne vide
					ligneVide = 0;

					String debut = nextLine[0].trim();
					// si le 1ier element de la ligne ne commence par par <<vide>> ou par :
					if (!debut.equals("") && !debut.equals(":"))
						// pour chaque element de Echafaudage
						for (ElementEchafaudage elt : EnumSet.allOf(ElementEchafaudage.class)) {
							// si le 1ier élement de la ligne egale le nom de l'element de l'échafaudage
							if (nextLine[0].equals(elt.getName()))
								// jajoute le tableau de string à data
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
