package by.epamtc.textonator.DAO.reader;

public class PartFileReader implements SourceFileReader {

	private static PartFileReader instance = new PartFileReader();
	boolean hasMoreTextToRead;

	private PartFileReader() {
		hasMoreTextToRead = true;
	}

	public static PartFileReader getInstance() {
		return instance;
	}

	@Override
	public String read() {
		return null;

	}

	@Override
	public boolean hasTextToRead() {
		return hasMoreTextToRead;
	}

}
