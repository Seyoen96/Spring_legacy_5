package com.sy.s5.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s5.AbstractTestCase;
import com.sy.s5.board.BoardDTO;
import com.sy.s5.member.MemberDAO;
import com.sy.s5.member.MemberDTO;
import com.sy.s5.qna.QnaDAO;
import com.sy.s5.qna.QnaDTO;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private MemberDAO memberDAO;
	
	
	public void daoIsNull() {
		assertNotNull(noticeDAO);
	}
	
	
	
	@Test
	public void boardWriteTest() throws Exception {
		String id="";
		String pwd="";
		String name="";
		String email="";
		String phone="";
		long age =0;
		
		for(int i=69; i<100;i++) {
			MemberDTO memberDTO = new MemberDTO();
			if(i%3==0) {
				id="jaaa";
				pwd="111";
				name="ja";
				email="jja@gmail.com";
				phone="010-1111-1234";
				age=20L;
			} else if(i%3 == 1) {
				id="kkoo";
				pwd="222";
				name="ko";
				email="jkkkkk@gmail.com";
				phone="010-0000-1234";		
				age=28L;
			} else if(i%3 == 2) {
				id="ssii";
				pwd="333";
				name="sisi";
				email="ssssiiii@gmail.com";
				phone="010-4444-8787";
				age=30L;
			}
			
			memberDTO.setId(id+i);
			memberDTO.setPwd(pwd+i);
			memberDTO.setName(name);
			memberDTO.setEmail(email);
			memberDTO.setPhone(phone);
			memberDTO.setAge(age);
			
			
			int res = memberDAO.memberJoin(memberDTO);	
			if(i==50 || i==100) {
				Thread.sleep(1000);
			}
		}
	}
	

	
	
	public void boardDeleteTest() throws Exception{
		int res = noticeDAO.boardDelete(1);
		assertNotEquals(0, res);
	}
	

	public void boardUpdateTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("test title33");
		noticeDTO.setNum(2);
		noticeDTO.setContents("test contents33");
		
		int res = noticeDAO.boardUpdate(noticeDTO);
		assertEquals(1, res);	
	}
	
	

	public void hitUpdateTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();	
		noticeDTO.setNum(2);
		int res = noticeDAO.hitUpdate(2);	
		assertEquals(1, res);
	}
	
	
	public void boardSelectTest() throws Exception{
		BoardDTO boardDTO = noticeDAO.boardSelect(2);
		assertNotNull(boardDTO);
		
	}
	

//	public void boardListTest() throws Exception{
//		List<BoardDTO> ar = noticeDAO.boardList();
//	}
	
	
	
}
