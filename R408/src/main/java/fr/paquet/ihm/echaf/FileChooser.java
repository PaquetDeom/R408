package fr.paquet.ihm.echaf;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import fr.paquet.ihm.main.MainFrame;
import fr.paquet.io.jrxml.GeneratePDF;
import fr.paquet.projet.Projet;

public class FileChooser extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file = null;

	public FileChooser() {

		super();

		addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
		addChoosableFileFilter(new FileNameExtensionFilter("*.xml", "xml"));
		int returnValue = showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			setFile(getSelectedFile());

		}

	}

	public FileChooser(GeneratePDF gP) {

		super();
		
		FileSystemView.getFileSystemView().getHomeDirectory();
		this.setDialogTitle("Sauvegarde : ");
		this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnValue = showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			setFile(getSelectedFile());

		}

	}

	public FileChooser(MainFrame frame) {

		super();

		setMainFrame(frame);
		setDialogTitle("Enregistrer");

		int userSelection = this.showSaveDialog(getMainFrame());

		if (userSelection == JFileChooser.SAVE_DIALOG) {
			File fileToSave = this.getSelectedFile();
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}

	}

	private MainFrame frame = null;

	private void setMainFrame(MainFrame frame) {
		this.frame = frame;
	}

	private MainFrame getMainFrame() {
		return frame;
	}

	public FileChooser(File file) {

		super();

		FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		// add filters
		addChoosableFileFilter(xmlFilter);
		setFileFilter(xmlFilter);

		int returnValue = showSaveDialog(null);

		int status = showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
			File selectedFile = getSelectedFile();
			System.out.println(selectedFile.getParent());
			System.out.println(selectedFile.getName());
		} else if (status == JFileChooser.CANCEL_OPTION) {
			System.out.println(JFileChooser.CANCEL_OPTION);
		}

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			setFile(getSelectedFile());

		}

	}

	public File getFile() {
		return file;
	}

	private void setFile(File file) {
		this.file = file;
	}

}
