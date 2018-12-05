package fr.paquet.ihm.nouveau;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.projet.*;

public class JSearchResponsable extends JSearchDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabelJTextField jtfNom = null;


	public JSearchResponsable(String nom) {
		super();
		
		jtfNom = new JLabelJTextField(getPanelCritere(), "Nom", 0, 0);
		jtfNom.setText(nom);
		doSearchAction();
	}

	@Override
	public List getValues() {
		if (jtfNom == null)
			return new ArrayList();
		ResponsableFactory cF = new ResponsableFactory();
		return cF.findResponsablesByName(jtfNom.getText());
	}

	@Override
	public String[] getColumnsName() {
		return new String[] { "nom", "prenom" };
	}

	@Override
	public Class[] getColumnsClass() {
		return new Class[] { String.class, String.class };
	}

	@Override
	public Object getListValue(Object object, int columnIndex) {
		Responsable c = (Responsable) object;
		switch (columnIndex) {
		case 0:
			return c.getNom();
		case 1:
			return c.getPrenom();

		}
		return "";
	}

	@Override
	protected Class getDialogClass() {
		return JModifyResponsable.class;
	}

	
	
	

}
