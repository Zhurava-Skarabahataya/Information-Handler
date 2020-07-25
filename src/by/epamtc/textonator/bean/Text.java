package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextElement{

	private String text;
	private List <Sentence> sentences = new ArrayList<Sentence>();
	private Code code;

	public List<Sentence> getSentences() {
		return sentences;
	}

	public Code getCode() {
		return code;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	
	public void addSentence(Sentence sentence) {
		sentences.add(sentence);
	}
	
	public Sentence getSentence(int index) {
		return sentences.get(index);
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
	
}
