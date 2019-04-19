package fr.paquet.ihm.parameterCsv;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.util.EnumSet;

import javax.swing.*;

import fr.paquet.io.csv.ParameterCsv;
import fr.paquet.io.csv.ParameterList;

public class JLabelJRadio {

	public class JRadio extends JRadioButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int colonne = 0;
		private int line = 0;

		public JRadio(int positionColonne, int positionLigne) {
			super();
			setColonne(positionColonne);
			setLine(positionLigne);

		}

		private void setColonne(int a) {
			this.colonne = a;
		}

		public int getColonne() {
			return colonne;
		}

		private void setLine(int a) {
			this.line = a;
		}

		public int getLine() {
			return line;
		}

	}

	public JLabelJRadio(JPanel panel, String textLabel, int gridx, int positionLigne) {

		super();

		panel.add(new JLabel(textLabel), new GridBagConstraints(gridx, positionLigne, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		int i = 0;
		
		for (ParameterCsv pr : EnumSet.allOf(ParameterCsv.class)) {

			JRadio rB = new JRadio(i, positionLigne);
			ParameterList.getUniqInstance().addJradio(rB);

			panel.add(rB, new GridBagConstraints(gridx + i + 1, positionLigne, 1, 1, 0, 0, GridBagConstraints.EAST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			i++;
		}
		
	}

}
