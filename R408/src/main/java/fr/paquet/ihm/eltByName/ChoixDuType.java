package fr.paquet.ihm.eltByName;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.EnumSet;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.ListSelectionModel;

import fr.paquet.echafaudage.element.EltByName;
import fr.paquet.echafaudage.element.EltByNameFactory;
import fr.paquet.echafaudage.element.InstanciationElement;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChoixDuType extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EltByNameFactory elt = null;
	private EltByName eltN = null;
	private String nom = null;
	private JPanel panelEntete = null;
	private JPanel panelList = null;
	private JPanel panelButton = null;
	private JLabel label = null;
	private JList<InstanciationElement> list = null;
	private JButton bOk = null;
	private JButton bAnnul = null;

	public ChoixDuType(EltByNameFactory elt, String name) {
		super();

		setElt(elt);
		setNom(name);

		// construction de la fenetre
		setTitle("Choix du type d'element de " + getNom());
		setSize(350, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setModal(true);

		// creation des layout
		GridBagLayout gridBagLayoutPrincipal = new GridBagLayout();
		getContentPane().setLayout(gridBagLayoutPrincipal);

		// creation des layouts au layout principal
		setPanelEntete(new JPanel());
		setPanelList(new JPanel());
		getPanelList().setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"List de type d'élément"));
		setPanelButton(new JPanel());

		// set des élments de la fenêtre
		setLabel(new JLabel(getNom()));
		getPanelEntete().add(getLabel(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		// creation de la liste
		DefaultListModel<InstanciationElement> listModel = new DefaultListModel<InstanciationElement>();
		for (InstanciationElement inst : EnumSet.allOf(InstanciationElement.class)) {
			listModel.addElement(inst);
		}

		setList(new JList<InstanciationElement>(listModel));
		getList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getPanelList().add(getList(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		setbAnnul(new JButton("Annuler"));
		getPanelButton().add(getbAnnul(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));
		setbOk(new JButton("Ok"));
		getPanelButton().add(getbOk(), new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		// ajout des panels au panel principal
		getContentPane().add(getPanelEntete(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		getContentPane().add(getPanelList(), new GridBagConstraints(0, 1, 1, 1, 1, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 5, 5));

		JPanel borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(getPanelButton(), BorderLayout.EAST);

		getContentPane().add(borderPanel, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

	}

	public EltByName getEltN() {
		return eltN;
	}

	private void setEltN(EltByName eltN) {
		this.eltN = eltN;
	}

	private void setNom(String name) {
		this.nom = name;
	}

	private String getNom() {
		return nom;
	}

	private EltByNameFactory getElt() {
		return elt;
	}

	private void setElt(EltByNameFactory elt) {
		this.elt = elt;
	}

	private JPanel getPanelEntete() {
		return panelEntete;
	}

	private void setPanelEntete(JPanel panelEntete) {
		this.panelEntete = panelEntete;
	}

	private JPanel getPanelList() {
		return panelList;
	}

	private void setPanelList(JPanel panelList) {
		this.panelList = panelList;
	}

	private JPanel getPanelButton() {
		return panelButton;
	}

	private void setPanelButton(JPanel panelButton) {
		this.panelButton = panelButton;
	}

	private JLabel getLabel() {
		return label;
	}

	private void setLabel(JLabel label) {
		this.label = label;
	}

	private JList<InstanciationElement> getList() {
		return list;
	}

	private void setList(JList<InstanciationElement> list) {

		ListSelectionListener listSelectionListener = new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent listSelectionEvent) {

				boolean adjust = listSelectionEvent.getValueIsAdjusting();

				if (!adjust) {
					final List<InstanciationElement> selectedValuesList = getList().getSelectedValuesList();
					setEltN(new EltByName(getNom(), selectedValuesList.get(0)));
				}
			}
		};

		list.addListSelectionListener(listSelectionListener);
		this.list = list;
	}

	private JButton getbOk() {
		return bOk;
	}

	private void setbOk(JButton bOk) {

		bOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				getElt().saveEltByName(getEltN());
				new AlertWindow(AlertType.INFORMATION, "Le mot clé a bien été sauvegardé");
				ChoixDuType.this.dispose();

			}
		});

		// Alignement du Jbutton
		bOk.setVerticalAlignment(SwingConstants.BOTTOM);
		this.bOk = bOk;
	}

	private JButton getbAnnul() {
		return bAnnul;
	}

	private void setbAnnul(JButton bAnnul) {

		bAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				getElt().saveEltByName(new EltByName(getNom(), null));
				getElt().setEltByName(null);
				ChoixDuType.this.dispose();

			}
		});

		// alignemnt du jbutton
		bAnnul.setVerticalAlignment(SwingConstants.BOTTOM);
		this.bAnnul = bAnnul;
	}

}
