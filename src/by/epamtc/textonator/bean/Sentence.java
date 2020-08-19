package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextElement {

	private static final long serialVersionUID = 1L;
	
	private String sentenceText;
	private List<SentenceElement> sentenceElements = new ArrayList<SentenceElement>();

	public Sentence() {

	}

	public Sentence(String sentenceText) {
		this.sentenceText = sentenceText;
	}

	public String getSentenceText() {
		return sentenceText;
	}

	public void setSentenceText(String sentenceText) {
		this.sentenceText = sentenceText;
	}

	public List<SentenceElement> getSentenceElements() {
		return sentenceElements;
	}

	public void setSentenceElements(List<SentenceElement> sentenceElements) {
		this.sentenceElements = sentenceElements;
	}

	public void addSentenceElement(SentenceElement sentenceElement) {
		sentenceElements.add(sentenceElement);
	}

	public SentenceElement getSentenceElement(int index) {
		return sentenceElements.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentenceElements == null) ? 0 : sentenceElements.hashCode());
		result = prime * result + ((sentenceText == null) ? 0 : sentenceText.hashCode());
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
		Sentence other = (Sentence) obj;
		if (sentenceElements == null) {
			if (other.sentenceElements != null)
				return false;
		} else if (!sentenceElements.equals(other.sentenceElements))
			return false;
		if (sentenceText == null) {
			if (other.sentenceText != null)
				return false;
		} else if (!sentenceText.equals(other.sentenceText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sentence [sentenceText=" + sentenceText + ", sentenceElements=" + sentenceElements + "]";
	}

}
