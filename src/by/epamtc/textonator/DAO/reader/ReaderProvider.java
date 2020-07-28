package by.epamtc.textonator.DAO.reader;

import java.io.File;

import by.epamtc.textonator.DAO.exception.DAOException;

public class ReaderProvider {

	private static ReaderProvider instance = new ReaderProvider();
	private int readableSize;

	private ReaderProvider() {
		this.readableSize = 5000000;
	}

	public static ReaderProvider getInstance() {
		return instance;
	}

	public SourceFileReader getFileReader() throws DAOException {

		ResourceProvider resourceProvider = ResourceProvider.getInstance();
		File file = resourceProvider.getFile();

		if (file.exists()) {

			if (file.length() < this.readableSize) {

				return WholeFileReader.getInstance();
			}
			
			return PartFileReader.getInstance();

		} else {
			throw new DAOException("OOOps, file doesn't exist:(");
		}
	}
}
