package com.sy.s5.board.file;

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
	
	public int fileDelete(long fileNum) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", fileNum);
		
	}
	
	
	
}
