package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextElement{

	private List <Sentence> sentences = new ArrayList<Sentence>();
	private String paragraphText;
	
	public String getParagraphText() {
		return paragraphText;
	}


	public void setParagraphText(String paragraphText) {
		this.paragraphText = paragraphText;
	}


	public List<Sentence> getSentences() {
		return sentences;
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
}
