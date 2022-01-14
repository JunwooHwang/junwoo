package org.jun.mapper;

import java.util.ArrayList;
import org.jun.domain.ReplyDTO;

public interface ReplyMapper {
	// 댓글 쓰기 설계
	// insert 성공시 ReplyMapper.xml로 부터 1
	// insert 실패시 ReplyMapper.xml로 부터 0
	// 값을 리턴 받는다.
	public int write(ReplyDTO rdto);
	// 댓글 목록 리스트 설계
	public ArrayList<ReplyDTO> list(int bno);
	// 댓글수정을 하기 위해 댓글내용 가져오기 설계
	public ReplyDTO detail(int rno);
	// 댓글 수정 설계
	// update 성공시 ReplyMapper.xml로 부터 1
	// update 실패시 ReplyMapper.xml로 부터 0
	// 값을 리턴 받는다.
	public int update(ReplyDTO rdto);
	// 댓글삭제 설계
	public int remove(ReplyDTO rdto);
}
