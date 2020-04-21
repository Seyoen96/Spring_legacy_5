package com.sy.s5.util;

public class Pager {
	
	private Long curPage;
	private Integer perPage;
	
	private long startRow;
	private long lastRow;
	private long totalPage;
	private long totalBlock;
	private long curBlock;
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	public long getStartRow() {
		return startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public long getTotalPage() {
		return totalPage;
	}
	

	public long getTotalBlock() {
		return totalBlock;
	}
	public long getCurBlock() {
		return curBlock;
	}
	public long getStartNum() {
		return startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();	
	}
	
	
	public Long getCurPage() {
		if(this.curPage==null || this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10;
		}
		return perPage;
	}	
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	
	
	public void makePage(long totalCount) {
		//--------------------------------------------------
		//1. 총 글의 갯수 totalCount		
		//2. 총 페이지 갯수
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.perPage!=0) {
			this.totalPage++;
			
			//3. totalPage로 totalBlock 계산	
			long perBlock=5L;	//block Page 수
			this.totalBlock = this.totalPage/perBlock;
			if(totalPage%perBlock!=0) {
				this.totalBlock++;
			}
			
			//4. curPage로 curBlock 찾기
			this.curBlock = this.curPage/perBlock;
			if(this.curPage%perBlock!=0) {
				this.curBlock++;		
			}	
			
			//5. curBlock startNum, lastNum 계산
			this.lastNum = this.curBlock*perBlock;
			this.startNum = (this.curBlock-1)*perBlock+1;
			
			if(this.curBlock == this.totalBlock) {
				this.lastNum = this.totalPage;
			}
		}
		
	}


	
	
}
