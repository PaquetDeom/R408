package fr.paquet.io.jrxml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import fr.paquet.echafaudage.Arrondi;
import fr.paquet.echafaudage.element.InstanciationElement;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.FileChooser;
import fr.paquet.projet.Projet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;

public class GeneratePDF implements AlertListener {

	private Projet projet = null;
	private HashMap<String, Object> parameters = null;

	public GeneratePDF(Projet projet) throws Exception {
		super();
		setProjet(projet);

		// création des paramètres
		addParameters("titre", getProjet().getTitre());
		addParameters("url", getProjet().getUrl());
		addParameters("nomResponsable", getProjet().getResp().getNom());
		addParameters("prenomResponsable", getProjet().getResp().getPrenom());

		addParameters("nomClient", getProjet().getClient().getNom());
		addParameters("prenomClient", getProjet().getClient().getPrenom());
		addParameters("add1Client", getProjet().getClient().getAdresse().getAdresse1());
		addParameters("add2Client", getProjet().getClient().getAdresse().getAdresse2());
		addParameters("add3Client", getProjet().getClient().getAdresse().getAdresse3());
		addParameters("add4Client", getProjet().getClient().getAdresse().getAdresse4());
		addParameters("addCodeComClient", getProjet().getClient().getAdresse().getCodeCommune());
		addParameters("add1ComClient", getProjet().getClient().getAdresse().getCom());
		addParameters("addTelClient", getProjet().getClient().getAdresse().getTel());
		addParameters("addMailClient", getProjet().getClient().getAdresse().getMail());

		addParameters("add1Chantier", getProjet().getChantier().getAdresse().getAdresse1());
		addParameters("add2Chantier", getProjet().getChantier().getAdresse().getAdresse2());
		addParameters("add3Chantier", getProjet().getChantier().getAdresse().getAdresse3());
		addParameters("add4Chantier", getProjet().getChantier().getAdresse().getAdresse4());
		addParameters("addCodeComChantier", getProjet().getChantier().getAdresse().getCodeCommune());
		addParameters("addComChantier", getProjet().getChantier().getAdresse().getCom());

		addParameters("constructeur", getProjet().getChantier().getEchafaudage().getConstructeur().getName());
		addParameters("typeEchaf", getProjet().getChantier().getEchafaudage().getTypeEchaf().getType());
		addParameters("typeSol", getProjet().getChantier().getEchafaudage().getTypeSol().getType());
		addParameters("classeEchaf", getProjet().getChantier().getEchafaudage().getClasseEchaf().getClasse());

		addParameters("pPropre",
				Arrondi.getDoubleArrondi(getProjet().getChantier().getEchafaudage().getPoidsPropre(), 2));
		addParameters("cExploitation",
				Arrondi.getDoubleArrondi(getProjet().getChantier().getEchafaudage().getChargeExploitation(), 2));
		addParameters("pParPied",
				Arrondi.getDoubleArrondi(getProjet().getChantier().getEchafaudage().getChargeParPied(), 2));
		addParameters("dCale",
				Arrondi.getDoubleArrondi(getProjet().getChantier().getEchafaudage().getDimensionCale(), 2));

		addParameters("socleReglable",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.socleReglable));
		addParameters("plinthe",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.plinthe));
		addParameters("amarrageBaie",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.amarrageBaie));
		addParameters("embasePoteaux",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.embasePoteaux));
		addParameters("equerreGardesCorps", getProjet().getChantier().getEchafaudage().getElementEchafs()
				.get(InstanciationElement.equerreGardeCorps));
		addParameters("plateau",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.plateau));
		addParameters("jambeDeForce",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.jambeForce));
		addParameters("plancherTrappe",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.plancherTrappe));
		addParameters("poteau",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.poteau));
		addParameters("verinDeButtee",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.verinDeButtee));
		addParameters("lisse",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.lisse));
		addParameters("gardeCorps",
				getProjet().getChantier().getEchafaudage().getElementEchafs().get(InstanciationElement.gardeCorps));

		// Création du rapport
		CreateReport();

	}

	private void addParameters(String key, Object value) {

		getParameters().put(key, value);

	}

	private HashMap<String, Object> getParameters() {
		if (parameters == null)
			parameters = new HashMap<String, Object>();
		return parameters;
	}

	public Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {
		this.projet = projet;
	}

	private void CreateReport() throws Exception {

		// - Chargement et compilation du rapport
		// JasperDesign jasperDesign;
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport("./target/classes/jrxml/classic.jrxml");
			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			// - Execution du rapport
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, getParameters());

			// - Enregistrement du rapport au format PDF
			FileChooser fc = new FileChooser();
			JasperExportManager.exportReportToPdfFile(jasperPrint, fc.getSelectedFile().getAbsolutePath());

		// T'EN ES LA
			//JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/nath/Documents/R408/RapportPdf/Rapport.pdf");

			new AlertWindow(AlertType.QUESTION, "Rapport créé Voulez-vous le voir ?", this);

		} catch (JRException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Le rapport n'a pas été généré");
		}

	}

	@Override
	public void buttonClick(String button) {
		// TODO Auto-generated method stub

	}
}
