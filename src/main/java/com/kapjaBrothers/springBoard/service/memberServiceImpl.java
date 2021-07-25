package com.kapjaBrothers.springBoard.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.kapjaBrothers.springBoard.entity.membersData;

public class memberServiceImpl implements memberService{

	@Override
	public int idCheck(String userId) {
		System.out.println("memberServiceImpl(idCheck)");
		System.out.println(userId);
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "KAPJA";
		String password = "1234";
		String sql = "SELECT ID FROM KAPJA_MEMBERS WHERE ID = ?";
		int idCheckResult = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("아이디가 등록되어있습니다.");
				idCheckResult = 1;
			}else {
				System.out.println("아이디가 등록가능합니다.");
				idCheckResult = 0;
			}
			
			
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("idCheckResult = "+idCheckResult);
		return idCheckResult;
	}

	@Override
	public void passwordCheck(String pw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int emailCheck(String email) {
		System.out.println("memberServiceImpl(emailCheck)");
		System.out.println("email = "+email);
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "KAPJA";
		String password = "1234";
		String sql = "SELECT EMAIL FROM KAPJA_MEMBERS WHERE EMAIL = ?";
		int emailCheckResult = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				emailCheckResult = 1;
				System.out.println("이메일이 이미있음");
			}else {
				emailCheckResult = 0;
				System.out.println("이메일 등록가능");
			}
			
			
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return emailCheckResult;
	}

	@Override
	public void memberRegister(membersData mData) {
		System.out.println("memberServiceImpl(memberRegister)");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "KAPJA";
		String password = "1234";
		String sql = "INSERT INTO KAPJA_MEMBERS (ID, EMAIL, PASSWORD) VALUES(?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mData.getId());
			ps.setString(2, mData.getEmail());
			ps.setString(3, mData.getPassword());
			int rs = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void memberDelete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberEdit(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public membersData memberLogin(membersData mData) {
		membersData mData2 = new membersData();
		
		System.out.println("memberServiceImpl(memberLogin)");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "KAPJA";
		String password = "1234";
		String sql = "SELECT ID,PASSWORD FROM KAPJA_MEMBERS WHERE ID = ? AND PASSWORD = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mData.getId());
			ps.setString(2, mData.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("rs.getstring(id)"+rs.getString("ID"));
				System.out.println("rs.getstring(password)"+rs.getString("PASSWORD"));
				
				mData2.setId(rs.getString("ID"));
				mData2.setPassword(rs.getString("PASSWORD"));
				System.out.println(mData2);
			}
			
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mData2;
	}

	@Override
	public void memberLogout(membersData mData) {
		System.out.println("memberServiceImpl(memberLogout)");
		
	}

}
