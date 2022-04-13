package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MySQLDB {

public void insert(String mId, String mPW) {
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/swingDB?useSSL=false";
		String dbId = "root";
		String dbPw = "rootroot";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "insert into memberTBL(mId, mPW) values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPW);
			pstmt.executeUpdate();
			System.out.println("MemberDTO insert() 메서드 실행 완료!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	
	
public boolean loginSelect(String mId, String mPW) {
	
	Connection conn = null; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String dbUrl = "jdbc:mysql://localhost:3306/swingDB?useSSL=false";
	String dbId = "root";
	String dbPw = "rootroot";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
		String sql = "SELECT * from memberTBL WHERE mId = ? and mPW = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mId);
		pstmt.setString(2, mPW);
		pstmt.executeQuery();
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			System.out.println("로그인 완료.");
			return true;
		} else {
			System.out.println("일치하는 아이디나 비밀번호가 없습니다.");
			return false;
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return false;
}
	

public boolean idCheck (String mId) {
	Connection conn = null; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String dbUrl = "jdbc:mysql://localhost:3306/swingDB?useSSL=false";
	String dbId = "root";
	String dbPw = "rootroot";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
		String sql = "SELECT mId from memberTBL WHERE mId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mId);
		pstmt.executeQuery();
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			System.out.println("MemberDTO selectOne() 메서드 실행 완료!");
			return true;
		}else {
			System.out.println("MemberDTO selectOne() 메서드 실행 완료!");
			return false;
		}
		
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return false;
}
	
}
