package by.epamtc.textonator.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.epamtc.textonator.DAO.TextDAO;
import by.epamtc.textonator.DAO.TextDAOImpl;
import by.epamtc.textonator.DAO.parser.CodeBlockParser;
import by.epamtc.textonator.DAO.parser.PageParser;
import by.epamtc.textonator.DAO.parser.Parser;
import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.bean.TextElement;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		TextDAOImpl te = new TextDAOImpl();
		String text = te.readFromFile();
		Text textElement = new Text();
		textElement.setText(text);
		//System.out.println(te.readFromFile());
//		Parser codeParser = new CodeBlockParser();
//		codeParser.parse(textElement);
		
		PageParser pp = PageParser.getInstance();
		pp.parse(textElement);
		
	}

}
