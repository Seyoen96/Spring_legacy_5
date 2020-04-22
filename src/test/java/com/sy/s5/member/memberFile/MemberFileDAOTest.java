package com.sy.s5.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s5.AbstractTestCase;

public class MemberFileDAOTest extends AbstractTestCase{
	
	@Autowired
	private MemberFileDAO memberFileDAO;

	@Test
	public void memberFileTest() throws Exception {
		String id ="zz";
		memberFileDAO.fileDelete(id);
		
		
	}
	
	
	public void fileInsert() {
		String id ="zz";
		String fileName="hello";
		String oriName="today";
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(id);
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(oriName);
		System.out.println(memberFileDTO.getId());
		
	}
	

}
