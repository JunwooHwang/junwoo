package org.jun.service;

import java.util.ArrayList;

import org.jun.domain.ReplyDTO;
import org.jun.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper rmapper;
	// 게시판 글쓰기 설계된것을 구현
	public int write(ReplyDTO rdto) {
		// insert 성공시 ReplyMapper.java로 부터 1
		// insert 실패시 ReplyMapper.java로 부터 0
		// 값을 리턴 받는다.
		return rmapper.write(rdto);
	}
	// 댓글 목록 리스트 설계된것을 구현
	public ArrayList<ReplyDTO> list(int bno) {
		return rmapper.list(bno);
	}
	// 댓글수정을 하기 위해 댓글내용 가져오기 구현
		public ReplyDTO detail(int rno) {
			return rmapper.detail(rno);
		}
}
