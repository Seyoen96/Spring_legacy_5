package com.sy.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/boardFile/**")
public class BoardFileController {
	
	@Autowired
	private BoardFileService boardFileService;
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileDTO boardFileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFileDTO = boardFileService.fileSelect(boardFileDTO);
		mv.addObject("file", boardFileDTO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(long fileNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(fileNum);
		int res = boardFileService.fileDelete(fileNum);
		mv.addObject("result", res);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
}
