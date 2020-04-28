package com.sy.s5.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.util.Pager;

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
	public ModelAndView boardList(Pager pager, ModelAndView mv) throws Exception{
		List<BoardDTO> ar = noticeService.boardList(pager);		
		mv.addObject("list",ar);
		mv.addObject("pager", pager);
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
	public ModelAndView boardWrite(MultipartFile[] files, BoardDTO noticeDTO, ModelAndView mv,HttpServletRequest request) throws Exception{
		
		int res = noticeService.boardWrite(noticeDTO, files);
		if(res>0) {
			//성공
			mv.setViewName("redirect:./noticeList");			
		} else {
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
		NoticeDTO noticeDTO = (NoticeDTO) boardDTO;
		
		
		mv.addObject("dto",boardDTO);
		mv.addObject("size", noticeDTO.getBoardFileDTOs().size());
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception{
			
		int res = noticeService.boardUpdate(boardDTO, files);
		System.out.println("update");
		String path ="";		
		if(res>0) {
			path="redirect:./noticeList";		
		} else {
			path="redirect:./noticeSelect?num="+boardDTO.getNum();
		}
		return path;
	}
	
	
	
	
}
