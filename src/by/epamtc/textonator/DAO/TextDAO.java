package by.epamtc.textonator.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TextDAO {

	public String readFromFile() throws FileNotFoundException, IOException;
}
