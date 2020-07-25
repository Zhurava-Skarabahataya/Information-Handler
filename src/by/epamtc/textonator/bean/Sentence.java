package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

	private List<Word> words = new ArrayList<Word>();

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public void addWord(Word word) {
		words.add(word);
	}

	public Word getWord(int index) {
		return words.get(index);
	}

}
