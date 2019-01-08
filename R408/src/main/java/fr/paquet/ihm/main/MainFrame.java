package fr.paquet.ihm.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements WindowListener {

	/**
	 * @author Nathanael
	 * 
	 *         Fenetre pricipale du logiciel<br/>
	 */

	private static MainFrame mainFrame = null;
	private static MainOnglet mainOnglet = null;

	private MainFrame() {
		super("Logiciel de calcul R408");
		addWindowListener(this);
		setAlwaysOnTop(false);
		setMinimumSize(new Dimension(900, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setJMenuBar(MainMenu.getUniqInstance());
		add(getmasterPanel());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private Component getmasterPanel() {
		JPanel p = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("target/classes/images/echafaudage.jpeg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(img.getScaledInstance(getWidth(), -1, Image.SCALE_SMOOTH), 0, 0, null);
			}

		};
		p.setLayout(new BorderLayout());
		p.add(getMainOnglet(), BorderLayout.CENTER);
		return p;
	}

	/**
	 * 
	 * @return l'instance unique de la class<br/>
	 */
	public static MainFrame getUniqInstance() {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		return mainFrame;
	}

	/**
	 * 
	 * @return le menu principal<br/>
	 * @throws IOException
	 */
	public static MainOnglet getMainOnglet() {
		if (mainOnglet == null)
			mainOnglet = MainOnglet.getUniqInstance();
		return mainOnglet;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
