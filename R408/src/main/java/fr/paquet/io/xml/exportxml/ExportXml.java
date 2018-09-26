package fr.paquet.io.xml.exportxml;

import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import fr.paquet.ihm.echaf.FileChooser;
import fr.paquet.projet.Projet;

public class ExportXml {

	/**
	 * 
	 * @param projet
	 * @throws Exception
	 *             liée au flux dans un fichier
	 */
	public ExportXml(Projet projet) throws Exception {
		super();

		FileChooser fc = new FileChooser(null);

		// Instanciation de l'objet XStream
		XStream xs = new XStream(new DomDriver("UTF-8"));
		// xstream détecte automatiquement les annotations
		xs.autodetectAnnotations(true);

		// Ouverture d'un flux sur un fichier
		FileOutputStream fs;
		fs = new FileOutputStream(fc.getSelectedFile()+".xml");
		xs.toXML(projet, fs);
		fs.close();

	}

}
