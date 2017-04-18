package com.yuer.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class YuerTag extends TagSupport {

	private static final long serialVersionUID = 6815780388418689148L;
	private String module;
	private String core;
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	
	@Override
	public int doStartTag() throws JspException{
		Boolean result = false;
		String userId = pageContext.getRequest().getParameter("userId");
		String param = this.module + "_" + this.core + "_" + userId;
		result = YuerTagUtils.getButton(param);
		return result ? EVAL_BODY_INCLUDE : SKIP_BODY;
	}
	
	
}
