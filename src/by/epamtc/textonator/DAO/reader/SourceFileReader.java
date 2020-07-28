package by.epamtc.textonator.DAO.reader;

import by.epamtc.textonator.DAO.exception.DAOException;

public interface SourceFileReader {

	public String read() throws DAOException; 

	public boolean hasTextToRead();
	
}
