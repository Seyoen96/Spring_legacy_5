package com.sy.s5.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.board.BoardService;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	

	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		int startRow = (curPage-1)*10+1;
		int lastRow = curPage*10;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		//--------------------------------------------------
		//1. 총 글의 갯수
		long totalCount = noticeDAO.boardCount();
		System.out.println("Total Count : "+totalCount);
		
		//2. 총 페이지 갯수
		long totalPage = totalCount/10;
		if(totalCount%10!=0) {
			totalPage++;
		}
		
		return noticeDAO.boardList(map);
	}

	@Override
	public BoardDTO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return noticeDAO.boardDelete(num);
	}

}
