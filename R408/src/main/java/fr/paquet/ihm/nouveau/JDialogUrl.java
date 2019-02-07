package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.main.MainFrame;
import fr.paquet.projet.Projet;

public class JDialogUrl extends JDialog implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tF = null;
	private JButton JOk = null;
	private JButton JAnnul = null;
	private Projet projet = null;

	public JDialogUrl(Projet projet) {
		super(MainFrame.getUniqInstance());
		setAlwaysOnTop(true);
		setTitle("Modification de l'url");
		setSize(900, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		// création des éléments
		settF(new JTextField(60));
		setJOk(new JButton("Ok"));
		setJAnnul(new JButton("Annul"));
		setProjet(projet);

		// Organisation de la fenêtre
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);

		JPanel tFPanel = new JPanel();
		getContentPane().add(tFPanel, new GridBagConstraints(0, 1, 3, 1, 1, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		tFPanel.add(gettF());

		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, new GridBagConstraints(0, 2, 3, 1, 1, 0.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

		buttonPanel.setLayout(new BorderLayout());
		JPanel panelButton2 = new JPanel();
		panelButton2.setLayout(new GridLayout());

		panelButton2.add(getJOk());
		panelButton2.add(getJAnnul());

		buttonPanel.add(panelButton2, BorderLayout.EAST);

	}

	public JTextField gettF() {
		return tF;
	}

	public void settF(JTextField tF) {
		tF.setText("Veuilez saisir une nouvelle url");
		this.tF = tF;
	}

	public JButton getJOk() {
		return JOk;
	}

	public void setJOk(JButton jOk) {

		jOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String newUrl = gettF().getText();
				String tab[] = newUrl.split("/");

				if (newUrl.equals("") || newUrl == null)
					new AlertWindow(AlertType.QUESTION, "Url vide voulez-vous continuez ?", JDialogUrl.this);

				if (!tab[0].equals("http:") && !tab[0].equals("https:"))
					new AlertWindow(AlertType.ERREUR, "Vous n'avez pas saisi une Url");
				else {
					getProjet().setUrl(newUrl);
					JDialogUrl.this.dispose();
				}

			}
		});
		JOk = jOk;
	}

	public JButton getJAnnul() {
		return JAnnul;
	}

	public void setJAnnul(JButton jAnnul) {
		jAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialogUrl.this.dispose();

			}
		});
		JAnnul = jAnnul;
	}

	private Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public void buttonClick(String button) {
		if (button.equals("Non"))
			this.dispose();

	}

}
