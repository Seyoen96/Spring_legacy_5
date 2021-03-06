package com.sy.s5.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sy.s5.board.file.BoardFileDAO.";
	
	public int fileInsert(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"fileInsert",boardFileDTO);
	}

	public BoardFileDTO fileSelect(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"fileSelect", boardFileDTO);
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", boardFileDTO);
	}
	
	public int fileDeleteAll(Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDeleteAll", num);	
	}
	
	public List<BoardFileDTO> fileList(Long num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList", num);
	}
	
	
	
}
