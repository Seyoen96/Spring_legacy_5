package com.sy.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.s5.board.BoardDAO;
import com.sy.s5.board.BoardDTO;
import com.sy.s5.board.BoardService;


@Service
public class QnaService implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	
	//총 글의 갯수 
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		
		
		
		return null;
	}

	//글 상세 페이지
	@Override
	public BoardDTO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//글 작성
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
