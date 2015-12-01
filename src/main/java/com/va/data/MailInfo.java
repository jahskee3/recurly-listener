package com.va.data;

import java.io.Serializable;

public class MailInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String TYPE_HTML = "text/html";
	public static final String TYPE_PLAIN = "text/plain";
	
	private String sender;	
	private String senderName;
	
	private String recipient;
	private String recipientName;
	
	private String subject;
	private String body;	
	
	private String contentType;
	private String attachmentFile;
 
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public void setSender(String sender, String senderName) {
		this.sender = sender;
		this.senderName = senderName;
	}	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public void setRecipient(String recipient, String recipientName) {
		this.recipient = recipient;
		this.recipientName = recipientName;
	}	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttachmentFile() {
		return attachmentFile;
	}
	public void setAttachmentFile(String attachmentFile) {
		this.attachmentFile = attachmentFile;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
 
}
