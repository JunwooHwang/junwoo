package org.jun.controller;

import org.jun.domain.BoardDTO;
import org.jun.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	//	private BoardService service = new BoardService();
	private BoardService service;
	
	@GetMapping("write")
	public void write() {
		System.out.println("aaaa");
	}
	@PostMapping("write")
	public void writePost(BoardDTO board) {
		service.write(board);
		System.out.println("sdsdsd" + board);
	}
	@GetMapping("table")
	public void tablePost() {
		System.out.println("sdsdsd");
	}
}
