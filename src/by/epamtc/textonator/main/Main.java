package by.epamtc.textonator.main;

import by.epamtc.textonator.logic.FileParsingExecutor;
import by.epamtc.textonator.main.exception.LogicException;

public class Main {

	public static void main(String[] args) throws LogicException {

		FileParsingExecutor executor = FileParsingExecutor.getInstance();
		executor.executeFileParsing();

	}

}
