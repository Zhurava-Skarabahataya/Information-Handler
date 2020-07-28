package by.epamtc.textonator.DAO.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textonator.bean.PunctuationMark;
import by.epamtc.textonator.bean.Sentence;
import by.epamtc.textonator.bean.TextElement;
import by.epamtc.textonator.bean.UnparsableTextElement;
import by.epamtc.textonator.bean.Word;
import by.epamtc.textonator.property.PatternForRegex;

public class SentenceParser implements Parser {

	private static final SentenceParser instance = new SentenceParser();

	private SentenceParser() {

	}

	public static SentenceParser getInstance() {
		return instance;
	}

	@Override
	public void parse(TextElement textElement) {
		if (textElement.getClass().getSimpleName().equals("Sentence")) {

			Sentence sentence;
			String textOfSentence;

			sentence = (Sentence) textElement;
			textOfSentence = sentence.getSentenceText();

			PatternForRegex patternForRegex = PatternForRegex.getInstance();

			Pattern pattern = patternForRegex.getPatternForParsingSentenceElements();
			Matcher matcher = pattern.matcher(textOfSentence);

			while (matcher.find()) {

				String sentenceElement;
				sentenceElement = matcher.group();

				if (sentenceElement.matches(patternForRegex.getRegexForWord())) {
					Word word = new Word(sentenceElement);

					sentence.addSentenceElement(word);

				} else if (sentenceElement.matches(patternForRegex.getRegexForPunctuationMark())) {
					PunctuationMark punctuationMark = new PunctuationMark(sentenceElement);
					
					sentence.addSentenceElement(punctuationMark);

				} else {
					UnparsableTextElement unparsableTextElement = new UnparsableTextElement(sentenceElement);
					
					sentence.addSentenceElement(unparsableTextElement);

				}
			}

		}
	}

}
