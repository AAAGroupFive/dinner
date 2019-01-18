package com.dinner.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @className:MessageText
 * @discription:
 * @author:zz
 * @crateTime:2019-01-13 15:35
 */
@XmlRootElement(name="xml") //返回XML
@XmlAccessorType(XmlAccessType.FIELD) //序列化
public class MessageText {
	@XmlElement
	private String ToUserName;
	@XmlElement
	private String FromUserName;
	@XmlElement
	private String CreateTime;
	@XmlElement
	private String MsgType;
	@XmlElement
	private String Content;
	@XmlElement
	private String MsgId;

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

	public MessageText(String toUserName, String fromUserName, String createTime, String msgType, String content, String msgId) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = content;
		MsgId = msgId;
	}

	public MessageText() {
	}
}
