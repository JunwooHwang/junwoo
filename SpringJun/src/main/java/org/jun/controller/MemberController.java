package org.jun.controller;

import javax.servlet.http.HttpSession;

import org.jun.domain.MemberDTO;
import org.jun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService mservice;

	// 회원가입 화면 이동
	@GetMapping("member")
	public void write() {
		System.out.println("member/member");
	}

	// 회원가입 화면을 통해 얻어진 데이터 insert
	@PostMapping("member")
	public void Postmember(MemberDTO mdto) {

		mservice.insert(mdto);
	}

	// 로그인 화면 이동
	@GetMapping("login")
	public void login() {
		System.out.println("member/login");
	}

	// 로그인 화면을 통해 얻어진 데이터를 활용하여 select
	@PostMapping("login")
	public String Postlogin(MemberDTO mdto, HttpSession session) {
		System.out.println(mservice.login(mdto));
		// mservice.login(mdto);를 세션에 저장하기위해 login에 저장
		// MemberDTO에있는 MemberDTO[id=aaaaaaa, password=aaaaaa, name=황준우]를 세션 영역에
		// login이라는 변수에 저장
		MemberDTO login = mservice.login(mdto);
		// 세션객체에 login변수에, login값을 저장(setAttribute)
		session.setAttribute("login", login);
		// session.invalidate(); 로그아웃

		if (session.getAttribute("login") != null) {
			// session영역에 login이라는 변수에 값이 있으면 로그인 된 채로
			// main페이지로 이동
			return "redirect:/";
		} else {
			// session영역에 login이라는 변수에 값이 없으면 (null)
			// 다시 로그인 할 수 있게 로그인 페이지로 이동
			return "redirect:/member/login";
		}

	}
}
