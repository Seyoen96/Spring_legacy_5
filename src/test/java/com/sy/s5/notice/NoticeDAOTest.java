package com.sy.s5.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s5.AbstractTestCase;
import com.sy.s5.board.BoardDTO;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	public void daoIsNull() {
		assertNotNull(noticeDAO);
	}
	
	
	
	@Test
	public void boardWriteTest() throws Exception {
		String writer="";
		String title="";
		String contents="";
		
		for(int i=0; i<150;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			if(i%3==0) {
				writer="aa";
				title="lalala";
				contents="apple";
			} else if(i%3 == 1) {
				writer="bb";
				title="kiki";
				contents="samsung";				
			} else if(i%3 == 2) {
				writer ="cc";
				title="roro";
				contents="LG";
			}
			noticeDTO.setTitle(title+i);
			noticeDTO.setWriter(writer);
			noticeDTO.setContents(contents+i);
			int res = noticeDAO.boardWrite(noticeDTO);		
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
