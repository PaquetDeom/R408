package fr.paquet.ihm.eltByName;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

import fr.paquet.echafaudage.TypeEchaf;
import fr.paquet.echafaudage.element.EltByNameFactory;
import fr.paquet.echafaudage.element.InstanciationElement;
import fr.paquet.ihm.echaf.AddLineJCheckBox;
import fr.paquet.ihm.explorer.GestionnaireModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChoixDuType extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EltByNameFactory elt = null;
	private String nom = null;
	private JPanel panelEntete = null;
	private JPanel panelList = null;
	private JPanel panelButton = null;
	private JLabel label = null;
	private JList<String> list = null;
	private JButton bOk = null;
	private JButton bAnnul = null;

	public ChoixDuType(EltByNameFactory elt, String name) {
		super();
		setElt(elt);
		setNom(name);
		setVisible(true);

		// construction de la fenetre
		setTitle("Choix du type d'element de " + getNom());
		setAlwaysOnTop(false);
		setSize(600, 300);

		// creation des layout
		GridBagLayout gridBagLayoutPrincipal = new GridBagLayout();
		getContentPane().setLayout(gridBagLayoutPrincipal);

		// creation et ajout des layouts au layout principal
		setPanelEntete(new JPanel());
		setPanelList(new JPanel());
		setPanelButton(new JPanel());

		getContentPane().add(getPanelEntete(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		getContentPane().add(getPanelList(), new GridBagConstraints(0, 1, 1, 1, 1, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 5, 5));
		getContentPane().add(getPanelButton(), new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

		// set des élments de la fenêtre
		setLabel(new JLabel(getNom()));
		getPanelEntete().add(getLabel(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		//creation de la liste
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (InstanciationElement inst : EnumSet.allOf(InstanciationElement.class)) {
			listModel.addElement(inst.toString());
		}
		setList(new JList<String>(listModel));
		getPanelList().add(getList(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		setbAnnul(new JButton("Annuler"));
		getPanelButton().add(getbAnnul(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));
		setbOk(new JButton("Ok"));
		getPanelButton().add(getbOk(), new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

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

	public JList<String> getList() {
		return list;
	}

	private void setList(JList<String> list) {
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.list = list;
	}

	private JButton getbOk() {
		return bOk;
	}

	private void setbOk(JButton bOk) {

		bOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

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
				ChoixDuType.this.dispose();

			}
		});

		// alignemnt du jbutton
		bAnnul.setVerticalAlignment(SwingConstants.BOTTOM);
		this.bAnnul = bAnnul;
	}

}
