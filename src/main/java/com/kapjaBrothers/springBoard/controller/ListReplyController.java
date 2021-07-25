package com.kapjaBrothers.springBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapjaBrothers.springBoard.entity.replyData;
import com.kapjaBrothers.springBoard.service.listService;
import com.kapjaBrothers.springBoard.service.listServiceImpl;
import com.kapjaBrothers.springBoard.service.replyService;
import com.kapjaBrothers.springBoard.service.replyServiceImpl;

@Controller
public class ListReplyController {
	
	@RequestMapping(value = "/replyWrite",method = RequestMethod.GET)
	public String replyWrite(replyData rData, Model model) {
		System.out.println("ListReplyController -> replyWrite");
		
		replyService rs = new replyServiceImpl();
		//model.addAttribute("bno", rs.replyWrite(rData));
		int bno = rs.replyWrite(rData);
		
		listService ls = new listServiceImpl();
		model.addAttribute("list",ls.listViewDetail(bno));
		model.addAttribute("rList",ls.replyView(bno));
		return "list/listViewDetailPage";
		
	}
}
