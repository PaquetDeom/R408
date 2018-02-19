package fr.paquet.ihm.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import main.*;

public class MainAction implements ActionListener {

	private JMenu menu = null;
	private JMenuItem item = null;
	private char shortKey = 0;

	/**
	 * Constructeur de la class<br/>
	 * Action sans touche de racourci<br/>
	 * @param menu
	 * @param item
	 */
	public MainAction(JMenu menu, JMenuItem item) {
		super();
		setMenu(menu);
		setJMenuItem(item);
		menu.add(item);
		item.addActionListener(this);
	}

	/**
	 * Constructeur de la class<br/>
	 * Action avec touche de racourci<br/>
	 * @param menu
	 * @param item
	 * @param shortKey
	 */
	public MainAction(JMenu menu, JMenuItem item, char shortKey) {
		this(menu, item);
		setShortKey(shortKey);
		item.setAccelerator(getKeyStroke());
	}

	private void setShortKey(char shortKey) {
		this.shortKey = shortKey;

	}

	/**
	 * 
	 * @return La touche de raccourci de l'action<br/>
	 */
	private KeyStroke getKeyStroke() {
		return KeyStroke.getKeyStroke(getShortKey(), Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false);
	}

	private char getShortKey() {

		return shortKey;
	}

	private void setJMenuItem(JMenuItem item) {
		this.item = item;

	}

	private void setMenu(JMenu menu) {
		this.menu = menu;

	}

	/**
	 * 
	 * @return Le menu de l'action<br/>
	 */
	public JMenu getMenu() {
		return menu;
	}

	/**
	 * 
	 * @return L'Item de l'action (Fichier, Editer...)<br/> 
	 */
	public JMenuItem getItem() {
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals("Nouveau")) {
			MainFrame.getMainPanel().add(MainOnglet.getUniqInstance());
			Main.getMainFrame().setVisible(true);
		}
		if (event.getActionCommand().equals("Ouvrir"))
			System.out.println("Ouvrir is click");
		if (event.getActionCommand().equals("Sauver"))
			System.out.println("Sauver is click");
		if (event.getActionCommand().equals("Quitter")) {
			System.out.println("Quitter is click");
			new Exit();
		}
		if (event.getActionCommand().equals("Copier"))
			System.out.println("Copier is click");
		if (event.getActionCommand().equals("Couper"))
			System.out.println("Couper is click");
		if (event.getActionCommand().equals("Coller"))
			System.out.println("Coller is click");

	}

}
