package fr.paquet.ihm.alert;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class AlertWindow extends JDialog implements ActionListener {

	@SuppressWarnings("unused")
	private String message = null;
	@SuppressWarnings("unused")
	private String[] buttons = null;

	private ArrayList<AlertListener> listenerList = new ArrayList<AlertListener>();

	public void addButtonListener(AlertListener listener) {
		listenerList.add(listener);
	}

	public AlertWindow(String message) {
		this("Message d'erreur", message);
	}

	public AlertWindow(String title, String message) {
		this(title, message, new String[] { "Ok" });
	}

	public AlertWindow(String title, String message, String[] buttons) {
		super();
		this.message = message;
		this.buttons = buttons;

		setTitle(title);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 600, 400);
		setLocation(screenSize.width / 2 - this.getWidth() / 2, screenSize.height / 2 - this.getHeight() / 2);
		setModal(true);

		final JPanel content = new JPanel();

		BorderLayout layout = new BorderLayout();
		layout.addLayoutComponent(new JTextField(message), null);
		for (String btnName : buttons) {
			JButton button = new JButton(btnName);
			button.addActionListener(this);
			layout.addLayoutComponent(button, null);
		}

		content.add(null, layout);
		add(content);
	}

	public AlertWindow(String title, String message, String[] buttons, AlertListener listener) {
		this(title, message, buttons);
		addButtonListener(listener);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton btn = (JButton) event.getSource();
		for (AlertListener listener : listenerList) {
			listener.buttonClick(btn.getName());
		}
		dispose();
	}
}
