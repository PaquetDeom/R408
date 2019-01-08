package fr.paquet.io.jrxml;

import java.sql.SQLException;
import java.util.HashMap;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Projet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GeneratePDF {

	private Projet projet = null;
	private HashMap parameters = null;

	public GeneratePDF(Projet projet) {
		super();
		setProjet(projet);

		// création des paramètres
		addParameters("titre", getProjet().getTitre());

		// Création du rapport
		CreateReport();

	}

	private void addParameters(String key, String value) {

		getParameters().put(key, value);

	}

	private HashMap getParameters() {
		if (parameters == null)
			parameters = new HashMap();
		return parameters;
	}

	public Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {
		this.projet = projet;
	}

	@SuppressWarnings("unchecked")
	private void CreateReport() {

		// - Chargement et compilation du rapport
		JasperDesign jasperDesign;
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport("./target/classes/jrxml/classic.jrxml");
			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, getParameters());

			// - Création du rapport au format PDF
			JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/nath/Documents/R408/RapportPdf/Rapport.pdf");

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Le rapport n'a pas été généré");
		}

	}
}
