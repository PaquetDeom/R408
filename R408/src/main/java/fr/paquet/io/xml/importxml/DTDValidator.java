package fr.paquet.io.xml.importxml;

import java.io.File;

import javax.validation.Validator;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class DTDValidator {

	public DTDValidator(File xmlFile) throws SAXException {
		super();

		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.XML_DTD_NS_URI);

		Schema schema = schemaFactory.newSchema(new File("/target/classes/ressources/dtd/Projet.dtd"));

		Validator validator = (Validator) schema.newValidator();
		validator.validate(new StreamSource(xmlFile));
	}

}
