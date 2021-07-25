package com.kapjaBrothers.springBoard.service;

import java.util.List;

import com.kapjaBrothers.springBoard.entity.listData;
import com.kapjaBrothers.springBoard.entity.listDataReply;
import com.kapjaBrothers.springBoard.entity.replyData;

public interface listService {
	public List<listDataReply> listView();
	public List<listData> listViewDetail(int bno);
	public void listViewEdit();
	public void listViewUpdate(listData data);
	public void listInsert(listData data);
	public void listDelete(int bno);
	public List<replyData> replyView(int bno);
}
