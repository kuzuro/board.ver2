package com.kboard.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kboard.domain.BoardVO;
import com.kboard.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Inject
	BoardService service;
	
	// 게시물 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);	
	}
	
	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
	
	}
	
	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
	
		service.write(vo);
		
		return "redirect:/board/list";	
	}
	
	// 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
	 
		BoardVO view = null;
		view =  service.view(bno);
		
		model.addAttribute("view", view);	
	}	
	
	// 게시물 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void getUpdate(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO view = null;
		view =  service.view(bno);
		
		model.addAttribute("view", view);	
	}	
	
	// 게시물 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(BoardVO vo) throws Exception {
	
		service.update(vo);
		
		return "redirect:/board/list";	
	}

}