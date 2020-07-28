package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextElement {

	private String paragraphText;
	private List<Sentence> sentences = new ArrayList<Sentence>();

	public Paragraph() {

	}

	public Paragraph(String paragraphText) {
		this.paragraphText = paragraphText;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paragraphText == null) ? 0 : paragraphText.hashCode());
		result = prime * result + ((sentences == null) ? 0 : sentences.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paragraph other = (Paragraph) obj;
		if (paragraphText == null) {
			if (other.paragraphText != null)
				return false;
		} else if (!paragraphText.equals(other.paragraphText))
			return false;
		if (sentences == null) {
			if (other.sentences != null)
				return false;
		} else if (!sentences.equals(other.sentences))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paragraph [paragraphText=" + paragraphText + ", sentences=" + sentences + "]";
	}

}
