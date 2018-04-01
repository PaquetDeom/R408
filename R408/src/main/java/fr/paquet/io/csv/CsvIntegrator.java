package fr.paquet.io.csv;

import java.io.File;

public class CsvIntegrator {

	private File file = null;

	public CsvIntegrator(File file) {

		super();
		setFile(file);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
