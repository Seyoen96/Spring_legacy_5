package com.sy.s5.member.memberPager;

public class MemberPager {
	private Long curPage;
	private Integer perPage;
	
	private long startRow;
	private long lastRow;
	private long totalPage;
	
	private long startNum;
	private long lastNum;
	private long totalBlock;
	private long curBlock;
	
	private String kind;
	private String search;
	
	
	public String getKind() {
		return kind;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setSearch(String search) {
		this.search = search;
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
	public long getStartNum() {
		return startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public long getTotalBlock() {
		return totalBlock;
	}
	public long getCurBlock() {
		return curBlock;
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
			this.perPage=5;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPerPage()*this.getCurPage();
	}
	
	public void makePage(long totalCount) {
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.perPage!=0) {
			this.totalPage++;
			long perBlock=5L;
			this.totalBlock = this.totalPage/perBlock;
			if(totalPage%perBlock!=0) {
				this.totalBlock++;
			}
			this.curBlock= this.curPage/perBlock;
			if(this.curPage%perBlock!=0) {
				this.curBlock++;
			}
			this.startNum = (this.curBlock-1)*perBlock+1;
			this.lastNum = this.curBlock*perBlock;
			if(this.curBlock==this.totalBlock) {
				this.lastNum = this.totalPage;
				
			}
			
		}
		
				
	}
	
	
	
	
	
}
