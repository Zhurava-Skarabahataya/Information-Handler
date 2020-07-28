package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Code implements TextElement{

	private static final Code instance = new Code();
	private List <CodeBlock> codeBlocks = new ArrayList<CodeBlock>();
	
	private Code() {
		
	}

	public static Code getInstance() {
		return instance;
	}
	
	public List<CodeBlock> getCodeBlocks() {
		return codeBlocks;
	}

	public void setCodeBlocks(List<CodeBlock> codeBlocks) {
		this.codeBlocks = codeBlocks;
	}	
	
	public void addCodeBlock(CodeBlock codeBlock) {
		codeBlocks.add(codeBlock);
	}
	
	public CodeBlock getCodeBlock(int index) {
		return codeBlocks.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeBlocks == null) ? 0 : codeBlocks.hashCode());
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
		Code other = (Code) obj;
		if (codeBlocks == null) {
			if (other.codeBlocks != null)
				return false;
		} else if (!codeBlocks.equals(other.codeBlocks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Code [codeBlocks=" + codeBlocks + "]";
	}
	
}
