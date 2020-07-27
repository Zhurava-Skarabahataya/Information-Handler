package by.epamtc.textonator.DAO.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.bean.TextElement;

public class CodeBlockParser implements Parser{

	@Override
	public void parse(TextElement textElement) {
		Text text = (Text)textElement;
		String page = text.getText();
		//System.out.println(page + "KJBB");
		String regexForCodeBlocks = "((?:\\n)(.+[}{;]))|((?:\\n)})|(//.+)";
		Pattern p = Pattern.compile(regexForCodeBlocks);
		Matcher m = p.matcher(page);
		
		
		while (m.find()) {
			String code = m.group();
			System.out.println(code);
			System.out.println();
		}
		
	}
	
	

}
