package fr.paquet.io.csv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import javax.swing.JRadioButton;

import fr.paquet.ihm.parameterCsv.JLabelJRadio.JRadio;

public class ParameterList {

	private List<JRadio> jRadiosSelected = null;
	private String Separator = null;
	private static ParameterList pL = null;
	private HashMap<ParameterCsv, Integer> params = null;

	public HashMap<ParameterCsv, Integer> getParams() {
		if (params == null) {
			params = new HashMap<ParameterCsv, Integer>();
			initValue();
		}

		return params;
	}

	public void putValue(ParameterCsv pC, Integer i) {

		getParams().put(pC, i);

	}

	public void setParams(HashMap<ParameterCsv, Integer> params) {
		this.params = params;
	}

	public void initValue() {
		for (JRadio jr : getJradiosSelected()) {
			putValue(jr.getParameterCsv(), jr.getColonne());
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

	public List<JRadio> getJradiosSelected() {
		if (jRadiosSelected == null)
			jRadiosSelected = new ArrayList<JRadio>();
		return jRadiosSelected;
	}

	public void addJradio(JRadio jRadio) {

		jRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// récupère le JRadio cliquer
				JRadio jRadio = (JRadio) e.getSource();

				for (int i = getJradiosSelected().size() - 1; i >= 0; i--) {
					JRadio jR = getJradiosSelected().get(i);
					if (jR.mustBeDeselected(jRadio))
						getJradiosSelected().remove(jR);
				}
				getJradiosSelected().add(jRadio);
			}
		});
	}

	public String getSeparator() {
		return Separator;
	}

	public void setSeparator(String separator) {
		Separator = separator;
	}

}
