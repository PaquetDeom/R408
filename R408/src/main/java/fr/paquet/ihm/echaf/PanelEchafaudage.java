package fr.paquet.ihm.echaf;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.echafaudage.ClasseEchaf;
import fr.paquet.echafaudage.Echafaudage;
import fr.paquet.echafaudage.TypeEchaf;
import fr.paquet.echafaudage.TypeSol;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.io.csv.ElementIntegrator;
import fr.paquet.projet.Chantier;
import fr.paquet.io.csv.CsvElementEchafReader;

public class PanelEchafaudage extends JPanel {

	private JLabel labelFichier = null;
	private JButton JbuttonChooser = null;

	public class JButtonCalcul extends JButton implements ActionListener {

		/**
		 * Button particulier il est clickable lorsque le projet à un titre, que les
		 * paramètres de l'echafaudage sont entrés<br/>
		 */

		private boolean clickable = false;
		private ClasseEchaf classe = null;
		private TypeEchaf typeEchaf = null;
		private TypeSol typeSol = null;

		private static final long serialVersionUID = 1L;

		public JButtonCalcul() {
			super();
			setText("Lancer le calcul");
			buttonEnabled();

			// listeners
			addActionListener(this);

		}

		/**
		 * 
		 * @return true si tire, ClasseEchaf, TypeEchaf, TypeSol sont non null <br/>
		 */
		private boolean isClickable() {

			if (isFileCharged() && getClasse() != null && getTypeSol() != null && getTypeEchaf()!= null) {

				clickable = true;

			} else {
				clickable = false;
			}

			return clickable;
		}

		public void buttonEnabled() {
			this.setEnabled(isClickable());
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				// efface tous les composants
				getPanelProjet().getpResul().removeAll();

				// set la classe, le typesol et le type echaf.
				getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().setClasseEchaf(getClasse());
				getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().setTypeSol(getTypeSol());
				getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().setTypeEchaf(getTypeEchaf());

				// affiche les résultats.
				getPanelProjet().getpResul().add(new PanelNoteDeCalcul(getPanelProjet().getpResul()),
						new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START,
								GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

				getPanelProjet().getpResul().add(new PanelNomenclature(getPanelProjet().getpResul()),
						new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 5, 5));

				getPanelProjet().getpResul().add(new PanelImprimer(getPanelProjet().getpResul()),
						new GridBagConstraints(1, 0, 1, 2, 0, 0, GridBagConstraints.BASELINE,
								GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

				// affiche ce qu'il y a en mémoire (refrech screen)
				getPanelProjet().getpResul().revalidate();

			} catch (Exception e2) {
				new AlertWindow(AlertType.ERREUR, "Calcul impossible");
				e2.printStackTrace(System.out);
			}

		}

		private ClasseEchaf getClasse() {
			return classe;
		}

		public void setClasse(ClasseEchaf classe) {
			this.classe = classe;
		}

		private TypeEchaf getTypeEchaf() {
			return typeEchaf;
		}

		public void setTypeEchaf(TypeEchaf typeEchaf) {
			this.typeEchaf = typeEchaf;
		}

		private TypeSol getTypeSol() {
			return typeSol;
		}

		public void setTypeSol(TypeSol typeSol) {
			this.typeSol = typeSol;
		}

	}

	private ElementIntegrator integrator = null;

	private void setIntegrator(ElementIntegrator eltin) {
		this.integrator = eltin;
	}

	private ElementIntegrator getIntegrator() {
		return integrator;
	}

	private void setJbuttonChooser(JButton button) {

		button.setText("Intégrer un echafaudage");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				FileChooser fc = new FileChooser();

				Echafaudage echaf = new Echafaudage();
				Chantier chantier = new Chantier(getPanelProjet().getOnglet().getProjet(), echaf);
				getPanelProjet().getOnglet().getProjet().setChantier(chantier);

				try {

					setIntegrator(
							new ElementIntegrator(new CsvElementEchafReader(PanelEchafaudage.this, fc.getFile())));

				} catch (Exception e) {

					new AlertWindow(AlertType.ERREUR, "Fichier non chargé");
					e.printStackTrace(System.out);

				}

				if (fc.getFile() != null) {

					chantier.getEchafaudage().setListElements(integrator.getElements());
				}

				new AlertWindow(AlertType.ATTENTION,
						"Le fichier " + fc.getFile().getName() + " est correctement chargé");
				setFileCharged(true);
				getJButtonCalcul().buttonEnabled();

				addFichier(fc.getFile());

				getPanelProjet().getpResul().revalidate();

			}

		});
		this.JbuttonChooser = button;
	}

	private JButton getJbuttonChooser() {
		return JbuttonChooser;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelProjet panelProjet = null;
	private List<JCheckBox> classes = null;
	private List<JCheckBox> types = null;
	private List<JCheckBox> typeEchafs = null;
	private boolean fileIsCharged = false;
	private JButtonCalcul jButtonCalcul = null;

	private void setJButtonCalcul(JButtonCalcul bc) {
		this.jButtonCalcul = bc;
	}

	private JButtonCalcul getJButtonCalcul() {
		return jButtonCalcul;
	}

	private void setFileCharged(boolean b) {
		this.fileIsCharged = b;
	}

	private boolean isFileCharged() {
		return fileIsCharged;
	}

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

		// mutte la variable JButtonChooser
		setJbuttonChooser(new JButton());
		setJButtonCalcul(new JButtonCalcul());

		// contient la ligne des boutons
		int ligneButton = 0;

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
		// TODO: Boulot pour Nath
		ligneButton = ligneButton < gridy ? gridy : ligneButton;

		gridx++;
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
		// TODO: Boulot pour Nath
		ligneButton = ligneButton < gridy ? gridy : ligneButton;

		gridx++;
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
		// TODO: Boulot pour Nath
		ligneButton = ligneButton < gridy ? gridy : ligneButton;

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, new GridBagConstraints(0, ligneButton, 3, 1, 1, 0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0));

		buttonPanel.setLayout(new BorderLayout());
		labelFichier = new JLabel();
		buttonPanel.add(labelFichier, BorderLayout.CENTER);

		JPanel panelButton2 = new JPanel();
		panelButton2.setLayout(new GridLayout());
		// fichier *.csv
		panelButton2.add(getJbuttonChooser());
		// affichage du button Jcalcul
		panelButton2.add(getJButtonCalcul());

		buttonPanel.add(panelButton2, BorderLayout.EAST);

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
						getJButtonCalcul().setClasse(clE);
				}
				getJButtonCalcul().buttonEnabled();
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
						getJButtonCalcul().setTypeSol(tS);

				}

				getJButtonCalcul().buttonEnabled();

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
						getJButtonCalcul().setTypeEchaf(tE);

				}
				getJButtonCalcul().buttonEnabled();
			}
		});

		getTypesEchaf().add(box);
	}

	public void addFichier(File file) {
		labelFichier.setText("le fichier " + file.getName() + " est correctement chargé");
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

}
