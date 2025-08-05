package kr.co.iei.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.iei.member.model.vo.Member;

//Mybatis 에게 이 인터페이스를 구현하라고 알려줌
@Mapper
public interface MemberDao {

	List selectAllMember();

	int insertMember(Member m);

	Member searchId(String memberId);

}
