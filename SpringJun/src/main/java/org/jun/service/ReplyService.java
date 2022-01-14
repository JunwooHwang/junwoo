package org.jun.service;

import java.util.ArrayList;

import org.jun.domain.ReplyDTO;

public interface ReplyService {
	// 댓글 쓰기 설계
	public int write(ReplyDTO rdto);
	// 댓글 목록 리스트 설계
	public ArrayList<ReplyDTO> list(int bno);
	// 댓글수정을 하기 위해 댓글내용 가져오기
	public ReplyDTO detail(int rno);
	// 댓글수정 설계
	public int update(ReplyDTO rdto);
	// 댓글삭제 설계
	public int remove(ReplyDTO rdto);
}
