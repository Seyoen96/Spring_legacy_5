package com.sy.s5.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sy.s5.util.Pager;

public interface BoardService {
	
	//List
	public List<BoardDTO> boardList(Pager pager) throws Exception;
	
	//Select
	//hitUpdate는 여기서 실행
	public BoardDTO boardSelect(long num) throws Exception;
	
	//Insert
	public int boardWrite(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	
	//Update
	public int boardUpdate(BoardDTO boardDTO,MultipartFile[] files) throws Exception;
	
	//Delete
	public int boardDelete(long num) throws Exception;
	


}
