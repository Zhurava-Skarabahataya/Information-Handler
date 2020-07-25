package by.epamtc.textonator.bean;

import java.util.ArrayList;
import java.util.List;

public class Code implements TextElement{

	private List <CodeBlock> codeBlocks = new ArrayList<CodeBlock>();

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
	
}
