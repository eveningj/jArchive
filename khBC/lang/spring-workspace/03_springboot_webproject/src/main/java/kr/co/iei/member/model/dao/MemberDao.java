package kr.co.iei.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.iei.member.model.vo.Member;

@Mapper
public interface MemberDao {

	Member login(Member m);

	int insertMember(Member m);

	Member selectOneMember(String checkId);

	int updateMember(Member m);

	int deleteMember(int memberNo);

	List selectAllMember();

	int changeLevel(Member m);

}
