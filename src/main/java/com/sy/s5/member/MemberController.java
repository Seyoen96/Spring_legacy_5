package com.sy.s5.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sy.s5.util.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "memberLogin", method=RequestMethod.GET)
	public void memberLogin(@CookieValue(value = "cId", required=false) String cId,Model model) throws Exception{
//		System.out.println(cId);
		model.addAttribute("cId", cId);
	}
	
	
	@RequestMapping(value = "memberLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(HttpSession session,MemberDTO memberDTO,ModelAndView mv,String remember,HttpServletResponse response) throws Exception {
		
		Cookie cookie = new Cookie("cId", "");
		if(remember!=null) {
			// id를 기억하고싶을 때
//			cookie = new Cookie("cId", memberDTO.getId());
			cookie.setValue(memberDTO.getId());
		} 
//		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		memberDTO = memberService.memberLogin(memberDTO);
		if(memberDTO!=null) {
			session.setAttribute("member", memberDTO);
			mv.setViewName("index");
		} else {
			mv.addObject("result", "login fail!");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "memberList")
	public ModelAndView memberList(Pager memberPager, ModelAndView mv) throws Exception{
		List<MemberDTO> ar = memberService.memberList(memberPager);
		mv.addObject("list", ar);
		mv.addObject("pager", memberPager);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	
	@RequestMapping(value = "memberPage")
	public void memberPage(MemberDTO memberDTO) throws Exception {
		
	}
	
	
	@RequestMapping(value = "memberJoin", method=RequestMethod.GET)
	public String memberJoin() throws Exception{
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "memberJoin", method=RequestMethod.POST)
	public ModelAndView memberJoin(String pic,MemberDTO memberDTO, ModelAndView mv) throws Exception{
		System.out.println("pic: "+pic);
		int res = memberService.memberJoin(memberDTO);
		if(res>0) {
			mv.addObject("result", "회원가입 완료");
			mv.addObject("path", "../");		
		} else {
			mv.addObject("result", "회원가입 실패");
			mv.addObject("path", "./memberJoin");	
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberUpdate", method=RequestMethod.GET)
	public void memberUpdate(HttpSession session) throws Exception{
		
	}
	
	@RequestMapping(value = "memberUpdate", method=RequestMethod.POST)
	public ModelAndView memberUpdate(HttpSession session,MemberDTO memberDTO,ModelAndView mv) throws Exception{
		int res = memberService.memberUpdate(memberDTO);
		session.setAttribute("member", memberDTO);
		if(res>0) {
			mv.addObject("result", "회원정보 수정완료");
			mv.addObject("path", "../");
		} else {
			mv.addObject("result", "회원정보 수정 실패");
			mv.addObject("path", "./memberPage");
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value = "memberDelete", method=RequestMethod.GET)
	public ModelAndView memberDelete(HttpSession session,String id, ModelAndView mv) throws Exception{
		int res = memberService.memberDelete(id);
		if(res>0) {
			mv.addObject("result", "회원 탈퇴 완료");
			mv.addObject("path", "../");
			session.invalidate();
		} else {
			mv.addObject("result", "회원 탈퇴 실패");
			mv.addObject("path", "./memberPage");
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	
	
}
