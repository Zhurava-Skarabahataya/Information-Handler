package by.epamtc.textonator.bean;

public class CodeBlock implements TextElement {

	private static final long serialVersionUID = 1L;
	
	private String codeBlockText;

	public CodeBlock() {

	}

	public CodeBlock(String codeBlockText) {
		this.codeBlockText = codeBlockText;
	}

	public String getCodeBlockText() {
		return codeBlockText;
	}

	public void setCodeBlockText(String codeBlockText) {
		this.codeBlockText = codeBlockText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeBlockText == null) ? 0 : codeBlockText.hashCode());
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
		CodeBlock other = (CodeBlock) obj;
		if (codeBlockText == null) {
			if (other.codeBlockText != null)
				return false;
		} else if (!codeBlockText.equals(other.codeBlockText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodeBlock [codeBlockText=" + codeBlockText + "]";
	}

}
