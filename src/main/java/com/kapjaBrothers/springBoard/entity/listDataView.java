package com.kapjaBrothers.springBoard.entity;

import java.sql.Date;

public class listDataView extends listData{

int cmtCount;



public int getCmtCount() {
	return cmtCount;
}

public void setCmtCount(int cmtCount) {
	this.cmtCount = cmtCount;
}


public listDataView() {
	// TODO Auto-generated constructor stub
}

public listDataView(int bno, String btitle, String bcontent, String bwriter, Date bdate, int bhit,int cmtCount) {
	super();
	this.cmtCount = cmtCount;
}

@Override
public String toString() {
	return "listDataView [cmtCount=" + cmtCount + "]";
}



	
	
}
