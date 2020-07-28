package by.epamtc.textonator.DAO.reader;

import java.io.File;

public class ResourceProvider {

	private static ResourceProvider instance = new ResourceProvider();
	private File file;

	private ResourceProvider() {
		this.file = new File("resourse\\text.txt");
	}

	public static ResourceProvider getInstance() {
		return instance;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
