package jdbc.member.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import jdbc.common.JDBCTemplate;

import jdbc.member.model.vo.Member;

public class MemberDao {

public Member searchId(Connection conn, String memberId) {

PreparedStatement pstmt = null;

ResultSet rset = null;

Member m = null;

String query = "select * from member_tbl where member_id = ?";

try {

pstmt = conn.prepareStatement(query);

pstmt.setString(0, memberId);

rset = pstmt.executeQuery();

if(rset.next()) {

m = new Member();

m.setMemberId(rset.getString("memberId"));

m.setMemberPw(rset.getString("memberPw"));

m.setMemberName(rset.getString("memberName"));

m.setMemberAge(rset.getInt("memberAge"));

m.setMemberPhone(rset.getString("memberPhone"));

}

} catch (SQLException e) {

e.printStackTrace();

}finally {

JDBCTemplate.close(rset);

JDBCTemplate.close(pstmt);

}

return m;

}

}