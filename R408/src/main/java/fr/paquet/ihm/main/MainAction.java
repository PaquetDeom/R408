package fr.paquet.ihm.main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MainAction implements ActionListener {

	private JMenu menu = null;
	private JMenuItem item = null;
	private char shortKey = 0;
	private static ArrayList<MainAction> mActions = null;

	/**
	 * Constructeur de la class<br/>
	 * Action sans touche de racourci<br/>
	 * 
	 * @param menu
	 * @param item
	 */
	private MainAction(JMenu menu, JMenuItem item) {
		super();
		setMenu(menu);
		setJMenuItem(item);
		menu.add(item);
		item.addActionListener(this);
	}

	/**
	 * Constructeur de la class<br/>
	 * Action avec touche de racourci<br/>
	 * 
	 * @param menu
	 * @param item
	 * @param shortKey
	 */
	private MainAction(JMenu menu, JMenuItem item, char shortKey) {
		this(menu, item);
		setShortKey(shortKey);
		item.setAccelerator(getKeyStroke());
	}

	/**
	 * 
	 * @param menu
	 * @param item
	 * @param shortKey
	 * @return L'instance unique de chaque action<br/>
	 */
	public static MainAction getUniqInstance(JMenu menu, JMenuItem item, char shortKey) {

		MainAction mAction = null;

		for (int i = 0; i < getMainActions().size(); i++) {
			JMenu jMenu = getMainActions().get(i).getMenu();
			JMenuItem jItem = getMainActions().get(i).getItem();
			if (jMenu.equals(menu) && jItem.equals(item)) {
				mAction = getMainActions().get(i);
			}
		}

		if (mAction == null) {
			if (shortKey == '0') {
				shortKey = item.getText().charAt(0);
				mAction = new MainAction(menu, item);
				MainAction.addMainAction(mAction);
			} else {
				mAction = new MainAction(menu, item, shortKey);
				MainAction.addMainAction(mAction);
			}

		}

		return mAction;
	}

	/**
	 * 
	 * @return La liste des MainAction<br/>
	 */
	public static ArrayList<MainAction> getMainActions() {
		if (mActions == null)
			mActions = new ArrayList<MainAction>();
		return mActions;
	}

	private static void addMainAction(MainAction mAction) {
		getMainActions().add(mAction);
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
	 * @return L'Item de l'action (Nouveau, Ouvrir...)<br/>
	 */
	public JMenuItem getItem() {
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JMenuItem item = (JMenuItem) event.getSource();
		Action action = Action.getAction(item.getText().toUpperCase());
		action.actionPerf();

	}

}
