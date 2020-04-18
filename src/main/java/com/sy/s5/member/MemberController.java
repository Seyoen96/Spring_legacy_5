package com.sy.s5.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "memberLogin", method=RequestMethod.GET)
	public String memberLogin() throws Exception{
		return "member/memberLogin";
	}
	
	@RequestMapping(value = "memberLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(HttpSession session,MemberDTO memberDTO,ModelAndView mv) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		if(memberDTO!=null) {
			session.setAttribute("member", memberDTO);
			mv.setViewName("index");
		} else {
			mv.addObject("result", "login fail!");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
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
	public ModelAndView memberJoin(MemberDTO memberDTO, ModelAndView mv) throws Exception{
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
