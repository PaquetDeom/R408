package fr.paquet.io.xml.importxml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import fr.paquet.ihm.alert.AlertWindow;

/**
 * 
 * @author paquet
 *
 */

public abstract class XMLFileIntegration {

	private Document doc = null;

	public XMLFileIntegration(File xmlFile) {

		// Nous récupérons une instance de factory qui se chargera de nous fournir
		// un parseur
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Création de notre parseur via la factory
		DocumentBuilder builder = null;

		try {
			builder = factory.newDocumentBuilder();

			// parsing de notre fichier via un objet File et récupération d'un
			// objet Document
			// Ce dernier représente la hiérarchie d'objet créée pendant le parsing
			Document doc = builder.parse(xmlFile);

			this.setDoc(doc);

		} catch (SAXException | IOException | ParserConfigurationException e) {

			e.printStackTrace(System.out);
			new AlertWindow("Erreur", "Fichier non conforme");

		}

	}

	protected Document getDoc() {
		return doc;
	}

	protected void setDoc(Document doc) {
		this.doc = doc;
	}

	/**
	 * 
	 * @param nodeName
	 * @return la liste des éléments a partir do doc.xml
	 */
	protected ArrayList<Element> getElements(String nodeName) {
		ArrayList<Element> list = new ArrayList<Element>();
		RecursiveNodes.getNodes(getDoc(), list, nodeName);
		return list;
	}

	public abstract void integre(String projet) throws Exception;

}
