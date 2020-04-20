package com.sy.s5.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.board.BoardService;
import com.sy.s5.board.pager.Pager;


@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	
	//총 글의 갯수 
	@Override
	public List<BoardDTO> boardList(Pager pager) throws Exception {
	
		long totalCount = qnaDAO.boardCount(pager);
		long totalPage = totalCount/10;
		
		if(totalCount%10 != 0) {
			totalPage++;
		}
		return qnaDAO.boardList(pager);
	}

	//글 상세 페이지
	@Override
	public BoardDTO boardSelect(long num) throws Exception {
		qnaDAO.hitUpdate(num);
		return qnaDAO.boardSelect(num);
	}

	//글 작성
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.boardWrite(boardDTO);
	}

	
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}

	
	
}
