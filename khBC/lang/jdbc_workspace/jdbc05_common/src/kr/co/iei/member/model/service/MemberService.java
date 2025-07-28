package kr.co.iei.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.iei.common.JDBCTemplate;
import kr.co.iei.member.model.dao.MemberDao;
import kr.co.iei.member.model.vo.Member;

public class MemberService {
	MemberDao memberDao;

	public MemberService() {
		super();
		memberDao = new MemberDao();
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = memberDao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Member selectMemberId(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = memberDao.selectMemberId(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> selectMemberName(String memberName) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = memberDao.selectMemberName(conn, memberName);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = memberDao.insertMember(conn, m);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
			;
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMember(String searchId, String memberPw, String memberPhone) {
		Connection conn = JDBCTemplate.getConnection();
		int result = memberDao.updateMember(conn, memberPw, memberPhone, searchId);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
			;
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(String searchId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = memberDao.selectMemberId(conn, searchId);
		int result = -1;
		if (m != null) {
			result = memberDao.deleteMember(conn, m);
			if (result > 0) {
				result += memberDao.insertDelMember(conn, m);
				if (result > 1) {
					JDBCTemplate.commit(conn);
				}
			} else {
				JDBCTemplate.rollback(conn);
			}
		}//if();
		JDBCTemplate.close(conn);
		return result;
	}

}
