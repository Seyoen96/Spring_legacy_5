package com.sy.s5.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//모든 메서드의  board 속성을 qna로 지정
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}
	
	
	
	
	
	
	
}
