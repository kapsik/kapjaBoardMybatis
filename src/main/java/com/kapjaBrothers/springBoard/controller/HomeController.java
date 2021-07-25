package com.kapjaBrothers.springBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.kapjaBrothers.springBoard.entity.membersData;
import com.kapjaBrothers.springBoard.service.memberService;
import com.kapjaBrothers.springBoard.service.memberServiceImpl;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String homePage() {
		System.out.println("HomeController(homePage)");
		return "home/homePage";
		
	}
	
	@RequestMapping(value = "/kapjaJoinPage",method = RequestMethod.GET)
	public String join() {
		System.out.println("HomeController(join)");
		
		return "home/registerPage";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/idCheck",method = RequestMethod.POST)
	public int idCheck(HttpServletRequest request) {
		System.out.println("HomeController -> idCheck");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		memberService ms = new memberServiceImpl();
		
		int result = 0;
		
		if(ms.idCheck(userId) != 0) {
			result = 1;
		}
		
		System.out.println("controller(idCheck) = "+result);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
	public int emailCheck(HttpServletRequest request){
		System.out.println("HomeController->emailCheck");
		String email = request.getParameter("userEmail");
		System.out.println(email);
		memberService ms = new memberServiceImpl();
		
		int result = 0;
		
		if(ms.emailCheck(email) != 0) {
			result = 1;
		}
		
		System.out.println("controller(emailCheck) = "+result);
		return result;
	}
	
	
	
	
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public String memberJoin(Model model, membersData mData) {
		System.out.println("HomeController(memberJoin)");
		//System.out.println(mData);
		
		memberService ms = new memberServiceImpl();
		ms.memberRegister(mData);
		
		return "home/homePage";
	}

	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public String memberLogin(membersData mData, HttpServletRequest request, RedirectAttributes rttr) {
		System.out.println("HomeController(memberLogin)");
		//System.out.println(mData);
		
		HttpSession session = request.getSession();
		System.out.println("getServletPath = "+request.getServletPath());
		memberService ms = new memberServiceImpl();
		membersData result = ms.memberLogin(mData);
		
		if(result.getId() == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			System.out.println("result = null");
		}else {
			session.setAttribute("member", result);
			System.out.println("result = " + result);
		}
		
		return "redirect:/listViewPage";
		
	}
	
	@RequestMapping(value = "/memberLogout",method = RequestMethod.GET)
	public String memberLogout(HttpSession session) {
		System.out.println("HomeController(memberLogout)");
		
		session.invalidate();
		
		return"redirect:/homePage";
	}

}
