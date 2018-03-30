package com.newlecture.jspweb.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.Member;

public class JdbcMemberDao {
	public List<Member> getList() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM Member";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url,"c##sist","dclass");
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
		
		
		List<Member> list = new ArrayList<>();
		
		while(rs.next()){ 
	
		Member member = new Member(
				rs.getString("id"),
				rs.getString("pwd"),
				rs.getString("name"),
				rs.getString("gender"),
				rs.getInt("age"),
				rs.getString("birthday"),
				rs.getString("major"),
				rs.getString("address"),
				rs.getString("phone"),
				rs.getString("ssn"),
				rs.getString("ip"),
				rs.getString("boss"),
				rs.getDate("regdate")
				);
		list.add(member);
		}

		rs.close();
		st.close();
		con.close();
	
	
		return list;
	}
}
