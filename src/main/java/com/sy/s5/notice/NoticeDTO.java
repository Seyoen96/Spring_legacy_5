package com.sy.s5.notice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.board.file.BoardFileDTO;

public class NoticeDTO extends BoardDTO {
//	private BoardDTO boardDTO;
//	private MultipartFile[] files;
//
//	public MultipartFile[] getFiles() {
//		return files;
//	}
//	public void setFiles(MultipartFile[] files) {
//		this.files = files;
//	}
	
	private List<BoardFileDTO> boardFileDTOs;

	public List<BoardFileDTO> getBoardFileDTOs() {	
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	
	
	
}
