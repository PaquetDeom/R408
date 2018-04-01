package fr.paquet.ihm.echaf;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.paquet.io.csv.CsvIntegrator;

public class FileChooser extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file = null;

	public FileChooser() {

		super();

		addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
		int returnValue = showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			setFile(getSelectedFile());
			new CsvIntegrator(getSelectedFile());
			System.out.println(getSelectedFile().getAbsolutePath());
		}

	}

	public FileChooser(File file) {

		super();
		showSaveDialog(null);

	}

	public File getFile() {
		return file;
	}

	private void setFile(File file) {
		this.file = file;
	}

}
