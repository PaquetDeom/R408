package fr.paquet.ihm.eltByName;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.paquet.echafaudage.element.EltByName;
import fr.paquet.echafaudage.element.EltByNameFactory;
import fr.paquet.echafaudage.element.InstanciationElement;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class AjoutMotsCles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelEntete = null;
	private JPanel panelList = null;
	private JPanel panelButton = null;
	private JTextField textField = null;
	private JList<InstanciationElement> list = null;
	private InstanciationElement inst = null;
	private JButton bOk = null;
	private JButton bAnnul = null;

	public AjoutMotsCles() {
		super();

		// construction de la fenetre
		setTitle("Ajout d'un mot cle dans la base");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// creation des layout
		GridBagLayout gridBagLayoutPrincipal = new GridBagLayout();
		getContentPane().setLayout(gridBagLayoutPrincipal);

		// creation des layouts au layout principal
		setPanelEntete(new JPanel());
		setPanelList(new JPanel());
		setPanelButton(new JPanel());

		// set des élments de la fenêtre
		setTextField(new JTextField(8));
		getPanelEntete().add(new JLabel("mots"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));
		getPanelEntete().add(getTextField(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		// creation de la liste
		DefaultListModel<InstanciationElement> listModel = new DefaultListModel<InstanciationElement>();
		for (InstanciationElement inst : EnumSet.allOf(InstanciationElement.class)) {
			listModel.addElement(inst);
		}

		setList(new JList<InstanciationElement>(listModel));
		add(new JScrollPane(getList()));
		getList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getPanelList().add(getList(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		setbAnnul(new JButton("Annuler"));
		getPanelButton().add(getbAnnul(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));
		setbOk(new JButton("Ajouter"));
		getPanelButton().add(getbOk(), new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 5, 5));

		// ajout des panels au panel principal
		getContentPane().add(getPanelEntete(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		getContentPane().add(getPanelList(), new GridBagConstraints(0, 1, 1, 1, 1, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 5, 5));
		getContentPane().add(getPanelButton(), new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

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

	private JTextField getTextField() {
		return textField;
	}

	private void setTextField(JTextField textField) {
		this.textField = textField;
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
					setInst(selectedValuesList.get(0));
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

				EltByNameFactory eltF = new EltByNameFactory();
				eltF.saveEltByName(new EltByName(getTextField().getText(), getInst()));
				new AlertWindow(AlertType.INFORMATION, "Le mot clé a bien été sauvegardé");
				AjoutMotsCles.this.dispose();

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

				AjoutMotsCles.this.dispose();

			}
		});

		// alignemnt du jbutton
		bAnnul.setVerticalAlignment(SwingConstants.BOTTOM);
		this.bAnnul = bAnnul;
	}

	private InstanciationElement getInst() {
		return inst;
	}

	private void setInst(InstanciationElement inst) {
		this.inst = inst;
	}

}
