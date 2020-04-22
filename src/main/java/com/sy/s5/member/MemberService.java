package com.sy.s5.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sy.s5.member.memberFile.MemberFileDAO;
import com.sy.s5.member.memberFile.MemberFileDTO;
import com.sy.s5.util.FileSaver;
import com.sy.s5.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberDTO memberDTO, MultipartFile pic,HttpSession session) throws Exception{
		//member 저장 먼저 실행
		int res = memberDAO.memberJoin(memberDTO);
		
		//HDD에 저장	resources/memberUpload
		//1. 파일을 HDD에 저장
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		String fileName = fileSaver.saveByUtils(pic, path);
		
		//2. 파일명을 DB에 저장
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(pic.getOriginalFilename());
		
		res= memberFileDAO.fileInsert(memberFileDTO);
		
		return res;
	}
	
	
	public MemberFileDTO fileSelect(String id) throws Exception{
		return memberFileDAO.fileSelect(id);
	}
	
	public int fileDelete(String id,HttpSession session) throws Exception{
		MemberFileDTO memberFileDTO = memberFileDAO.fileSelect(id);
		
		
		int res = memberFileDAO.fileDelete(id);
		if(res>0) {
			String path = session.getServletContext().getRealPath("/resources/memberUpload");
			res = fileSaver.deleteFile(memberFileDTO.getFileName(), path);
		}
		return res;
	}
	
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int memberDelete(String id) throws Exception{
		return memberDAO.memberDelete(id);
	}
	
	public List<MemberDTO> memberList(Pager memberPager) throws Exception{
		memberPager.makeRow();
		long totalCount = memberDAO.memberCount(memberPager);
		memberPager.makePage(totalCount);
		return memberDAO.memberList(memberPager);
	}

}
