package org.jun.mapper;

import java.util.ArrayList;

import org.jun.domain.BoardDTO;
import org.jun.domain.Criteria;

public interface BoardMapper {
	// 게시판 글쓰기와 관련이 되어 있는 DB작업에 대한 설계
	public void write(BoardDTO board);
	// 게시판 목록 리스트와 관련이 되어 있는 DB작업에 대한 설계
	public ArrayList<BoardDTO> list(Criteria cri);
	// 게시판 목록 리스트에서 제목을 클릭했을때 게시판 상세페이지와 관련이 되어 있는 DB작업에 대한 설계
	public BoardDTO detail(BoardDTO board);
	// 게시판 목록 리스트에서 제목을 클릭했을때 조회수 +1
	public void cntupdate(BoardDTO board);
	// 게시판 글수정과 관련이 되어 있는 DB작업에 대한 설계
	public void modify(BoardDTO board);
	// 게시판 글삭제와 관련이 되어 있는 DB작업에 대한 설계
	public void remove(BoardDTO board);
	// 게시판 페이징에 쓰일 전체건수
	public int getTotalCount(Criteria cri);
	
}
