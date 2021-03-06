package com.sy.s5.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.s5.board.BoardDAO;
import com.sy.s5.board.BoardDTO;
import com.sy.s5.util.Pager;


@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sy.s5.qna.QnaDAO.";
	
	
	
	
	
	public int boardReplyUpdate(BoardDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"boardReplyUpdate", boardDTO);
	}
	
	public int boardReply(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"boardReply", boardDTO);
	}

	@Override
	public long boardCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"boardCount",pager);
	}

	@Override
	public List<BoardDTO> boardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"boardList",pager);
	}

	@Override
	public BoardDTO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"boardSelect",num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"boardWrite",boardDTO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"boardUpdate", boardDTO);
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"hitUpdate", num);
	}
	
	
	
}
