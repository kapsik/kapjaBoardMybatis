package com.kapjaBrothers.springBoard.entity;

import java.sql.Date;

public class replyData {
	private int bno;
	private int rno;
	private String content;
	private String writer;
	private Date regDate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public replyData() {
		
	}
	
	public replyData(int bno, int rno, String content, String writer, Date regDate) {
		
		this.bno = bno;
		this.rno = rno;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "replyData [bno=" + bno + ", rno=" + rno + ", content=" + content + ", writer=" + writer + ", regDate="
				+ regDate + "]";
	}
	
	
	
	
}
