package by.epamtc.textonator.DAO.reader;

import java.io.File;

public class ResourceProvider {

	private static ResourceProvider instance = new ResourceProvider();
	private File file;
	private static final String FILE_PATH = "resource\\text.txt";

	private ResourceProvider() {
		this.file = new File(FILE_PATH);
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

	public String getFilePath() {
		return FILE_PATH;
	}
		
}
