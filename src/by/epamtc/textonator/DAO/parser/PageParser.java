package by.epamtc.textonator.DAO.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textonator.bean.Code;
import by.epamtc.textonator.bean.CodeBlock;
import by.epamtc.textonator.bean.Page;
import by.epamtc.textonator.bean.Paragraph;
import by.epamtc.textonator.bean.TextElement;
import by.epamtc.textonator.property.PatternForRegex;

public class PageParser implements Parser {

	private static final PageParser instance = new PageParser();
	private final Parser nextParser = ParagraphParser.getInstance();

	public static PageParser getInstance() {
		return instance;
	}

	private PageParser() {
	}

	@Override
	public void parse(TextElement textElement) {

		if (textElement.getClass().getSimpleName().equals("Page")) {

			String text;
			Page page;

			page= (Page) textElement;
			text = page.getPageText();

			PatternForRegex patternForRegex = PatternForRegex.getInstance();

			Pattern pattern = patternForRegex.getPatternForParsingTextIntoParagraphs();
			Matcher matcher = pattern.matcher(text);

			while (matcher.find()) {

				String paragraphText = matcher.group();

				if (paragraphText.contains("{")) {

					StringBuilder codeBlockTextBuilder = new StringBuilder(paragraphText);

					int openCurlyBracketCounter = 1;

					while (openCurlyBracketCounter != 0) {
						
						while (matcher.find()) {
							
							paragraphText = matcher.group();

							if (paragraphText.contains("{")) {
								openCurlyBracketCounter++;
							}
							if (paragraphText.contains("}")) {
								openCurlyBracketCounter--;
							}
							break;
						}
						
						codeBlockTextBuilder.append(paragraphText);
						paragraphText = matcher.group();

					}
					
					String codeBlockText = codeBlockTextBuilder.toString();
					
					CodeBlock codeBlock = new CodeBlock(codeBlockText);

					Code code = Code.getInstance();
					code.addCodeBlock(codeBlock);
					
				} else {
					
					Paragraph paragraph = new Paragraph(paragraphText);

					page.addParagraph(paragraph);

					nextParser.parse(paragraph);
				}
			}

		}

	}

}
