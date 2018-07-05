package fr.paquet.io.xml.importxml;

import java.io.File;
import org.w3c.dom.Element;

public class ProjetIntegration extends XMLFileIntegration {

	public ProjetIntegration(File xmlFile) {
		super(xmlFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void integre() throws Exception {

		for (Element elt : getElements("projet")) {
			System.out.println("c ok");
		}

	}

}
