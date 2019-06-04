package fr.paquet.io.csv.integrator;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.element.Element;
import fr.paquet.echafaudage.element.InstanciationElement;
import fr.paquet.echafaudage.element.TypeElement;

public class CreateElement {

	private ElementIntegrator elementIntegrator = null;
	private String name = null;
	private String reference = null;
	private Constructeur constructeur = null;
	private InstanciationElement instanciation = null;
	private double poids = 0.0;
	private double surface = 0.0;
	private int position = 0;

	public CreateElement(ElementIntegrator elI, InstanciationElement instanciation, String name, String constructeur,
			String reference, String position, String poids, String surface) {

		this(elI, instanciation, name, constructeur, reference, position, poids);

		setSurface(surface);
	}

	public CreateElement(ElementIntegrator elI, InstanciationElement instanciation, String name, String constructeur,
			String reference, String position, String poids) {

		super();
		setElementIntegrator(elI);
		setInstanciation(instanciation);
		setName(name);
		setConstructeur(constructeur);
		setReference(reference);
		setPosition(position);
		setPoids(poids);

	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {

		Constructeur cons = new Constructeur(constructeur);

		if (getElementIntegrator().getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getConstructeur() == null)
			getElementIntegrator().getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet()
					.getChantier().getEchafaudage().setConstructeur(cons);

		this.constructeur = cons;
	}

	private ElementIntegrator getElementIntegrator() {
		return elementIntegrator;
	}

	private void setElementIntegrator(ElementIntegrator elementIntegrator) {
		this.elementIntegrator = elementIntegrator;
	}

	private InstanciationElement getInstanciation() {
		return instanciation;
	}

	private void setInstanciation(InstanciationElement instanciation) {
		this.instanciation = instanciation;
	}

	public int getPosition() {
		return position;
	}

	private void setPosition(String positionString) {

		String[] a = positionString.split(" ");
		int position = 0;

		if (a.length > 1)
			position = Integer.parseInt(a[1]);
		else
			position = 0;

		this.position = position;
	}

	public double getLongueur() {

		double longueur = 0.0;
		String[] lon = getName().split(" ");
		if (lon.length > 1) {
			if (lon[lon.length - 1].equals("m"))
				longueur = Double.parseDouble(lon[lon.length - 2]);

		}

		return longueur;
	}

	public double getSurface() {
		return surface;
	}

	private void setSurface(String surfaceString) {

		double surface = 0.0;
		String surf[] = surfaceString.split(" ");

		char[] tab1 = surf[0].toCharArray();
		for (int i = 0; i < tab1.length; i++) {
			if (tab1[i] == ',')
				tab1[i] = '.';

			surface = Double.parseDouble(String.valueOf(tab1));
		}

		this.surface = surface;
	}

	public double getPoids() {
		return poids;
	}

	private void setPoids(String poidsString) {

		double poids = 0.0;

		if (!poidsString.equals("")) {
			char[] tab = poidsString.toCharArray();
			for (int i = 0; i < tab.length; i++) {
				if (tab[i] == ',')
					tab[i] = '.';
			}

			poids = Double.parseDouble(String.valueOf(tab));
		}

		this.poids = poids;
	}

	public TypeElement getType() {
		return getInstanciation().instanciationElt(getName(), getReference(), getConstructeur(), getPoids(),
				getElementIntegrator().getElRe().getPanelEchafaudage().getPanelProjet().getOnglet().getProjet()
						.getChantier().getEchafaudage().getTypeEchaf(),
				getSurface(), getLongueur());
	}

	public Element getElement() throws Exception {

		return new Element(getElementIntegrator().getElRe().getPanelEchafaudage().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage(), getType(), getInstanciation(), getPosition());
	}

}
