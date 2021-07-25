package com.kapjaBrothers.springBoard.service;

import com.kapjaBrothers.springBoard.entity.replyData;

public interface replyService {
	public int replyWrite(replyData rData);
	public void replyEdit();
	public void replyUpdate();
	public void replyDelete();
}
