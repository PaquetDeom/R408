package fr.paquet.ihm.eltByName;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.paquet.echafaudage.element.EltByName;
import fr.paquet.echafaudage.element.EltByNameFactory;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class MotsCles extends JDialog implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<EltByName> elts = null;
	private EltByName elt = null;
	private JButton bAjouter = null;
	private JButton bSuppr = null;
	private JButton bFermer = null;
	private JTable table = null;
	private MotsClesModel motsClesModel = null;

	public MotsCles() {
		super();

		// Construction de la fenetre
		setTitle("Gestion des mots cles et des types d'éléments");
		setSize(500, 520);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);
		setModal(true);

		// setList EltByName
		try {
			setElts(new EltByNameFactory().findAllEltByNames());
		} catch (Exception e) {
			new AlertWindow(AlertType.INFORMATION, e.getMessage());
			e.printStackTrace(System.out);
		}

		// set les objets graphiques
		setMotsClesModel(new MotsClesModel(MotsCles.this));
		setTable(new JTable());
		setbAjouter(new JButton("Ajouter"));
		setbFermer(new JButton("Fermer"));
		setbSuppr(new JButton("supprimer"));

		// Création du layout principal
		GridBagLayout gB = new GridBagLayout();
		getContentPane().setLayout(gB);

		// Création du panel de droite et de gauche
		JPanel pG = new JPanel();
		pG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Liste"));
		JPanel pD = new JPanel();
		pD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Choix"));

		getContentPane().add(pG, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));
		getContentPane().add(pD, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));

		// Création des panel dans le layout de Gauche
		JPanel panelTable = new JPanel();

		pG.add(panelTable, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		panelTable.add(getTable(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Création des layout dans le layout de droite
		JPanel panelTop = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panelTopButton = new JPanel();

		JPanel panelMiddle = new JPanel();

		JPanel panelButtom = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panelButtonButtom = new JPanel();

		pD.add(panelTop, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		pD.add(panelMiddle, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		pD.add(panelButtom, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		panelTop.add(panel1, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		panelTop.add(panelTopButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		panelTopButton.add(getbAjouter(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		panelTopButton.add(getbSuppr(), new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		panelButtom.add(panel4, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		panelButtom.add(panelButtonButtom, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		panelButtonButtom.add(getbFermer(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

	}

	public List<EltByName> getElts() {
		return elts;
	}

	private void setElts(List<EltByName> elts) {
		this.elts = elts;
	}

	private void setTable(JTable table) {

		// ajout du model à la Jtable
		table.setModel(getMotsClesModel());

		// donne le type de selection à la Jtable
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// ajout du listener
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				DefaultListSelectionModel dLSM = (DefaultListSelectionModel) e.getSource();
				int i = dLSM.getMinSelectionIndex();

				setEltByName(getElts().get(i));

			}
		});
		this.table = table;
	}

	private void setEltByName(EltByName elt) {
		this.elt = elt;
	}

	private void setMotsClesModel(MotsClesModel motsClesModel) {
		this.motsClesModel = motsClesModel;
	}

	private void setbAjouter(JButton bAjouter) {

		bAjouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AjoutMotsCles();

			}
		});
		this.bAjouter = bAjouter;
	}

	private void setbSuppr(JButton bSuppr) {

		bSuppr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new AlertWindow(AlertType.QUESTION, "êtes vous sûr de vouloir supprimé", MotsCles.this);

			}
		});
		this.bSuppr = bSuppr;
	}

	private void setbFermer(JButton bFermer) {

		bFermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MotsCles.this.dispose();

			}
		});
		this.bFermer = bFermer;
	}

	private EltByName getEltByName() {
		return elt;
	}

	private JButton getbAjouter() {
		return bAjouter;
	}

	private JButton getbSuppr() {
		return bSuppr;
	}

	private JButton getbFermer() {
		return bFermer;
	}

	private JTable getTable() {
		return table;
	}

	private MotsClesModel getMotsClesModel() {
		return motsClesModel;
	}

	@Override
	public void buttonClick(String button) {
		if (button == "Oui") {

			EltByNameFactory eltF = new EltByNameFactory();
			eltF.saveEltByName(getEltByName());
			new AlertWindow(AlertType.INFORMATION, "Le mot clé a bien été supprimé");

		}
		MotsCles.this.dispose();

	}

}
