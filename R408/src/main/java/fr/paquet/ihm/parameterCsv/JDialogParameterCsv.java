package fr.paquet.ihm.parameterCsv;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import fr.paquet.echafaudage.Echafaudage;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.PanelEchafaudage;
import fr.paquet.io.csv.CsvElementEchafReader;
import fr.paquet.io.csv.ElementIntegrator;
import fr.paquet.io.csv.ParameterList;

public class JDialogParameterCsv extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton buttonOk = null;
	private JButton buttonAnnul = null;
	private PanelEchafaudage panelEchafaudage = null;

	private void setPanelEchafaudage(PanelEchafaudage pE) {
		this.panelEchafaudage = pE;
	}

	private PanelEchafaudage getPanelEchafaudage() {
		return panelEchafaudage;
	}

	private CsvElementEchafReader csvElementReader = null;

	public JDialogParameterCsv(PanelEchafaudage pE) throws IOException {

		super();

		// setteur panelEchafaudage
		setPanelEchafaudage(pE);

		try {
			setCsvElementReader(new CsvElementEchafReader(getPanelEchafaudage(), getPanelEchafaudage().getCsvFile()));
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, e.getMessage());
			e.printStackTrace(System.out);
		}

		// creation de la fenêtre
		setTitle("Paramètre du *.csv");
		setSize(1300, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);
		setModal(true);

		// creation du JPanelParameter et JPanelCsv et des button;
		JPanelParameter jPp = new JPanelParameter(this);
		JPanelCsv jPc = new JPanelCsv(this);
		setButtonOk(new JButton("Ok"));
		setButtonAnnul(new JButton("Annuler"));

		// creation du layout
		GridBagLayout gridBagLayout = new GridBagLayout();

		// ajout du layout au panel
		getContentPane().setLayout(gridBagLayout);

		// ajout de JPanelParameter et JPanelCsv à la JDialog;
		getContentPane().add(jPp, new GridBagConstraints(0, 0, 1, 1, 1.0, 2.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		getContentPane().add(jPc, new GridBagConstraints(1, 0, 1, 1, 1.0, 2.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// création d'un panelButton
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new BorderLayout());
		JPanel pB2 = new JPanel();
		pB2.setLayout(new GridLayout());

		pB2.add(getButtonAnnul());
		pB2.add(getButtonOk());
		panelButton.add(pB2, BorderLayout.EAST);

		getContentPane().add(panelButton, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	private JButton getButtonOk() {
		return buttonOk;
	}

	private void setButtonOk(JButton buttonOk) {

		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// test que l'ensemble des paramètres est sélectionné.
				if (ParameterList.getUniqInstance().getJradiosSelected().size() != 6)
					new AlertWindow(AlertType.ERREUR, "l'ensemble des paramètres n'a pas été saisi");
				if (ParameterList.getUniqInstance().getSeparator() == null)
					new AlertWindow(AlertType.ERREUR, "le séparateur n'est pas renseigné");
				else {

					Echafaudage echaf = getPanelEchafaudage().getPanelProjet().getOnglet().getProjet().getChantier()
							.getEchafaudage();
					ElementIntegrator Ei = new ElementIntegrator(getCsvElementReader());

					try {

						echaf.setListElements(Ei.getElements());
						getPanelEchafaudage().setFileCharged(true);
						getPanelEchafaudage().getJButtonCalcul().buttonEnabled();
						getPanelEchafaudage().getPanelProjet().getpResul().revalidate();

						new AlertWindow(AlertType.INFORMATION, "Le Fichier "
								+ getPanelEchafaudage().getCsvFile().getName() + " est correctement chargé");
						JDialogParameterCsv.this.dispose();

					} catch (Exception e1) {
						new AlertWindow(AlertType.ERREUR, e1.getMessage());
						e1.printStackTrace();
					}

				}
			}
		});

		this.buttonOk = buttonOk;
	}

	private JButton getButtonAnnul() {
		return buttonAnnul;
	}

	private void setButtonAnnul(JButton buttonAnnul) {

		buttonAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogParameterCsv.this.dispose();

			}
		});

		this.buttonAnnul = buttonAnnul;
	}

	public CsvElementEchafReader getCsvElementReader() {
		return csvElementReader;
	}

	private void setCsvElementReader(CsvElementEchafReader csvElementReader) {
		this.csvElementReader = csvElementReader;
	}

}
