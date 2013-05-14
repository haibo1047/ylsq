package com.ylsq.frame.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.service.CommonService;
import com.ylsq.frame.utils.Tools;

@Controller
public class IndexController{
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private CommonService commonService;
	
	
	@RequestMapping("/main")
	public void index(HttpServletRequest request,Model model){
		logger.debug("main=====================");
		int cnt = 0;
		cnt = commonService.testQuery();
		model.addAttribute("cnt", cnt);
	}
	
	@RequestMapping("/wechat")
	public void weChat(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String param = en.nextElement();
			logger.info(param+":"+request.getParameter(param));
		}
		String pageCode = "";
		if(StringUtils.isNotBlank(request.getParameter("echostr"))){
			String signature = StringUtils.defaultIfEmpty(request.getParameter("signature"),"");
			String timestamp = StringUtils.defaultIfEmpty(request.getParameter("timestamp"),"");
			String nonce = StringUtils.defaultIfEmpty(request.getParameter("nonce"),"");
			String echostr = StringUtils.defaultIfEmpty(request.getParameter("echostr"),"");
			if(commonService.validSignature(signature, timestamp, nonce)){
				pageCode = echostr;
			}
			else{
				logger.info("timestamp:{"+timestamp+"};nonce:{"+nonce+"};signature:{"+signature+"}");
			}
		}
		else{
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String reqString = Tools.convertRequest(reader);
			logger.info(reqString);
			if(StringUtils.isBlank(reqString)){
				reqString = "<xml><ToUserName><![CDATA[gh_d70ce9b7ceb9]]></ToUserName><FromUserName><![CDATA[opF_OjqAX4TmlLHcx5EL5gJ4-J50]]></FromUserName><CreateTime>1368285252</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[]]></Content><MsgId>5876740408939118606</MsgId></xml>";
			}
			pageCode = commonService.receiveAndReply(reqString);
		}
		response.getWriter().append(pageCode);
	}
}
