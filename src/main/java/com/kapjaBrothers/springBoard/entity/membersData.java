package com.kapjaBrothers.springBoard.entity;

public class membersData {

	String id;
	String password;
	String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public membersData() {
		
	}
	
	public membersData(String id, String password, String email) {
		
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	public membersData(String id, String password) {
		
		this.id = id;
		this.password = password;
		
	}
	
	@Override
	public String toString() {
		return "membersData 객체 [id=" + id + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
	
}
