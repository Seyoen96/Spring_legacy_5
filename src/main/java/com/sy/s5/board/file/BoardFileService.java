package com.sy.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	public BoardFileDTO fileSelect(BoardFileDTO boardFileDTO) throws Exception{
		return boardFileDAO.fileSelect(boardFileDTO);
	}
	
	

}
