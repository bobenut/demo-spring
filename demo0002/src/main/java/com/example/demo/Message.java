package com.example.demo;

public class Message {
	private String from;
	private String to;
	private String content;
	
	public Message() {}
	
	public String getFrom() {
		return this.from;
	}
	
	public String getTo() {
		return this.to;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setFrom(String value) {
		this.from = value;
	}
	
	public void setTo(String value) {
		this.to = value;
	}
	
	public void setContent(String value) {
		this.content = value;
	}
}
