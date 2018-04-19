package fr.paquet.ihm.main;

import java.util.*;

import javax.swing.*;

import fr.paquet.ihm.echaf.*;

@SuppressWarnings("serial")
public class MainOnglet extends JTabbedPane {

	private static MainOnglet onglet = null;
	private List<OngletProjet> onglets = null;

	/**
	 * Constructeur de la class private car ne doit etre instanciee qu une fois<br/>
	 * 
	 * 
	 */
	private MainOnglet() {
		super(SwingConstants.TOP);
		setOnglets(new ArrayList<OngletProjet>());

	}

	private void setOnglets(ArrayList<OngletProjet> onglets) {
		this.onglets = onglets;
	}

	/**
	 * 
	 * @return Le main onglet unique<br/>
	 * 
	 */
	public static MainOnglet getUniqInstance() {
		if (onglet == null) {
			onglet = new MainOnglet();
		}
		return onglet;
	}

	public List<OngletProjet> getOnglets() {
		return onglets;
	}

	public void addOnglet(OngletProjet onglet) {
		getOnglets().add(onglet);
	}

}
