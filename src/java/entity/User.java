package com.boot.entity;

public class User {
	
	private String username;
	private String password;
	private String verification;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerification() {
		return verification;
	}
	public void setVerification(String verification) {
		this.verification = "NOT_VERIFIED";
	}
	public User(String username, String password, String verification) {
		super();
		this.username = username;
		this.password = password;
		this.verification = "NOT_VERIFIED";
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", verification=" + verification + "]";
	}
	public User() {
		super();
		this.verification = "NOT_VERIFIED";
		// TODO Auto-generated constructor stub
	}
}
