package org.jun.service;

import java.util.ArrayList;

import org.jun.domain.AttachFileDTO;
import org.jun.domain.BoardDTO;
import org.jun.domain.Criteria;
import org.jun.mapper.AttachMapper;
import org.jun.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper bmapper;
	@Autowired
	private AttachMapper amapper;
	
	
	// 게시판 글쓰기 설계된것을 구현
	@Transactional
	public void write(BoardDTO board) {
		//선언부  제목과 내용을 board테이블에 insert
		bmapper.insertSelectKey(board);
		
		//파일명,파일경로,파일타입,uuid값을 attach테이블에 insert
		//BoardDTO에 있는 ArrayList를 가져와서 반복문으로 실행하여 attach변수에 저장
		board.getAttachList().forEach(attach->{
			// BoardDTO의 bno값을 가져와서 AttachFileDTO에 bno에 저장	
			attach.setBno(board.getBno());
			System.out.println("attach테이블의 bno=" + attach.getBno());
			amapper.insert(attach);
			
		});
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
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
	
	// 게시판 상세페이지에 업로드된 이미지 출력
	public ArrayList<AttachFileDTO> fileList(int bno){
		return amapper.fileList(bno);
	}
}
