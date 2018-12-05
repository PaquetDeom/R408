package fr.paquet.ihm.echaf;

import java.awt.Component;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;



public class PanelEchaf3D extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	//private HTML iFrame = null;

	public PanelEchaf3D() {

		super();
		//setIFrame(iframe);
		add(getJEditorPane());
	}
	
	private Component getJEditorPane() {

		try {
			
			//HTMLEditorKit kit = new HTMLEditorKit();
			URL url = new URL("https://www.google.com");
			url.openConnection();

			JEditorPane editeur = new JEditorPane(url);
			editeur.setEditable(false);

			editeur.addHyperlinkListener(new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent e) {
					if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						URL url = e.getURL();
						if (url == null)
							return;
						try {
							editeur.setPage(e.getURL());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			});
			 
			return editeur;

		} catch (Exception e1) {
			e1.printStackTrace();

		}
		return null;
	}

	/**private void setIFrame(HTML iframe) {

		
		 * "<iframe src=
		 * "https://myhub.autodesk360.com/ue2a6a670/shares/public/SHabee1QT1a327cf2b7afa739ff959d55066?mode=embed"
		 * width="640" height="480" allowfullscreen="true" webkitallowfullscreen="true"
		 * mozallowfullscreen="true" frameborder="0"></iframe>"
		 

		this.iFrame = iframe;

	}

	private HTML getIFrame() {
		return iFrame;
	}*/

}
