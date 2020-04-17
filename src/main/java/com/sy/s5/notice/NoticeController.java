package com.sy.s5.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sy.s5.board.BoardDTO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "notice";
	}
	
	
	@RequestMapping(value = "noticeList", method= RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(defaultValue = "1")int curPage, ModelAndView mv) throws Exception{
		System.out.println(curPage);
		
		List<BoardDTO> ar = noticeService.boardList(curPage);
		mv.addObject("list",ar);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeService.boardSelect(num);
		mv.addObject("dto",boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception{
		return "board/boardWrite";		
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		int res = noticeService.boardWrite(boardDTO);
		
		if(res>0) {
			//성공
			mv.setViewName("redirect:./noticeList");			
		} else {
			//실패
			//alert
			mv.addObject("result", "Write Fail!");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int res = noticeService.boardDelete(num);
		
		if(res>0) {
			//성공
			mv.addObject("result", "Delete Success!");
		} else {
			//실패
			mv.addObject("result", "Delete Fail!");
		}
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(long num, ModelAndView mv) throws Exception{	
		BoardDTO boardDTO = noticeService.boardSelect(num);
		mv.addObject("dto",boardDTO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		int res = noticeService.boardUpdate(boardDTO);
		String path ="";
		
		if(res>0) {
			path="redirect:./noticeList";		
		} else {
			path="redirect:./noticeSelect?num="+boardDTO.getNum();
		}
		return path;
	}
	
	
	
	
}
