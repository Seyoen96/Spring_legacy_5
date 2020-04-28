package com.sy.s5.notice;


import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BoardFileDAO boardFileDAO;
	

	@Override
	public List<BoardDTO> boardList(Pager pager) throws Exception {	
		pager.makeRow();
		long totalCount = noticeDAO.boardCount(pager);
		pager.makePage(totalCount);		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardDTO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}
	

	@Override
	public int boardWrite(BoardDTO boardDTO,MultipartFile[] files) throws Exception {
		String path = servletContext.getRealPath("/resources/uploadnotice"); 
		System.out.println(path);
		//sequence 번호 받기
		boardDTO.setNum(noticeDAO.boardNum());		
		//notice table insert
		int res = noticeDAO.boardWrite(boardDTO);
		
		for(MultipartFile file:files) {
			if(file.getSize()>0) {
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				String fileName = fileSaver.saveByTransfer(file,path);			
				boardFileDTO.setNum(boardDTO.getNum());
				boardFileDTO.setBoard("1");
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(file.getOriginalFilename());
				boardFileDAO.fileInsert(boardFileDTO);	
			}	
		}
		return res;
	}
	

	@Override
	public int boardUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		//HDD file save
		String path = servletContext.getRealPath("/resources/uploadnotice"); 
		System.out.println(path);
		int res = noticeDAO.boardUpdate(boardDTO);
		for(MultipartFile file : files) {
			if(file.getSize()>0) {
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				String fileName = fileSaver.saveByTransfer(file, path);
				boardFileDTO.setNum(boardDTO.getNum());
				boardFileDTO.setBoard("1");
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(file.getOriginalFilename());
				res = boardFileDAO.fileInsert(boardFileDTO);
			}					
		}
		return res;
	}
	

	@Override
	public int boardDelete(long num) throws Exception {
			
		List<BoardFileDTO> list = boardFileDAO.fileList(num);
		//1. HDD에서 해당 파일들을 삭제
		String path = servletContext.getRealPath("/resources/uploadnotice");
		for(BoardFileDTO fileDTO: list) {
			fileSaver.deleteFile(fileDTO.getFileName(), path);
		}
		//2.DB에서 삭제
		boardFileDAO.fileDeleteAll(num);
		
		return noticeDAO.boardDelete(num);
	}
	
	
	
	
	
	
	

}
