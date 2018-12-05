package fr.paquet.ihm.nouveau;

import fr.paquet.projet.*;


public class JModifyResponsable extends JModifyDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabelJTextField jtfNom = null;
	JLabelJTextField jtfPrenom = null;

	private Responsable getResponsable() {
		return (Responsable) getModifyObject();
	}

	public JModifyResponsable(Object object) {
		super(object);
		jtfNom = new JLabelJTextField(getMaintenancePanel(), "Nom", 0, 0);
		jtfPrenom = new JLabelJTextField(getMaintenancePanel(), "Prenom", 0, 1);
		

		if (getResponsable() != null) {
			jtfNom.setText(getResponsable().getNom());
			jtfPrenom.setText(getResponsable().getPrenom());
			
		}
	}

	public void save() {
		try {
			if (getResponsable() == null)
				setModifyObject(new Responsable());
			getResponsable().setNom(jtfNom.getText());
			getResponsable().setPrenom(jtfPrenom.getText());
			
			new ResponsableFactory().saveResponsable(getResponsable());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
