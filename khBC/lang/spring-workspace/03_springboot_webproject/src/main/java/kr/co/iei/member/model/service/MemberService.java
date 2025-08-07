package kr.co.iei.member.model.service;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.member.model.dao.MemberDao;
import kr.co.iei.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public Member login(Member m) {
		Member member = memberDao.login(m);
		return member;
	}
	
	@Transactional
	public int insertMember(Member m) {
		int result = memberDao.insertMember(m);
		return result;
	}

	public Member selectOneMember(String checkId) {
		Member member = memberDao.selectOneMember(checkId);
		return member;
	}
	
	@Transactional
	public int updateMember(Member m) {
		int result = memberDao.updateMember(m);
		return result;
	}
	
	@Transactional
	public int deleteMember(int memberNo) {
		int result = memberDao.deleteMember(memberNo);
		return result;
	}

	public List selectAllMember() {
		List list = memberDao.selectAllMember();
		return list;
	}

	@Transactional
	public int changeLevel(Member m) {
		int result = memberDao.changeLevel(m);
		return result;
	}
	
	@Transactional
	public boolean checkedChangeLevel(String no, String level) {
		StringTokenizer sT1 = new StringTokenizer(no, "/");
		StringTokenizer sT2 = new StringTokenizer(level, "/");
		int result = 0;
		int count = sT1.countTokens();
		while(sT1.hasMoreTokens()) {
			String stringNo = sT1.nextToken();
			int memberNo = Integer.parseInt(stringNo);
			String stringLevel = sT2.nextToken();
			int userLevel = Integer.parseInt(stringLevel);
			
			Member m = new Member();
			m.setMemberNo(memberNo);
			m.setUserLevel(userLevel);
			result += memberDao.changeLevel(m);
		}
		return result == count;
	}
	
}
