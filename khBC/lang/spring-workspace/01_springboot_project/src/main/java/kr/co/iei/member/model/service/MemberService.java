package kr.co.iei.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.iei.member.model.dao.MemberDao;
import kr.co.iei.member.model.vo.Member;

//spring 에게 객체 생성하라고 알려주는 어노테이션
@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public List selectAllMember() {
		List list = memberDao.selectAllMember();
		return list;
	}

}
