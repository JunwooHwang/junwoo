package org.jun.controller;

import org.jun.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value = "sample", method = RequestMethod.GET)  // 웹브라우저를 분석해주는 역할
	
   /* 
    * GET : 속도는 빠르지만 보안 취약
    * POST: 속도는 느리지만 보안 보장(회원가입할 시)
    * */

	public void basic() {
		logger.info("sample 실행됨."); // console 역할
	}
	
	@RequestMapping(value = "sample/ex01", method = RequestMethod.GET)  // 웹브라우저를 분석해주는 역할
	public void basic1() {
		logger.info("sample 실행됨."); // console 역할
	}
	
	@RequestMapping(value = "smaple/index",method = RequestMethod.GET)
	public void index() {
		
	}
	
	@RequestMapping(value = "smaple/member",method = RequestMethod.GET)
	public void member(String id, String pw, String name) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
	}
	
	@RequestMapping(value = "smaple/memberDTO",method = RequestMethod.GET)
	public void memberdto(SampleMemberDTO smd) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
	}
	
	// 리턴이 없으면 주소(value)가 jsp의 이름이 됨
	
}
 