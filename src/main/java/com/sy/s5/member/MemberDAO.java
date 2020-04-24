package com.sy.s5.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.s5.util.Pager;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.sy.s5.member.MemberDAO.";
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);	
	}
	
	public MemberDTO memberIdCheck(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"memberUpdate", memberDTO);	
	}
	
	public int memberDelete(String id) throws Exception{
		return sqlSession.delete(NAMESPACE+"memberDelete", id);	
	}
	
	public List<MemberDTO> memberList(Pager memberPager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList", memberPager);
	}
	
	public long memberCount(Pager memberPager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberCount", memberPager);
	}
	

}
