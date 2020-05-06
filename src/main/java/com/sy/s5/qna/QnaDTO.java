package com.sy.s5.qna;

import java.util.List;

import com.sy.s5.board.BoardDTO;
import com.sy.s5.board.file.BoardFileDTO;

public class QnaDTO extends BoardDTO {
	private long ref;
	private long step;
	private long depth;
	private List<BoardFileDTO> boardFileDTOs;
	
	public long getRef() {
		return ref;
	}
	public void setRef(long ref) {
		this.ref = ref;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}
	public long getDepth() {
		return depth;
	}
	public void setDepth(long depth) {
		this.depth = depth;
	}
	
	public List<BoardFileDTO> getBoardFileDTOs() {	
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	
}
