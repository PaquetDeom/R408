package fr.paquet.test.projet;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.echafaudage.*;
import fr.paquet.projet.*;

public class DonneesTest {

	public Adresse getAdresseClient() throws Exception {
		Adresse adresseClient = new Adresse("        le grès  ", "   659      ", "      rue du Pastel       ", "",
				getCommune());
		return adresseClient;
	}

	public Adresse getAdresseChantier() throws Exception {
		Adresse adresseChantier = new Adresse("", " 2   ", " rue de la poupée qui tousse    ", "", getCommune());
		return adresseChantier;
	}

	public Client getClient() throws Exception {
		Client client = new Client(null, "            PaqUet-dEom  ", "        natHanel     ", getAdresseClient());
		return client;
	}

	public Constructeur getConstructeurUlma() {
		Constructeur const1 = new Constructeur("         ulMa");
		return const1;
	}

	public Constructeur getConstructeurLayer() {
		Constructeur const2 = new Constructeur("                  lAyer");
		return const2;
	}

	public ElementEchaf getEl1ec1() throws Exception {
		return new ElementEchaf(getConstructeurUlma(), TypeElement.equereGardeCoprs70.getName(), "001", TypeEchaf.TYPE1,
				1, 0, 1, TypeElement.equereGardeCoprs70);
	}

	public ElementEchaf getEl2ec1() throws Exception {
		return new ElementEchaf(getConstructeurUlma(), TypeElement.amarrageBaie.getName(), "002", TypeEchaf.TYPE1, 2, 0,
				1, TypeElement.amarrageBaie);
	}

	public ElementEchaf getEl3ec1() throws Exception {
		return new ElementEchaf(getConstructeurLayer(), TypeElement.gardeCorps70.getName(), "003", TypeEchaf.TYPE1, 5,
				0, 1, TypeElement.gardeCorps70);
	}

	public ElementEchaf getEl1ec2() throws Exception {
		return new ElementEchaf(getConstructeurLayer(), TypeElement.embasePoteaux.getName(), "004", TypeEchaf.TYPE2, 3,
				0, 0, TypeElement.embasePoteaux);
	}

	public ElementEchaf getEl2ec2() throws Exception {
		return new ElementEchaf(getConstructeurLayer(), TypeElement.plateau3.getName(), "005", TypeEchaf.TYPE2, 4, 10,
				1, TypeElement.plateau3);
	}

	public ElementEchaf getEl3ec2() throws Exception {
		return new ElementEchaf(getConstructeurLayer(), TypeElement.plateau3.getName(), "005", TypeEchaf.TYPE2, 4, 10,
				2, TypeElement.plateau3);
	}

	public ElementEchaf getEl4ec2() throws Exception {
		return new ElementEchaf(getConstructeurLayer(), TypeElement.equereGardeCoprs70.getName(), "006",
				TypeEchaf.TYPE2, 5, 0, 1, TypeElement.equereGardeCoprs70);
	}

	public Echafaudage getEchaf1() throws Exception {
		return new Echafaudage(getConstructeurUlma(), TypeEchaf.TYPE1, ClasseEchaf.CLASSE1, getElements1());
	}

	public Echafaudage getEchaf2() throws Exception {
		return new Echafaudage(getConstructeurLayer(), TypeEchaf.TYPE2, ClasseEchaf.CLASSE5, getElements2());
	}

	public Chantier getChantier1() throws Exception {
		Chantier chantier = new Chantier(getAdresseChantier(), getEchaf1());
		chantier.setiD(001);
		return chantier;
	}

	public Chantier getChantier2() throws Exception {
		Chantier chantier = new Chantier(null, getEchaf2());
		chantier.setiD(002);
		return chantier;
	}

	public Responsable getResp() {
		return new Responsable("          bouChard    ", "         geRard ");
	}

	public Projet getProjet1() throws Exception {
		return new Projet(null, "    pRojet1   ", getClient(), getChantier1(), getResp());
	}

	public Projet getProjet2() throws Exception {
		return new Projet(null, "      projEt2    ", getClient(), getChantier2(), getResp());
	}

	public Commune getCommune() throws Exception {
		Commune commune = new Commune("         81500     ", "          aMbreS   ");
		return commune;
	}

	public List<ElementEchaf> getElements1() throws Exception {

		List<ElementEchaf> elements1 = new ArrayList<ElementEchaf>();

		elements1.add(getEl1ec1());
		elements1.add(getEl2ec1());
		elements1.add(getEl3ec1());
		return elements1;
	}

	public List<ElementEchaf> getElements2() throws Exception {

		List<ElementEchaf> elements2 = new ArrayList<ElementEchaf>();

		elements2.add(getEl1ec2());
		elements2.add(getEl2ec2());
		elements2.add(getEl3ec2());
		elements2.add(getEl4ec2());
		return elements2;
	}

}
