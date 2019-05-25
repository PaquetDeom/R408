package fr.paquet.ihm.parameterCsv;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

import fr.paquet.io.csv.ParameterCsv;
import fr.paquet.io.csv.ParameterList;

public class JPanelParameter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogParameterCsv jDPC = null;
	private JRadioButton virgule = null;
	private JRadioButton pointVirgule = null;

	public JPanelParameter(JDialogParameterCsv jDPC) {
		super();
		setjDPC(jDPC);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Paramètres"));

		// ajout du layout
		setLayout(new GridBagLayout());

		add(new JLabel(""), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		int posx = 1;

		for (ParameterCsv pr : EnumSet.allOf(ParameterCsv.class)) {

			String a = "Col" + posx;
			add(new JLabel(a), new GridBagConstraints(posx, 0, 1, 1, 0, 0, GridBagConstraints.EAST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			posx++;
		}

		int position = 1;

		for (ParameterCsv pC : EnumSet.allOf(ParameterCsv.class)) {

			new JLabelJRadio(this, 0, pC);
			position++;

		}

		// création du paramètre de séparation

		setVirgule(new JRadioButton());
		setPointVirgule(new JRadioButton());

		add(new JLabel(" ,"), new GridBagConstraints(2, position, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel(" ;"), new GridBagConstraints(5, position, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Séparateur"), new GridBagConstraints(0, position + 1, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getVirgule(), new GridBagConstraints(2, position + 1, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getPointVirgule(), new GridBagConstraints(5, position + 1, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	public JDialogParameterCsv getjDPC() {
		return jDPC;
	}

	private void setjDPC(JDialogParameterCsv jDPC) {
		this.jDPC = jDPC;
	}

	public JRadioButton getVirgule() {
		return virgule;
	}

	private void setVirgule(JRadioButton virgule) {

		virgule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JRadioButton jR = (JRadioButton) e.getSource();
				jR.setSelected(true);
				getPointVirgule().setSelected(false);
				ParameterList.getUniqInstance().setSeparator(",");
			}
		});

		this.virgule = virgule;
	}

	public JRadioButton getPointVirgule() {
		return pointVirgule;
	}

	private void setPointVirgule(JRadioButton pointVirgule) {

		pointVirgule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JRadioButton jR = (JRadioButton) e.getSource();
				jR.setSelected(true);
				getVirgule().setSelected(false);
				ParameterList.getUniqInstance().setSeparator(";");
			}
		});

		this.pointVirgule = pointVirgule;
	}

}
