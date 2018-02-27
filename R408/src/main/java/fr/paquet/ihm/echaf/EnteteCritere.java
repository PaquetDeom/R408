package fr.paquet.ihm.echaf;

import java.awt.FlowLayout;
import java.util.EnumSet;

import javax.swing.*;

public enum EnteteCritere {

	TITRE, NOMCLIENT, PRENOMCLIENT, ADRESSECHANTIER, CPCHANTIER, VILLECHANTIER, NOMRESPETUDE, PRENOMRESPETUDE;

	public static EnteteCritere getEnteteCritere(String name) {
		for (EnteteCritere ent : EnumSet.allOf(EnteteCritere.class)) {
			if (ent.getName().equals(name.toUpperCase()))
				;
			return ent;
		}
		return null;
	}

	public String getName() {
		switch (this) {
		case TITRE:
			return "TITRE";
		case NOMCLIENT:
			return "NOM";
		case PRENOMCLIENT:
			return "PRENOM";
		case ADRESSECHANTIER:
			return "ADRESSE";
		case CPCHANTIER:
			return "CP";
		case VILLECHANTIER:
			return "VILLE";
		case NOMRESPETUDE:
			return "NOMRESP";
		case PRENOMRESPETUDE:
			return "PRERESP";
		}
		return null;
	}

	public void actionPerf() {
		switch (this) {
		case TITRE:
			System.out.println("c bon");
			break;
		case NOMCLIENT:
			break;
		case PRENOMCLIENT:
			break;
		case ADRESSECHANTIER:
			break;
		case CPCHANTIER:
			break;
		case VILLECHANTIER:
			break;
		case NOMRESPETUDE:
			break;
		case PRENOMRESPETUDE:
			break;
		}

	}

	public JLabel getLabel() {
		switch (this) {
		case TITRE:
			return new JLabel("Titre du document");
		case NOMCLIENT:
			return new JLabel("Nom du client");
		case PRENOMCLIENT:
			return new JLabel("Prenom du client");
		case ADRESSECHANTIER:
			return new JLabel("Adresse du chantier");
		case CPCHANTIER:
			return new JLabel("Code postal");
		case VILLECHANTIER:
			return new JLabel("Ville du chantier");
		case NOMRESPETUDE:
			return new JLabel("Nom du responsable du projet");
		case PRENOMRESPETUDE:
			return new JLabel("Prenom du responsable du projet");
		}
		return null;
	}

	public JTextField getSaisi() {
		switch (this) {
		case TITRE:
			JTextField titreField = new JTextField(20);
			titreField.setName("TITRE");
			return titreField;
		case NOMCLIENT:
			JTextField nomField = new JTextField(20);
			nomField.setName("NOM");
			return nomField;
		case PRENOMCLIENT:
			JTextField prenomField = new JTextField(20);
			prenomField.setName("PRENOM");
			return prenomField;
		case ADRESSECHANTIER:
			JTextField adresseField = new JTextField(20);
			adresseField.setName("ADRESSE");
			return adresseField;
		case CPCHANTIER:
			JTextField cpField = new JTextField(20);
			cpField.setName("CP");
			return cpField;
		case VILLECHANTIER:
			JTextField villeField = new JTextField(20);
			villeField.setName("VILLE");
			return villeField;
		case NOMRESPETUDE:
			JTextField nomRespField = new JTextField(20);
			nomRespField.setName("NOMRESP");
			return nomRespField;
		case PRENOMRESPETUDE:
			JTextField prenomRespField = new JTextField(20);
			prenomRespField.setName("PRENOMRESP");
			return prenomRespField;
		}
		return null;
	}

	public FlowLayout getLayout() {
		switch (this) {
		case TITRE:
			return new FlowLayout(FlowLayout.RIGHT);
		case NOMCLIENT:
			return new FlowLayout(FlowLayout.RIGHT);
		case PRENOMCLIENT:
			return new FlowLayout(FlowLayout.RIGHT);
		case ADRESSECHANTIER:
			return new FlowLayout(FlowLayout.RIGHT);
		case CPCHANTIER:
			return new FlowLayout(FlowLayout.RIGHT);
		case VILLECHANTIER:
			return new FlowLayout(FlowLayout.RIGHT);
		case NOMRESPETUDE:
			return new FlowLayout(FlowLayout.RIGHT);
		case PRENOMRESPETUDE:
			return new FlowLayout(FlowLayout.RIGHT);
		}
		return null;
	}
}
