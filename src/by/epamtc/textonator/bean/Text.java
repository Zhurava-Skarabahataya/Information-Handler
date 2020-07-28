package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextElement {

	private static final Text instance = new Text();

	private String text;
	private List<Page> pages = new ArrayList<Page>();
	private Code code = Code.getInstance();

	private Text() {

	}

	public static Text getInstance() {
		return instance;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public void addPage(Page page) {
		pages.add(page);
	}

	public List<Page> getPages() {
		return pages;
	}

	public Page getPage(int index) {
		return pages.get(index);
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public void addText(String addition) {

		if (this.getText() == null) {
			this.setText(addition);
			return;
		}

		String currentText = this.getText();

		String addedText = currentText.concat(addition);
		this.setText(addedText);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Text other = (Text) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Text [text=" + text + ", pages=" + pages + ", code=" + code + "]";
	}

}
