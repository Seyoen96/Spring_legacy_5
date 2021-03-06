package com.sy.s5.notice;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.s5.board.BoardDAO;
import com.sy.s5.board.BoardDTO;
import com.sy.s5.util.Pager;


@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sy.s5.notice.NoticeDAO.";
	
	
	public long boardNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"boardNum");
	}
	
	//noticeList
	@Override
	public List<BoardDTO> boardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"boardList",pager);
	}
	
	@Override
	public long boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount",pager);
	}

	@Override
	public BoardDTO boardSelect(long num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardSelect", num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"boardWrite",boardDTO);
	}

	@Override
	public int boardDelete(long num) throws Exception {		
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"boardUpdate", boardDTO);
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		return sqlSession.update(NAMESPACE+"hitUpdate", num);
	}
	
	
	
	
	
	
}
