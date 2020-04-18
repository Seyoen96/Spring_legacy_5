package com.sy.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sy.s5.board.BoardDTO;

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
	
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(defaultValue = "1")int curPage, ModelAndView mv) throws Exception{
		List<BoardDTO> ar = qnaService.boardList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception{
		BoardDTO boardDTO = qnaService.boardSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception {
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		int res = qnaService.boardWrite(boardDTO);		
		if(res>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(long num, ModelAndView mv) throws Exception{
		BoardDTO boardDTO = qnaService.boardSelect(num);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardDTO boardDTO) throws Exception{
		int res = qnaService.boardUpdate(boardDTO);
		String path="";
		if(res>0) {
			path="redirect:./qnaList";
		}else {
			path="redirect:./qnaSelect?num="+boardDTO.getNum();
		}
		return path;
	}
	
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int res = qnaService.boardDelete(num);
		if(res>0) {
			mv.addObject("result", "delete success!");
			mv.addObject("path", "./qnaList");
		} else {
			mv.addObject("result", "delete fail!");
			mv.addObject("path", "./qnaSelect");
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	
	
	
	
}
