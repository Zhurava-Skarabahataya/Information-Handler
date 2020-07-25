package by.epamtc.textonator.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextDAOImpl implements TextDAO {

	public String readFromFile() throws FileNotFoundException, IOException {
		File file = new File("resourse\\text.txt");

		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
