package com.kapjaBrothers.springBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapjaBrothers.springBoard.entity.listData;
import com.kapjaBrothers.springBoard.service.listService;
import com.kapjaBrothers.springBoard.service.listServiceImpl;

@Controller
public class ListController {
	
	@RequestMapping(value = "/listViewPage", method = RequestMethod.GET)
	public String listView(Model model) {
		System.out.println("ListController -> listViewPage");
		listService ls = new listServiceImpl();
		
		model.addAttribute("list", ls.listView());
		return "list/listViewPage";
		
	}
	
	@RequestMapping(value = "/listViewDetailPage")
	public String listViewDetail(int bno, Model model) {
		System.out.println("ListController -> listViewDetail");
		
		listService ls = new listServiceImpl();
		model.addAttribute("list",ls.listViewDetail(bno));
		model.addAttribute("rList",ls.replyView(bno));
		return "list/listViewDetailPage";
		
	}
	
	@RequestMapping(value = "/listViewEditPage")
	public String listViewEdit(listData data, Model model) {
		System.out.println("ListController -> listViewEdit");
		System.out.println(data);
		
		model.addAttribute("data", data);
		return "list/listViewEditPage";
		
	}
	
	@RequestMapping(value = "/listUpdate", method = RequestMethod.GET)
	public String listUpdate(listData data) {
		System.out.println("ListController -> listUpdate");
		System.out.println(data);
		
		listService ls = new listServiceImpl();
		ls.listViewUpdate(data);
		return "redirect:listViewPage";
	}
	
	@RequestMapping(value = "/listWritePage", method = RequestMethod.GET)
	public String listWrite() {
		System.out.println("ListController -> listWrite");
		
		return "list/listWritePage";
	}
	
	@RequestMapping(value = "listInsert",method = RequestMethod.GET)
	public String listInert(listData data) {
		System.out.println("ListController -> listInert");
		System.out.println(data);
		listService ls = new listServiceImpl();
		ls.listInsert(data);
		return "redirect:listViewPage";
		
	}
	
	@RequestMapping(value = "/listDelete", method = RequestMethod.GET)
	public String listDelete(int bno) {
		System.out.println("ListController -> listDelete");
		
		listService ls = new listServiceImpl();
		ls.listDelete(bno);
		return "redirect:listViewPage";
		
	}
}
