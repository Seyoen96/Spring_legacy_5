package com.sy.s5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.notice.NoticeService;
import com.sy.s5.util.Pager;


//rescontroller		: responseBody를 모든 메서드에 다 적용시키는 기능과 같음
@RestController
@RequestMapping("json")
public class JsonController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@GetMapping("json1")
	public List<BoardDTO> json1(Pager pager) throws Exception{
//		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeService.boardSelect(30);
		List<BoardDTO> ar = noticeService.boardList(pager);		
		
//		mv.addObject("result", "{\"name\":\"sy\"}");
//		mv.addObject("result", json);
//		mv.setViewName("common/ajaxResult");
		return ar;
	}
	
	
	
	
}
