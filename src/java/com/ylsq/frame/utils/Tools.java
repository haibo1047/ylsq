package com.ylsq.frame.utils;

import java.io.BufferedReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class Tools {
	private static Logger logger = Logger.getLogger(Tools.class);
	private static String token = null;
	
	public static String convertRequest(BufferedReader reader){
		StringBuffer res = new StringBuffer();
		String line=null;  
		try{
			while((line = reader.readLine())!=null){  
				res.append(line);  
			}  
		}catch(Exception exception){
			logger.error("转换请求内容失败："+exception.getMessage());
		}
		return res.toString();
	}
	
	public static String codeWeChar(String timestamp,String nonce){
		List<String> params = new ArrayList<String>(3);
		params.add(token);
		params.add(timestamp);
		params.add(nonce);
		Collections.sort(params);//先按字典序排序
		StringBuffer union = new StringBuffer();
		for(String str : params)
			union.append(str);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(union.toString().getBytes());
			byte[] arrays = md.digest();
			StringBuffer res = new StringBuffer();
			for(byte b : arrays){
				String tmp = java.lang.Integer.toHexString(b & 0XFF); 
				if(tmp.length() == 1)
					res.append("0");
				res.append(tmp);
			}
			return res.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error("加密出错："+e.getMessage());
		}
		return null;
	}
	
	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		Tools.token = token;
	}

	public static void main(String[] args){
		token = "1047";
//		<timestamp:{1368269054};nonce:{1367922383};signature:{8993afe10b6a78b266495dc153e8793bc4159737}>
//		<timestamp:{1368270513};nonce:{1367925889};signature:{c2f360c936ddd2f0033ce9f352840a57ae6091e6}>
		if("c2f360c936ddd2f0033ce9f352840a57ae6091e6".equals(codeWeChar("1368270513", "1367925889"))){
			logger.debug("ok");
		}
		else{
			logger.debug("wrong");
		}
		logger.debug("result:"+codeWeChar("1368270513", "1367925889"));
	}
}
