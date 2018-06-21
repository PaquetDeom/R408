package fr.paquet.io.xml.exportxml;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * @author paquet
 *
 */

public abstract class XMLFileIntegration {
	
	
	private Document doc = null;

	//instancie la variable avec le doc.xml
	public XMLFileIntegration(Document doc) {
		this.setDoc(doc);
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

	public abstract void integre(String rne) throws Exception;

}
