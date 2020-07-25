package by.epamtc.textonator.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.epamtc.textonator.DAO.TextDAO;
import by.epamtc.textonator.DAO.TextDAOImpl;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		TextDAO td = new TextDAOImpl();
		System.out.println(td.readFromFile());
		
	}

}
