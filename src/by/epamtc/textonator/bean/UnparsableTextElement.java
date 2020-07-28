package by.epamtc.textonator.bean;

public class UnparsableTextElement implements TextElement, SentenceElement {

	String element;

	public UnparsableTextElement() {

	}

	public UnparsableTextElement(String element) {
		this.element = element;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
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
		UnparsableTextElement other = (UnparsableTextElement) obj;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UnparsableTextElement [element=" + element + "]";
	}

}
