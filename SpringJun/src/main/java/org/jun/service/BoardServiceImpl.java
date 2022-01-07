package org.jun.service;

import java.util.ArrayList;

import org.jun.domain.BoardDTO;
import org.jun.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ArrayList<BoardDTO> list() {
		return bmapper.list();
	}
	// 게시판 목록 리스트에서 제목을 클릭했을때 게시판 상세페이지 설계된것을 구현
	public BoardDTO detail(BoardDTO board) {
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
}
