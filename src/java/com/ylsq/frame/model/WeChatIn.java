/**
 * 
 */
package com.ylsq.frame.model;

/**
 * @author hopper
 * 微信传入xml对应的对象
 *
 */
public class WeChatIn {
	private String ToUserName;         //          开发者微信号
	private String FromUserName;       //          发送方帐号（一个OpenID） 
	private String CreateTime;         //          消息创建时间 （整型） 
	private String MsgType;            //          消息类型
	private String Content;            //[text]    文本消息内容
	private String PicUrl;             //[image]   图片链接
	private String Location_X;         //[location]地理位置纬度
	private String Location_Y;         //[location]地理位置经度
	private String Scale;              //[location]地图缩放大小
	private String Label;              //[location]地理位置信息
	private String Title;              //[link]    消息标题
	private String Description;        //[link]    消息描述 
	private String Url;                //[link]    消息链接
	private String Event;              //[event]   事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件) 
	private String EventKey;           //[event]   事件KEY值，与自定义菜单接口中KEY值对应
	private String MsgId;              //          消息id，64位整型
	
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
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
