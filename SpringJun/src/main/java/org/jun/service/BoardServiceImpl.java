package org.jun.service;

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
}
