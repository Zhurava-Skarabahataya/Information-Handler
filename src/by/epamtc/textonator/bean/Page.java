package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Page implements TextElement {

	private static final long serialVersionUID = 1L;

	private String pageText;
	private List<Paragraph> paragraphs = new ArrayList<Paragraph>();

	public Page(String pageText) {
		this.setPageText(pageText);
	}

	public String getPageText() {
		return pageText;
	}

	public void setPageText(String pageText) {
		this.pageText = pageText;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public void addParagraph(Paragraph paragraph) {
		paragraphs.add(paragraph);
	}

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public Paragraph getParagraph(int index) {
		return paragraphs.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageText == null) ? 0 : pageText.hashCode());
		result = prime * result + ((paragraphs == null) ? 0 : paragraphs.hashCode());
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
		Page other = (Page) obj;
		if (pageText == null) {
			if (other.pageText != null)
				return false;
		} else if (!pageText.equals(other.pageText))
			return false;
		if (paragraphs == null) {
			if (other.paragraphs != null)
				return false;
		} else if (!paragraphs.equals(other.paragraphs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Page [pageText=" + pageText + ", paragraphs=" + paragraphs + "]";
	}

}
