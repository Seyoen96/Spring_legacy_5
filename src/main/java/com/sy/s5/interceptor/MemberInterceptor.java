package com.sy.s5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sy.s5.member.MemberDTO;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(memberDTO!=null) {
			System.out.println("로그인 상태");
			check = true;
		} else {
			System.out.println("로그인 되지 않음");
			request.setAttribute("result", "로그인 필수");
			request.setAttribute("path", "./memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}	
		return check;
	}
	
}
