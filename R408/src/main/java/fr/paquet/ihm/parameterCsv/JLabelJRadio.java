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
		private ParameterCsv parameterCsv = null;

		public JRadio(int positionColonne, ParameterCsv pc) {
			super();
			setColonne(positionColonne);
			setParameterCsv(pc);

		}

		private void setColonne(int a) {
			this.colonne = a;
		}

		public int getColonne() {
			return colonne;
		}

		public ParameterCsv getParameterCsv() {
			return parameterCsv;
		}

		private void setParameterCsv(ParameterCsv parameterCsv) {
			this.parameterCsv = parameterCsv;
		}

		public boolean mustBeDeselected(JRadio jRadio) {
			if (this!=jRadio && (getColonne()==jRadio.getColonne() || getParameterCsv()==jRadio.getParameterCsv())) {
				setSelected(false);
				return true;
			}
			return false;	
		}

	}

	public JLabelJRadio(JPanel panel, int gridx, ParameterCsv pc) {

		super();

		panel.add(new JLabel(pc.toString()), new GridBagConstraints(gridx, pc.ordinal()+1, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		int i = 0;

		for (ParameterCsv pr : EnumSet.allOf(ParameterCsv.class)) {

			JRadio rB = new JRadio(i, pc);
			ParameterList.getUniqInstance().addJradio(rB);

			panel.add(rB, new GridBagConstraints(gridx + i + 1, pc.ordinal()+1, 1, 1, 0, 0, GridBagConstraints.EAST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			i++;
		}

	}

}
