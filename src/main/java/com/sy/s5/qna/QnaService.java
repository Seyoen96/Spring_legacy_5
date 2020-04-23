package com.sy.s5.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.board.BoardService;
import com.sy.s5.board.file.BoardFileDAO;
import com.sy.s5.board.file.BoardFileDTO;
import com.sy.s5.util.FileSaver;
import com.sy.s5.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BoardFileDAO boardFileDAO;
	

	
	public int boardReply(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.boardReplyUpdate(boardDTO);
		result = qnaDAO.boardReply(boardDTO);
		return result;
	}
	
	
	//총 글의 갯수 
	@Override
	public List<BoardDTO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		long totalCount = qnaDAO.boardCount(pager);
		pager.makePage(totalCount);
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
	public int boardWrite(BoardDTO boardDTO, MultipartFile[] files) throws Exception {		
		//1. sequnce num  qna table insert
		int res = qnaDAO.boardWrite(boardDTO);
						
		//3. HDD에 파일저장하고 boardFile table insert
		String path = servletContext.getRealPath("/resources/uploadQna");
				
		for(MultipartFile file: files) {
			BoardFileDTO boardFileVO = new BoardFileDTO();
			String fileName = fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardDTO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard("2");
			boardFileDAO.fileInsert(boardFileVO);
		}
				
		
		return res;
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
