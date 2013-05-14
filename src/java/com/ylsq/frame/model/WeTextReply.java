package com.ylsq.frame.model;

import com.ylsq.frame.other.WeChatMsgType;

public class WeTextReply implements WeChatReply{
	private String ToUserName;//接收方帐号（收到的OpenID）
	private String FromUserName;//开发者微信号 
	private String CreateTime;//消息创建时间 
	private String MsgType = WeChatMsgType.TEXT.getType();
	private String Content;//回复的消息内容,长度不超过2048字节 
	private String FuncFlag;//位0x0001被标志时，星标刚收到的消息。 
	
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(String funcFlag) {
		FuncFlag = funcFlag;
	}
}
