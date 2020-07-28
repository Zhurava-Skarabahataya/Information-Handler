package by.epamtc.textonator.property;

import java.util.regex.Pattern;

public class PatternForRegex {

	private static PatternForRegex instance = new PatternForRegex();

	private final String regexForParsingTextIntoParagraphs = ".+\\n";
	private final String regexForParsingParagraphsIntoSentences = "(?:\\n)?[\\w \"':=>{}//!%,\\\\();-]+[.]?";
	private final String regexForOpeningBracket = "([\\w ()]?\\{)";
	private final String regexForClosingBracket = "([\\w ()]?})";
	private final String regexForSentenceElement = "(\\w+)|([,;:\"'%>= ])|(\\\\n)";
	private final String regexForWord = "([\\w\\d]+)";
	private final String regexForPunctuationMark = "([\\.,\\()%;'!\":=-])|(\\\\n)";

	private final Pattern patternForParsingTextIntoParagraphs;
	private final Pattern patternForParsingParagraphsIntoSentences;
	private final Pattern patternForParsingSentenceElements;

	private PatternForRegex() {
		patternForParsingTextIntoParagraphs = Pattern.compile(regexForParsingTextIntoParagraphs);
		patternForParsingParagraphsIntoSentences = Pattern.compile(regexForParsingParagraphsIntoSentences);
		patternForParsingSentenceElements = Pattern.compile(regexForSentenceElement);
	}

	public static PatternForRegex getInstance() {
		return instance;
	}

	public String getRegexForWord() {
		return regexForWord;
	}

	public String getRegexForPunctuationMark() {
		return regexForPunctuationMark;
	}

	public String getRegexForSentenceElement() {
		return regexForSentenceElement;
	}

	public Pattern getPatternForParsingSentenceElements() {
		return patternForParsingSentenceElements;
	}

	public String getRegexForOpeningBracket() {
		return regexForOpeningBracket;
	}

	public String getRegexForClosingBracket() {
		return regexForClosingBracket;
	}

	public Pattern getPatternForParsingTextIntoParagraphs() {
		return patternForParsingTextIntoParagraphs;
	}

	public Pattern getPatternForParsingParagraphsIntoSentences() {
		return patternForParsingParagraphsIntoSentences;
	}

}
