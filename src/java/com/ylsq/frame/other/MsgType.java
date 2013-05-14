package com.ylsq.frame.other;

public enum MsgType {
	TEXT("text", "文本消息"), 
	IMAGE("image", "图片链接"), 
	LOCATION("location", "地理位置"),
	LINK("link", "链接消息"),
	EVENT("enent", "事件");
	
	private String type;
	private String description;

	private MsgType(String v, String s) {
		type = v;
		description = s;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
