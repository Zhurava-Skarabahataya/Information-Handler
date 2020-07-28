package by.epamtc.textonator.DAO.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epamtc.textonator.DAO.exception.DAOException;

public class WholeFileReader implements SourceFileReader {

	private static WholeFileReader instance = new WholeFileReader();
	boolean hasMoreTextToRead;

	private WholeFileReader() {
		hasMoreTextToRead = true;
	}

	public static WholeFileReader getInstance() {
		return instance;
	}

	@Override
	public String read() throws DAOException {
		StringBuilder text = new StringBuilder();

		ResourceProvider resourceProvider = ResourceProvider.getInstance();
		File file = resourceProvider.getFile();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line;

			while ((line = reader.readLine()) != null) {

				text.append(line);
				text.append("\n");
			}
		} catch (FileNotFoundException e) {

			throw new DAOException("File doesn't exist:(");

		} catch (IOException e) {

			throw new DAOException("Reading exception:(");
		}

		hasMoreTextToRead = false;
		return text.toString();
	}

	@Override
	public boolean hasTextToRead() {
		return hasMoreTextToRead;
	}

}
