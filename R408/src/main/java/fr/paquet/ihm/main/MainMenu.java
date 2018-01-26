package fr.paquet.ihm.main;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Exit;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	public MainMenu() {

		super();

		// Listener g�n�rique qui affiche l'action du menu utilis�
		ActionListener afficherMenuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getActionCommand().equals("Quitter"))
					new Exit();
				else
				System.out.println("El�ment de menu [" + event.getActionCommand() + "] utilis�.");
			}
		};

		// Cr�ation du menu Fichier
		JMenu fichierMenu = new JMenu("Fichier");
		JMenuItem item = new JMenuItem("Nouveau", 'N');
		item.addActionListener(afficherMenuListener);
		fichierMenu.add(item);
		item = new JMenuItem("Ouvrir", 'O');
		item.addActionListener(afficherMenuListener);
		fichierMenu.add(item);
		item = new JMenuItem("Sauver", 'S');
		item.addActionListener(afficherMenuListener);
		fichierMenu.insertSeparator(1);
		fichierMenu.add(item);
		item = new JMenuItem("Quitter");
		item.addActionListener(afficherMenuListener);
		fichierMenu.add(item);

		// Cr�ation du menu Editer

		JMenu editerMenu = new JMenu("Editer");
		item = new JMenuItem("Copier");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(item);
		item = new JMenuItem("Couper");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(item);
		item = new JMenuItem("Coller");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(item);

		// ajout des menus � la barre de menus
		add(fichierMenu);
		add(editerMenu);

	}
}
