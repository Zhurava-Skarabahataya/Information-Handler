package by.epamtc.textonator.DAO;

import by.epamtc.textonator.DAO.reader.SourceFileReader;
import by.epamtc.textonator.bean.Page;
import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.DAO.exception.DAOException;
import by.epamtc.textonator.DAO.parser.PageParser;
import by.epamtc.textonator.DAO.parser.Parser;
import by.epamtc.textonator.DAO.reader.ReaderProvider;

public class TextDAOImpl implements TextDAO {

	public void readFromFile() throws DAOException {

		Parser parser;
		ReaderProvider readerProvider;
		SourceFileReader fileReader;
		
		parser = PageParser.getInstance();
		
		readerProvider = ReaderProvider.getInstance();
		fileReader = readerProvider.getFileReader();

		while (fileReader.hasTextToRead()) {

			String textPart;
			Page page;
			Text text;

			textPart = fileReader.read();

			page = new Page(textPart);

			text = Text.getInstance();
			text.addText(textPart);

			parser.parse(page);
		}

	}

}
