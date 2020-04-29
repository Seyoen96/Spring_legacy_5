package com.sy.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	
	@PostMapping("fileInsert")
	public ModelAndView fileInsert(MultipartFile files) throws Exception{
		ModelAndView mv = new ModelAndView();
		String fileName = boardFileService.fileInsert(files);
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
		
	
	@PostMapping("summerDelete")
	public ModelAndView fileDelete(String fileName) throws Exception{
		ModelAndView mv = new ModelAndView();
		int res = boardFileService.fileDelete(fileName);
		mv.addObject("result", res);
		mv.setViewName("common/ajaxResult");	
		return mv;
	}
	
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int fileDelete(BoardFileDTO boardFileDTO) throws Exception{
//		ModelAndView mv = new ModelAndView();
		
		int res = boardFileService.fileDelete(boardFileDTO);
//		mv.addObject("result", res);
//		mv.setViewName("common/ajaxResult");
		return res;
	}
	
	
	
}
