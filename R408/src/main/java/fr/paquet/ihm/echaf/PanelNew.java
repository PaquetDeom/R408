package fr.paquet.ihm.echaf;

import java.awt.Dimension;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelNew extends JPanel {

	private LayoutEntete layoutEntete = null;
	private LayoutParam layoutParam = null;
	private LayoutFCalcul layoutFCalcul = null;

	private JTextField titreField = null;

	public PanelNew() {

		setPreferredSize(new Dimension(1800, 900));

		setLayout(getLayoutEntete());
		setLayout(getLayoutParam());
		setLayout(getLayoutFCalcul());

		add(new JLabel("Veuillez saisir le Titre du document"));
		add(getTitreField(), getLayoutEntete());

	}

	public JTextField getTitreField() {
		if (titreField == null) {
			titreField = new JTextField();
			titreField.setText("saisir le titre");
		}
		return titreField;
	}

	/**
	 * 
	 * @return Le titre du document<br/>
	 */
	public String getTitre() {
		if (getTitreField() == null)
			return null;
		return getTitreField().getText();
	}

	public LayoutEntete getLayoutEntete() {
		if (layoutEntete == null)
			layoutEntete = new LayoutEntete();
		return layoutEntete;
	}

	public LayoutParam getLayoutParam() {
		if (layoutParam == null)
			layoutParam = new LayoutParam();
		return layoutParam;
	}

	public LayoutFCalcul getLayoutFCalcul() {
		if (layoutFCalcul == null)
			layoutFCalcul = new LayoutFCalcul();
		return layoutFCalcul;
	}

}
