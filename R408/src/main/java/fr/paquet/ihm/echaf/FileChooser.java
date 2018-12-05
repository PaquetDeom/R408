package fr.paquet.ihm.echaf;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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

	public FileChooser(File file) {

		super();

		FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		// add filters
		addChoosableFileFilter(xmlFilter);
		setFileFilter(xmlFilter);

		int returnValue = showSaveDialog(null);

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
