package by.epamtc.textonator.DAO.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textonator.bean.Paragraph;
import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.bean.TextElement;

public class PageParser implements Parser {

	private static final PageParser instance = new PageParser();

	public static PageParser getInstance() {
		return instance;
	}

	private PageParser() {
	}

	@Override
	public void parse(TextElement textElement) {

		if (textElement.getClass().getSimpleName().equals("Text")) {
			System.out.println("Да это текст!");
			System.out.println();
			String regexForParsingPageToParagraphs = ".+\\n";
			Text page = (Text) textElement;
			String text = page.getText();

			Pattern pattern = Pattern.compile(regexForParsingPageToParagraphs);
			Matcher matcher = pattern.matcher(text);

			while (matcher.find()) {
				Paragraph paragraph = new Paragraph();
				String paragraphText = matcher.group();
				paragraph.setParagraphText(paragraphText);
				page.addParagraph(paragraph);

				System.out.println(paragraphText);
				System.out.println();
			}

		}

	}

}
