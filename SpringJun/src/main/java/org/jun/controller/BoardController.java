package org.jun.controller;

import org.jun.domain.BoardDTO;
import org.jun.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	//	private BoardService service = new BoardService();
	private BoardService service;
	// 글쓰기 화면의로 ...
	@GetMapping("write")
	public void write() {
		System.out.println("write");
	}
	// 글쓰기 버튼을 클릭하면 ....
	@PostMapping("write")
	public String writePost(BoardDTO board) {
		service.write(board);
		System.out.println("write post..." + board); 
		return "redirect:/board/list";
	}
	
	// 게시판 목록 리스트
	@GetMapping("list")
	public String tables(Model model) {
		System.out.println("tablelist" + service.list());
		model.addAttribute("list", service.list());
		return "board/table";
	}
	// 게시판 목록 리스트에서 제목을 클릭했을때...
	@GetMapping("detail")
	public void detail(BoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
		System.out.println("detail");
	}
}
