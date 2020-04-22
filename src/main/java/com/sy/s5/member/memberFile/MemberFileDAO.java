package com.sy.s5.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.sy.s5.member.memberFile.MemberFileDAO.";
	
	
	//fileInsert
	public int fileInsert(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", memberFileDTO);		
	}
	//fileUpdate
	public int fileUpdate(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"fileUpdate", memberFileDTO);
	}
	//fileDelete
	public int fileDelete(String id) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", id);
	}
	//fileSelect
	public MemberFileDTO fileSelect(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect", id);
	}
	
}
