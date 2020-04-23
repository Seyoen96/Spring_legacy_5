package com.sy.s5.board.file;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s5.board.file.BoardFileDAO;
import com.sy.s5.board.file.BoardFileDTO;

public class BoardFileDAOTest {
	
	@Autowired
	private BoardFileDAO boardFileDAO;

	@Test
	public void BoardFileTest() {
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setBoard("1");
		boardFileDTO.setFileName("zzzz.jpg");
		boardFileDTO.setOriName("erwsfs.jpg");
		boardFileDTO.setNum(2);
		
		System.out.println(boardFileDTO.getFileName());
		
		
		
		
	}

}
