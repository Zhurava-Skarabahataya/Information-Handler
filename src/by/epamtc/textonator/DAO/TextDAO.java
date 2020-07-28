package by.epamtc.textonator.DAO;

import by.epamtc.textonator.DAO.exception.DAOException;

public interface TextDAO {

	public void readFromFile() throws DAOException;
}
