package com.ylsq.frame.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ylsq.frame.model.WeChatIn;
import com.ylsq.frame.model.WeMusicItem;
import com.ylsq.frame.model.WeMusicReply;
import com.ylsq.frame.model.WeNewsItem;
import com.ylsq.frame.model.WeNewsReply;
import com.ylsq.frame.model.WeTextReply;
import com.ylsq.frame.other.WeChatMsgType;
import com.ylsq.frame.utils.Tools;
import com.ylsq.frame.utils.XstreamUtil;

@Service
public class CommonService{
	private static Logger logger = Logger.getLogger(CommonService.class);
	@Resource
	protected JdbcTemplate jdbcTemplate;
	
	public int testQuery(){
		int cnt = jdbcTemplate.queryForInt("select count(1) from t_test");
		logger.debug("cnt:"+cnt);
		return cnt;
	}
	
	
	public boolean validSignature(String signature,String timestamp, String nonce){
		String result = Tools.codeWeChar(timestamp, nonce);
		logger.debug(result);
		return StringUtils.defaultIfBlank(signature,"").equals(result);
	}
	
	public String receiveAndReply(String xml){
		WeChatIn in = XstreamUtil.xml2object(xml, WeChatIn.class);

		if(WeChatMsgType.TEXT.getType().equals(in.getMsgType())){
			String content = in.getContent();
			logger.info(content);
			if("music".equals(content)){
				WeMusicReply music = new WeMusicReply();
				music.setCreateTime(in.getCreateTime());
				music.setFromUserName(in.getToUserName());
				music.setToUserName(in.getFromUserName());
				WeMusicItem item = new WeMusicItem();
				item.setTitle("大地");
				item.setDescription("羽泉--大地");
				item.setMusicUrl("http://ylsq-1047.stor.sinaapp.com/music/dadi.mp3");
				item.setHQMusicUrl("http://ylsq-1047.stor.sinaapp.com/music/dadi.mp3");
				music.setMusic(item);
				
				return XstreamUtil.object2xml(music);
			}
			else if("news".equals(content)){
				WeNewsReply news = new WeNewsReply();
				news.setCreateTime(in.getCreateTime());
				news.setFromUserName(in.getToUserName());
				news.setToUserName(in.getFromUserName());
				WeNewsItem item = new WeNewsItem();
				item.setPicUrl("http://ylsq-1047.stor.sinaapp.com/music/Photo%2013-2-24%2017%2001%2010.jpg");
				item.setUrl("http://ylsq.sinaapp.com");
				item.setDescription("hahahaha");
				item.setTitle("测试条目");
				List<WeNewsItem> items = new ArrayList<WeNewsItem>();
				items.add(item);
				news.setArticles(items);
				news.setArticleCount(items.size()+"");
				return XstreamUtil.object2xml(news);
			}
			else{
				WeTextReply text = new WeTextReply();
				text.setCreateTime(in.getCreateTime());
				text.setFromUserName(in.getToUserName());
				text.setToUserName(in.getFromUserName());
				if(StringUtils.isNumeric(content)){
					Long num = Long.parseLong(content)+1;
					text.setContent(num.toString());
				}
				else{
					text.setContent(content);
				}
				return XstreamUtil.object2xml(text);
			}
		}
		return null;
	}
}
