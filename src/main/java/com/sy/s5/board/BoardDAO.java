package com.sy.s5.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	//멤버변수 상수
	//추상메서드
	//접근제어자는 public abstract
	//생략해도 자동으로 만들어짐
	
	//Count
	public long boardCount() throws Exception;
	//List
	public List<BoardDTO> boardList(Map<String, Integer> map) throws Exception;
	//Select
	public BoardDTO boardSelect(long num) throws Exception;
	//Insert
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	//Delete
	public int boardDelete(long num) throws Exception;
	//Update
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	//hit update
	public int hitUpdate(long num) throws Exception;
	
	
	
}
