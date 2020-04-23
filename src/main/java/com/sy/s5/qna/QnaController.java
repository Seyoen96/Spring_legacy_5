package com.sy.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.util.Pager;

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
	
	
	@GetMapping("qnaList")
	public ModelAndView boardList(Pager pager, ModelAndView mv) throws Exception{
		List<BoardDTO> ar = qnaService.boardList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView boardSelect(long num,ModelAndView mv) throws Exception{
		BoardDTO boardDTO = qnaService.boardSelect(num);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, long num) throws Exception{
		mv.addObject("num", num);		//부모의 글번호
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, QnaDTO qnaDTO) throws Exception{
		int result = qnaService.boardReply(qnaDTO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "답글 작성 실패");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
	@GetMapping("qnaWrite")
	public String boardWrite() throws Exception {
		return "board/boardWrite";
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(QnaDTO qnaDTO, ModelAndView mv,MultipartFile[] files) throws Exception{
		int res = qnaService.boardWrite(qnaDTO,files);		
		if(res>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
	@GetMapping("qnaUpdate")
	public ModelAndView boardUpdate(long num, ModelAndView mv) throws Exception{
		BoardDTO boardDTO = qnaService.boardSelect(num);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@PostMapping("qnaUpdate")
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
	
	@GetMapping("qnaDelete")
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int res = qnaService.boardDelete(num);
		if(res>0) {
			mv.addObject("result", "delete success!");
			mv.addObject("path", "./qnaList");
		} else {
			mv.addObject("result", "delete fail!");
			mv.addObject("path", "./qnaSelect?num="+num);
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	
	
	
	
}
