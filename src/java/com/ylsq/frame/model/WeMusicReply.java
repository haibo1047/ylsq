package com.ylsq.frame.model;

import com.ylsq.frame.other.WeChatMsgType;

public class WeMusicReply implements WeChatReply{
	private String ToUserName;//接收方帐号（收到的OpenID） 
	private String FromUserName;//开发者微信号
	private String CreateTime;//消息创建时间 
	private String MsgType = WeChatMsgType.MUSIC.getType();
	private WeMusicItem Music;
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
	public WeMusicItem getMusic() {
		return Music;
	}
	public void setMusic(WeMusicItem music) {
		Music = music;
	}
	public String getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(String funcFlag) {
		FuncFlag = funcFlag;
	}
}
