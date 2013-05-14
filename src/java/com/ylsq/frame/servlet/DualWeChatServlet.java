package com.ylsq.frame.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.ylsq.frame.utils.Tools;

public class DualWeChatServlet implements Servlet {
	private static Logger logger = Logger.getLogger(DualWeChatServlet.class);
	
	@Override
	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
		String signature = StringUtils.defaultIfEmpty(request.getParameter("signature"),"");
		String timestamp = StringUtils.defaultIfEmpty(request.getParameter("timestamp"),"");
		String nonce = StringUtils.defaultIfEmpty(request.getParameter("nonce"),"");
		String echostr = StringUtils.defaultIfEmpty(request.getParameter("echostr"),"");
		String result = Tools.codeWeChar(signature, nonce);
		if(signature.equals(result)){
			response.getWriter().append(echostr);
		}
		else{
			logger.info("timestamp:{"+timestamp+"};nonce:{"+nonce+"};signature:{"+signature+"}");
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig sc) throws ServletException {
	}
}
