package com.boot.entity;

public class Email {

	private String to;
	private String subject;
	private String message;

	public Email() {
		super();
	}

	public String getto() {
		return to;
	}

	public void setto(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Email(String to, String subject, String message) {
		this.to = to;
		this.subject = subject;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}
}
