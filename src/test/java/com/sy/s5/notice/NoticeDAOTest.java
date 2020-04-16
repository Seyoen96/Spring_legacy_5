package com.sy.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void daoIsNull() {
		assertNotNull(noticeDAO);
	}
	
//	@Test
//	public void boardWriteTest() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("test title");
//		noticeDTO.setWriter("test writer");
//		noticeDTO.setContents("test contents");
//		int res = noticeDAO.boardWrite(noticeDTO);
//		
//		assertEquals(1, res);
//	}
//	
//	@Test
//	public void boardDeleteTest() throws Exception{
//		int res = noticeDAO.boardDelete(1);
//		assertNotEquals(0, res);
//	}
//	
//	@Test
//	public void boardUpdateTest() throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("test title33");
//		noticeDTO.setNum(2);
//		noticeDTO.setContents("test contents33");
//		
//		int res = noticeDAO.boardUpdate(noticeDTO);
//		assertEquals(1, res);	
//	}
//	
	
	@Test
	public void hitUpdateTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();	
		noticeDTO.setNum(2);
		int res = noticeDAO.hitUpdate(noticeDTO);	
		assertEquals(1, res);
	}
	
	
	
	
}
