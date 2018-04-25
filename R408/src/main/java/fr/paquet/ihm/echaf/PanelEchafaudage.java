package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.echafaudage.ClasseEchaf;
import fr.paquet.echafaudage.Echafaudage;
import fr.paquet.echafaudage.TypeEchaf;
import fr.paquet.echafaudage.TypeSol;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.io.csv.ElementIntegrator;
import fr.paquet.io.csv.CsvElementEchafReader;

public class PanelEchafaudage extends JPanel implements PropertyChangeListener {

	public class JButtonChooser extends JButton implements ActionListener, PropertyChangeListener {

		/**
		 * Button particulier il est clickable lorsque le projet à un titre, que les
		 * paramètres de l'echafaudage sont entrés<br/>
		 */

		private boolean clickable = false;

		private static final long serialVersionUID = 1L;

		public JButtonChooser() {
			super();
			setText("Intégrer un echafaudage");
			buttonEnabled();

			// listeners
			addActionListener(this);
			getPanelProjet().getOnglet().getProjet().addPropertyChangeListener(this);
			getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().addPropertyChangeListener(this);
		}

		/**
		 * 
		 * @return true si tire, ClasseEchaf, TypeEchaf, TypeSol sont non null <br/>
		 */
		private boolean isClickable() {

			if (getPanelProjet().getOnglet().getProjet().getTitre() != null
					&& !getPanelProjet().getOnglet().getProjet().getTitre().equals("")
					&& getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().getClasseEchaf() != null
					&& getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().getTypeEchaf() != null
					&& getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().getTypeSol() != null) {

				clickable = true;

			} else {
				clickable = false;
			}

			return clickable;
		}

		private void buttonEnabled() {
			this.setEnabled(isClickable());
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			FileChooser fc = new FileChooser();

			try {

				CsvElementEchafReader reader = new CsvElementEchafReader(PanelEchafaudage.this, fc.getFile());
				ElementIntegrator integrator = new ElementIntegrator(reader);

				if (fc.getFile() != null)

					getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage()
							.setListElements(integrator.getElements());

			} catch (Exception e1) {

				new AlertWindow("Erreur", "Fichier csv non lisible");
				e1.printStackTrace(System.out);
			}
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {

			buttonEnabled();

		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelProjet panelProjet = null;
	private List<JCheckBox> classes = null;
	private List<JCheckBox> types = null;
	private List<JCheckBox> typeEchafs = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelProjet
	 */
	public PanelEchafaudage(JPanelProjet panelProjet) {
		super();
		setPanelProjet(panelProjet);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données de l'echafaudage"));

		// Ajout d'un layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		// listener
		Echafaudage echaf = getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage();
		echaf.setChangeSupport(new PropertyChangeSupport(echaf));
		echaf.addPropertyChangeListener(this);
		/*
		 * // titre du panel add(new JLabel(""), new GridBagConstraints(0, 0, 1, 1, 1.0,
		 * 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new
		 * Insets(0, 0, 5, 0), 0, 0));
		 */
		int gridx = 0;
		int gridy = 1;
		// classe d'echafaudage
		add(new JLabel("Classe d'échafaudage en fonction de la charge d'exploitation"),
				new GridBagConstraints(0, gridy, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START,
						GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
		gridy = gridy + 1;

		for (ClasseEchaf cl : EnumSet.allOf(ClasseEchaf.class)) {

			JCheckBox box = new JCheckBox(cl.getClasse());
			addClasse(box);

			new AddLineJCheckBox(this, box, gridx, gridy, 1, 1, 0, 0, GridBagConstraints.BOTH);
			gridy = gridy + 1;
		}

		gridx = gridx + 1;
		gridy = 1;
		// type d'echafaudage
		add(new JLabel("Type d'échafaudage"), new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

		gridy = gridy + 1;

		for (TypeEchaf tE : EnumSet.allOf(TypeEchaf.class)) {

			JCheckBox box2 = new JCheckBox(tE.getType());
			addTypeEchaf(box2);

			new AddLineJCheckBox(this, box2, gridx, gridy, 1, 1, 0, 0, GridBagConstraints.BOTH);
			gridy = gridy + 1;
		}

		gridx = gridx + 2;
		gridy = 1;
		// type de sol
		add(new JLabel("Type de sol"), new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
		gridy = gridy + 1;

		for (TypeSol ts : EnumSet.allOf(TypeSol.class)) {

			JCheckBox box1 = new JCheckBox(ts.getType());
			addType(box1);

			new AddLineJCheckBox(this, box1, gridx, gridy, 1, 1, 0, 0, GridBagConstraints.BOTH);
			gridy = gridy + 1;
		}

		// fichier *.csv
		add(new JButtonChooser(), new GridBagConstraints(gridx + 1, gridy, 1, 1, 1, 1,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

		// button "Lancer le calcul"
		JButton calcul = new JButton("Lancer le calcul");

		calcul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					//Code pas a la bonne place
					getPanelProjet().getpResul().add(new PanelNoteDeCalcul(getPanelProjet().getpResul()),
							new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
					getPanelProjet().getpResul().add(new PanelNomenclature(getPanelProjet().getpResul()),
							new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
									GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
					
				} catch (Exception e2) {
					new AlertWindow("Erreur", "Calcul impossible");
					e2.printStackTrace(System.out);
				}

			}
		});

		// affichage du button Jcalcul
		add(calcul, new GridBagConstraints(gridx + 1, gridy + 1, 1, 1, 1, 1, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

	}

	/**
	 * add la liste de JCheckBox relative a la classe d'echafaudage<br/>
	 * 
	 * @param box
	 */
	private void addClasse(JCheckBox box) {

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JCheckBox box = (JCheckBox) e.getSource();

				for (JCheckBox box1 : getClasses()) {

					if (!box1.getText().equals(box.getText()))
						box1.setSelected(false);
				}

				for (ClasseEchaf clE : EnumSet.allOf(ClasseEchaf.class)) {
					if (clE.getClasse().equals(box.getText()))
						getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().setClasseEchaf(clE);
				}

			}
		});

		getClasses().add(box);
	}

	/**
	 * add la liste de JCheckBox relative au type de sol<br/>
	 * 
	 * @param box
	 */
	private void addType(JCheckBox box) {

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JCheckBox box = (JCheckBox) e.getSource();

				for (JCheckBox box1 : getTypes()) {

					if (!box1.getText().equals(box.getText()))
						box1.setSelected(false);
				}

				for (TypeSol tS : EnumSet.allOf(TypeSol.class)) {

					if (tS.getType().equals(box.getText()))
						getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().setTypeSol(tS);

				}

			}
		});

		getTypes().add(box);
	}

	/**
	 * add la liste de JCheckBox relative au type de sol<br/>
	 * 
	 * @param box
	 */
	private void addTypeEchaf(JCheckBox box) {

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JCheckBox box = (JCheckBox) e.getSource();

				for (JCheckBox box1 : getTypesEchaf()) {

					if (!box1.getText().equals(box.getText()))
						box1.setSelected(false);
				}

				for (TypeEchaf tE : EnumSet.allOf(TypeEchaf.class)) {

					if (tE.getType().equals(box.getText()))
						getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().setTypeEchaf(tE);

				}

			}
		});

		getTypesEchaf().add(box);
	}

	/**
	 * 
	 * @return la liste de JCheckBox de classe d'echafaudage<br/>
	 */
	private List<JCheckBox> getClasses() {
		if (classes == null)
			classes = new ArrayList<JCheckBox>();
		return classes;
	}

	/**
	 * 
	 * @return la liste de JCheckBox de type de sol<br/>
	 */
	private List<JCheckBox> getTypes() {
		if (types == null)
			types = new ArrayList<JCheckBox>();
		return types;
	}

	private List<JCheckBox> getTypesEchaf() {
		if (typeEchafs == null)
			typeEchafs = new ArrayList<JCheckBox>();
		return typeEchafs;
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
