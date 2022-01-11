package org.jun.service;

import java.util.ArrayList;

import org.jun.domain.BoardDTO;
import org.jun.domain.Criteria;
import org.jun.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper bmapper;
	// 게시판 글쓰기 설계된것을 구현
	public void write(BoardDTO board) {
		//선언부
		bmapper.write(board);
	}
	// 게시판 목록 리스트 구현
	public ArrayList<BoardDTO> list(Criteria cri) {
		return bmapper.list(cri);
	}
	// 게시판 목록 리스트에서 제목을 클릭했을때 게시판 상세페이지 설계된것을 구현
	@Transactional
	public BoardDTO detail(BoardDTO board) {
		// board테이블에 조회수 속성에 +1
		bmapper.cntupdate(board);
		// 상세페이지 select
		return bmapper.detail(board);
	}
	// 게시판 글수정 설계된것을 구현
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	// 게시판 글삭제 설계된것을 구현
	public void remove(BoardDTO board) {
		bmapper.remove(board);
	}
	// 게시판 페이징에 쓰일 데이터건수 구현
	public int getTotalCount() {
		return bmapper.getTotalCount();
	}
}
