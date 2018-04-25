package fr.paquet.ihm.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import fr.paquet.ihm.alert.AlertWindow;
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File("/home/paquet/git/R408/R408/src/images/echafaudage.jpeg"));
		} catch (IOException e) {
			new AlertWindow("Erreur", e.getMessage());
			e.printStackTrace(System.out);
		}

		g.drawImage(img.getScaledInstance(getWidth(), -1, Image.SCALE_SMOOTH), 0, 0, null);
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
