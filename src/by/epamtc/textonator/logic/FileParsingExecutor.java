package by.epamtc.textonator.logic;

import by.epamtc.textonator.DAO.TextDAO;
import by.epamtc.textonator.DAO.TextDAOImpl;
import by.epamtc.textonator.DAO.exception.DAOException;
import by.epamtc.textonator.main.exception.LogicException;

public class FileParsingExecutor {

	private static final FileParsingExecutor instance = new FileParsingExecutor();

	private FileParsingExecutor() {

	}

	public static FileParsingExecutor getInstance() {
		return instance;
	}

	public void executeFileParsing() throws LogicException {
		
		TextDAO textDAO = new TextDAOImpl();

		try {
			textDAO.readFromFile();
			
		} catch (DAOException e) {
			throw new LogicException(e);
		}
	}
}
