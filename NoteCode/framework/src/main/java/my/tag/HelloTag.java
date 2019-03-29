package my.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	
	private String who = "";
	
	StringWriter sw = new StringWriter();
	
	@Override
	public void doTag() throws JspException, IOException {
		// 获取标签体内容传给sw
		getJspBody().invoke(sw);
		
		JspContext jctx = this.getJspContext();
		jctx.getOut().write("hello "+this.who+"!"+sw.toString());
		
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

}
