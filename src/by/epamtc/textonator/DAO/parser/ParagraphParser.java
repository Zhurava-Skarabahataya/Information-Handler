package by.epamtc.textonator.DAO.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textonator.bean.Paragraph;
import by.epamtc.textonator.bean.Sentence;
import by.epamtc.textonator.bean.TextElement;
import by.epamtc.textonator.property.PatternForRegex;

public class ParagraphParser implements Parser {

	private static final ParagraphParser instance = new ParagraphParser();
	private final Parser nextParser = SentenceParser.getInstance();

	private ParagraphParser() {

	}

	public static ParagraphParser getInstance() {

		return instance;
	}

	@Override
	public void parse(TextElement textElement) {

		if (textElement.getClass().getSimpleName().equals("Paragraph")) {

			Paragraph paraprahp;
			String paragpahpText;

			paraprahp = (Paragraph) textElement;
			paragpahpText = paraprahp.getParagraphText();

			Pattern pattern = PatternForRegex.getInstance().getPatternForParsingParagraphsIntoSentences();
			Matcher matcher = pattern.matcher(paragpahpText);

			while (matcher.find()) {

				String sentence;
				sentence = matcher.group();

				Sentence parsedSentense = new Sentence(sentence);

				paraprahp.addSentence(parsedSentense);

				nextParser.parse((TextElement) parsedSentense);
			}
		}

	}

}
