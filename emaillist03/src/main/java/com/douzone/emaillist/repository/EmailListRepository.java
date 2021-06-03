package com.douzone.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.emaillist.vo.EmailListVo;

@Repository
public class EmailListRepository {

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.80.105:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url,"webdb","webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		
		return conn;
	}
	
	public Boolean insert(EmailListVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {
			conn = getConnection();
			
			String sql = "insert into email_list01 values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(pstmt != null) { pstmt.close();}
				if(conn != null) { conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<EmailListVo> findAll() {
		List<EmailListVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select id, first_name, last_name, email"
					+ "		from email_list01"
					+ "		order by id desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmailListVo vo = new EmailListVo();
				vo.setId(rs.getLong(1));
				vo.setFirstName(rs.getString(2));
				vo.setLastName(rs.getString(3));
				vo.setEmail(rs.getString(4));
				result.add(vo);
			}
		
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(pstmt != null) { pstmt.close();}
				if(conn != null) { conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; 
	}
	
	public void delete () {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete from email_list01";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(pstmt != null) { pstmt.close();}
				if(conn != null) { conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	public void updateOrder(OrderVo vo){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = getConnection();
//			
//			String sql = "update bookmall.order"
//					   + "	set total_price = ?"
//					   + "	where id = ?"
//					   + "	and order_num = ?";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setInt(1, vo.getTotalPrice());
//			pstmt.setLong(2, vo.getId());
//			pstmt.setInt(3, vo.getOrderNum());
//			
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("error : " + e);
//		} finally {
//			try {
//				// 자원정리(clean-up)
//				if(pstmt != null) { pstmt.close();}
//				if(conn != null) { conn.close();}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
