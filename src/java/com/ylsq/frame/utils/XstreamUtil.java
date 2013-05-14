package com.ylsq.frame.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.ylsq.frame.model.WeChatIn;
import com.ylsq.frame.model.WeMusicItem;
import com.ylsq.frame.model.WeMusicReply;
import com.ylsq.frame.model.WeNewsItem;
import com.ylsq.frame.model.WeNewsReply;
import com.ylsq.frame.model.WeTextReply;

public class XstreamUtil {
	private static Logger logger = Logger.getLogger(XStream.class);
	
	public static <T> T xml2object(String xml,Class<T> clazz){
		T object = null;
		try {
			object = clazz.newInstance();
			object = (T)getXStream(clazz).fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public static <T> String object2xml(T object){
		return getXStream(object.getClass()).toXML(object);
	}
	
	private static <T> XStream getXStream(Class<T> clazz){
		XStream xs = new XStream();
		xs.alias("xml", clazz);
		xs.alias("item", WeNewsItem.class);
		xs.alias("Music", WeMusicItem.class);
		return xs;
	}

	public static void main(String []args){
		testMusic();
	}
	public static void testMusic(){
		WeMusicReply reply = new WeMusicReply();
		reply.setCreateTime("123");
		reply.setFromUserName("fromUser");
		reply.setToUserName("toU");
		WeMusicItem item2 = new WeMusicItem();
		item2.setDescription("2");
		item2.setTitle("222");
		item2.setMusicUrl("t2");
		item2.setHQMusicUrl("uuu2222rrll");
		reply.setMusic(item2);
		
		logger.info(object2xml(reply));
	}
	public static void testNews(String []args){
		WeNewsReply reply = new WeNewsReply();
		reply.setArticleCount("2");
		reply.setCreateTime("123");
		reply.setFromUserName("fromUser");
		reply.setToUserName("toU");
		List<WeNewsItem> articles = new ArrayList<WeNewsItem>();
		WeNewsItem item1 = new WeNewsItem();
		item1.setDescription("1");
		item1.setPicUrl("picUrl");
		item1.setTitle("t1");
		item1.setUrl("uuurrll");
		WeNewsItem item2 = new WeNewsItem();
		item2.setDescription("2");
		item2.setPicUrl("222");
		item2.setTitle("t2");
		item2.setUrl("uuu2222rrll");
		articles.add(item2);
		articles.add(item1);
		reply.setArticles(articles);
		
		logger.info(object2xml(reply));
	}
	public static void test(String []args){
		String xml = "<xml><ToUserName><![CDATA[gh_d70ce9b7ceb9]]></ToUserName><FromUserName><![CDATA[opF_OjqAX4TmlLHcx5EL5gJ4-J50]]></FromUserName><CreateTime>1368285252</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[1234567890]]></Content><MsgId>5876740408939118606</MsgId></xml>";
		WeChatIn obj = xml2object(xml, WeChatIn.class);
		
		WeTextReply reply = new WeTextReply();
		reply.setFromUserName(obj.getToUserName());
		reply.setToUserName(obj.getFromUserName());
		reply.setContent(obj.getContent());
		reply.setCreateTime("123");
		reply.setFuncFlag("1");
		logger.info(object2xml(reply));
	}
}
