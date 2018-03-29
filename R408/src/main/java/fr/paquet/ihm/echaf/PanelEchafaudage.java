package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EnumSet;
import java.util.Hashtable;

import javax.swing.*;

import fr.paquet.echafaudage.ClasseEchaf;
import fr.paquet.echafaudage.TypeSol;

public class PanelEchafaudage extends JPanel implements PropertyChangeListener {

	public class JButtonCalcul extends JButton implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JButtonCalcul() {
			super();
			setText("Lancer le calcul");
			setEnabled(true);
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class JButtonChooser extends JButton implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JButtonChooser() {
			super();
			setText("Choisir un fichier");
			setEnabled(true);
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new FileChooser();
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelProjet panelProjet = null;
	private Hashtable<String, JCheckBox> HClasse = new Hashtable<String, JCheckBox>();
	private Hashtable<String, JCheckBox> HType = new Hashtable<String, JCheckBox>();

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelProjet
	 */
	public PanelEchafaudage(JPanelProjet panelProjet) {
		super();
		setPanelProjet(panelProjet);

		// Ajout d'un layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		setLayout(gridBagLayout);

		// listener
		getPanelProjet().getOnglet().getProjet().addPropertyChangeListener(this);

		// titre du panel
		add(new JLabel("Données de l'echafaudage"), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

		int gridx = 0;
		int gridy = 1;
		// type d'échafaudage
		add(new JLabel("Type d'échafaudage en fonction de la charge"), new GridBagConstraints(0, gridy, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
		gridy = gridy + 1;

		for (ClasseEchaf cl : EnumSet.allOf(ClasseEchaf.class)) {

			putHClasse(cl.getClasse(), new JCheckBox(cl.getClasse()));

			new AddLineJCheckBox(this, getHClasse().get(cl.getClasse()), gridx, gridy, 1, 1, 0, 0,
					GridBagConstraints.BOTH);
			gridy = gridy + 1;
		}

		gridx = gridx + 1;
		gridy = 1;
		// type de sol
		add(new JLabel("Type de sol"), new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
		gridy = gridy + 1;

		for (TypeSol ts : EnumSet.allOf(TypeSol.class)) {

			putHType(ts.getType(), new JCheckBox(ts.getType()));

			new AddLineJCheckBox(this, getHType().get(ts.getType()), gridx, gridy, 1, 1, 0, 0, GridBagConstraints.BOTH);
			gridy = gridy + 1;
		}

		// fichier *.csv
		add(new JButtonChooser(), new GridBagConstraints(gridx + 1, gridy, 1, 1, 1, 1,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

		// button calcul
		add(new JButtonCalcul(), new GridBagConstraints(gridx + 1, gridy + 1, 1, 1, 1, 1,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

	}

	private void putHClasse(String titre, JCheckBox box) {

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO

			}
		});

		getHClasse().put(titre, box);
	}

	private void putHType(String titre, JCheckBox box) {

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		getHType().put(titre, box);
	}

	private Hashtable<String, JCheckBox> getHClasse() {
		return HClasse;
	}

	private Hashtable<String, JCheckBox> getHType() {
		return HType;
	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}

	private void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
