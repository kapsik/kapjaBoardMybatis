package com.kapjaBrothers.springBoard.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kapjaBrothers.springBoard.entity.replyData;

public class replyServiceImpl implements replyService{

	@Override
	public int replyWrite(replyData rData) {
		System.out.println("replyServiceImpl -> replyWrite");
		
		int bno = rData.getBno();
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = "INSERT INTO KAPJA_REPLY (BNO ,RNO ,CONTENT ,WRITER ,REGDATE)"
				+ "VALUES (?, RSEQ.NEXTVAL, ?, ?, SYSDATE)";
		String user = "KAPJA";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rData.getBno());
			ps.setString(2, rData.getContent());
			ps.setString(3, rData.getWriter());
			int rs = ps.executeUpdate();
			
			ps.close();
			conn.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bno;
	}

	@Override
	public void replyEdit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyDelete() {
		// TODO Auto-generated method stub
		
	}

}
