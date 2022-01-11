package org.jun.controller;

import org.jun.domain.BoardDTO;
import org.jun.domain.Criteria;
import org.jun.domain.PageDTO;
import org.jun.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String tables(Criteria cri,Model model) {
		System.out.println("tablelist" + service.list(cri));
		model.addAttribute("list", service.list(cri));
		model.addAttribute("pageMaker", new PageDTO(cri,service.getTotalCount()));
		return "board/table";
	}
	// 게시판 목록 리스트에서 제목을 클릭했을때...
	@GetMapping("detail")
	public void detail(BoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
		System.out.println("detail");
	}
	// 글수정 화면으로.........
	@GetMapping("modify")
	public void modify(BoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
		System.out.println("modify");
	}
	// 글수정 버튼을 크릭하면.........
	@PostMapping("modify")
	public String modifyPost(BoardDTO board,RedirectAttributes rttr) {
		System.out.println(board);
		//업데이트
		service.modify(board);
		rttr.addAttribute("bno", board.getBno());
		return "redirect:/board/detail";
	}
	// 글삭제 버튼을 클릭하면.........
	@GetMapping("remove")
	public String remove(BoardDTO board) {
		System.out.println(board);
		service.remove(board);
		return "redirect:/board/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
