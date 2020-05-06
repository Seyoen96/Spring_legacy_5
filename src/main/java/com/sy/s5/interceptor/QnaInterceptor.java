package com.sy.s5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.member.MemberDTO;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		Object obj = request.getSession().getAttribute("member");
		
		if(obj!=null) {
			check=true;
		} else {
			response.sendRedirect("../member/memberLogin");
		}
		
		return check;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {		
		
		String method = request.getMethod();
		String path = request.getServletPath();
		path = path.substring(path.lastIndexOf("/"));
		System.out.println(path);		
		
		if(method.equals("GET")&&path.equals("/qnaUpdate")) {
			MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
			BoardDTO boardDTO = (BoardDTO)modelAndView.getModel().get("dto");
			String board = (String)modelAndView.getModel().get("board");
			board = "./"+board+"List";
			
			if(memberDTO!=null) {
				System.out.println("로그인 상태");
				if(!memberDTO.getId().equals(boardDTO.getWriter())) {
					// 작성자와 수정한 사람이 다른 경우
					modelAndView.setViewName("redirect:./qnaList");
				}
			}	else {
				//로그인 X 경우
				modelAndView.addObject("result", "권한이 없음");
				modelAndView.addObject("path", board);
				modelAndView.setViewName("common/result");
			}	
		}
	}
	
	
	
	
}
