package com.ylsq.frame.model;

import java.util.List;

import com.ylsq.frame.other.WeChatMsgType;

public class WeNewsReply  implements WeChatReply{
	private String ToUserName;//接收方帐号（收到的OpenID）
	private String FromUserName;//开发者微信号 
	private String CreateTime;//消息创建时间
	private String MsgType = WeChatMsgType.NEWS.getType();
	private String ArticleCount;//图文消息个数，限制为10条以内 
	private List<WeNewsItem> Articles;//多条图文消息信息，默认第一个item为大图 
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public List<WeNewsItem> getArticles() {
		return Articles;
	}
	public void setArticles(List<WeNewsItem> articles) {
		Articles = articles;
	}
}
