package org.jun.controller;

import org.jun.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("sample")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// @RequestMapping(value = "sample", method = RequestMethod.GET)  // 웹브라우저를 분석해주는 역할
	@GetMapping("sample")
   /* 
    * GET : 속도는 빠르지만 보안 취약
    * POST: 속도는 느리지만 보안 보장(회원가입할 시)
    * */

	public void basic(Model model) {
		logger.info("sample 실행됨."); // console 역할
		// aaaa문자열을 abcd변수에 저장하여 sample.jsp에 보내기
		model.addAttribute("abcd", "aaaa");
	}
	
	// @RequestMapping(value = "sample/ex01", method = RequestMethod.GET)  // 웹브라우저를 분석해주는 역할
	@GetMapping("sample/ex01")
	public void basic1(Model model) {
		logger.info("sample 실행됨."); // console 역할
		model.addAttribute("zzzz", "bbbb");
	}
	
	@RequestMapping(value = "sample/index",method = RequestMethod.GET)
	public void index(Model model) {
		model.addAttribute("xxxx", "cccc");
		
	}
	
	@RequestMapping(value = "sample/member",method = RequestMethod.GET)
	public String member(String id, String pw, String name, Model model) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		
		return "member";
	}
	
	@RequestMapping(value = "sample/memberDTO",method = RequestMethod.POST)
	public void memberdto(SampleMemberDTO smd,Model model) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
		model.addAttribute("id", smd.getId());
		model.addAttribute("pw", smd.getPw());
		model.addAttribute("name", smd.getName());
	}
	
	// 리턴이 없으면 주소(value)가 jsp의 이름이 됨
	
}
 