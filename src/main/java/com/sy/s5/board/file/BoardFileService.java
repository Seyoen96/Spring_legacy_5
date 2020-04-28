package com.sy.s5.board.file;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.s5.util.FileSaver;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;
	
	
	
	public BoardFileDTO fileSelect(BoardFileDTO boardFileDTO) throws Exception{
		return boardFileDAO.fileSelect(boardFileDTO);
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO) throws Exception{
		boardFileDTO = boardFileDAO.fileSelect(boardFileDTO);
		int res = boardFileDAO.fileDelete(boardFileDTO);
		String board ="uploadnotice";
		if(boardFileDTO.getBoard().equals("2")) {
			board="uploadQna";
		}
		String path = servletContext.getRealPath("/resources/"+board);
		System.out.println(path);
		fileSaver.deleteFile(boardFileDTO.getFileName(), path);
		
		return res;
	}
	
	
	
	public List<BoardFileDTO> fileList(Long num) throws Exception{
		return boardFileDAO.fileList(num);
	}
	
	

}
