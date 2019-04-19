package fr.paquet.io.csv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

import fr.paquet.ihm.parameterCsv.JLabelJRadio.JRadio;

public class ParameterList {

	private List<JRadio> jRadios = null;
	private List<JRadio> jRadiosSelected = null;
	private String Separator = null;
	private static ParameterList pL = null;
	private HashMap<Enum, Integer> params = null;

	public HashMap<Enum, Integer> getParams() {
		if (params == null) {
			params = new HashMap<Enum, Integer>();
			putValue();
		}

		return params;
	}

	private void putValue() {
		for (JRadio jr : getJradiosSelected()) {
			int i = jr.getLine();
			for (ParameterCsv pc : EnumSet.allOf(ParameterCsv.class)) {
				int j = pc.getPositionLine();
				if (i == j)
					params.put(pc, jr.getColonne());
			}
		}
	}

	private ParameterList() {
		super();
	}

	public static ParameterList getUniqInstance() {
		if (pL == null)
			pL = new ParameterList();
		return ParameterList.pL;
	}

	public List<JRadio> getJradios() {
		if (jRadios == null)
			jRadios = new ArrayList<JRadio>();
		return jRadios;
	}

	public List<JRadio> getJradiosSelected() {
		if (jRadiosSelected == null)
			jRadiosSelected = new ArrayList<JRadio>();
		return jRadiosSelected;
	}

	private void addJradioSelected(JRadio jRadio) {
		getJradiosSelected().add(jRadio);
	}

	private void selected(JRadio jR) {
		jR.setSelected(true);
		addJradioSelected(jR);
	}

	private void unSelected(JRadio jR) {
		jR.setSelected(false);
		getJradiosSelected().remove(jR);
	}

	private void test(JRadio jRadio) {

		for (JRadio jR : getJradiosSelected()) {
			if (jRadio.getColonne() == jR.getColonne()) {
				unSelected(jR);
				break;
			}
		}

		for (JRadio jR : getJradiosSelected()) {
			if (jRadio.getLine() == jR.getLine()) {
				unSelected(jR);
				break;
			}
		}

		selected(jRadio);
	}

	public void addJradio(JRadio jRadio) {

		jRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// récupère le JRadio cliquer
				JRadio jRadio = (JRadio) e.getSource();

				// Si la JradiosSelected est vide
				if (getJradiosSelected().isEmpty()) {
					// add jRadio à la liste de JradioSelected et selectionne jRadio
					selected(jRadio);

					// autrement
				} else {

					// Pour tous les Jradio de la liste jRadioselected
					for (JRadio jR : getJradiosSelected()) {

						// Si les colonnes et les lines des jRadio et de jR sont égales
						if (jRadio.getColonne() == jR.getColonne() && jRadio.getLine() == jR.getLine()) {

							// déselectionne jRadio et enlève jR de la liste des jRadiodelected
							jRadio.setSelected(false);
							getJradiosSelected().remove(jR);

						}
					}

					test(jRadio);

				}

			}
		});

		getJradios().add(jRadio);
	}

	public String getSeparator() {
		return Separator;
	}

	public void setSeparator(String separator) {
		Separator = separator;
	}

}
