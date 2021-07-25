package com.kapjaBrothers.springBoard.entity;

import java.sql.Date;

public class listDataReply {

	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	private int bhit;
	private int rno;
	
	
	public int getrno() {
		return rno;
	}
	public void setrno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	
	public listDataReply() {
		// TODO Auto-generated constructor stub
	}
	
	public listDataReply(int bno, String btitle, String bcontent, String bwriter, Date bdate, int bhit, int rno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;
		this.bhit = bhit;
		this.rno = rno;
	}
	@Override
	public String toString() {
		return "listDataReply 객체 [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bdate=" + bdate + ", bhit=" + bhit + ", rno=" + rno + "]";
	}
	

	
	
	
	
}
