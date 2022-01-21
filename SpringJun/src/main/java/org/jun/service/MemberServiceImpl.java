package org.jun.service;

import org.jun.domain.MemberDTO;
import org.jun.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mmapper;

	// 회원가입하기 설계된것을 구현
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto);
	}

	// 로그인 설계된것을 구현
	public MemberDTO login(MemberDTO mdto) {
		return mmapper.login(mdto);
	}
}
