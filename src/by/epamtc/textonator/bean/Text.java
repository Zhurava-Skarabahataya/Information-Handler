package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextElement{

	private String text;
	private List <Paragraph> paragraphs = new ArrayList<Paragraph>();
	private Code code;

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public Code getCode() {
		return code;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}
	
	public void addParagraph(Paragraph paragraph) {
		paragraphs.add(paragraph);
	}
	
	public Paragraph getParagraph(int index) {
		return paragraphs.get(index);
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
