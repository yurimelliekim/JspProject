package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.MemberRole;

public class MemberRoleDao {
	public List<MemberRole> getList() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM Member_Role";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url,"c##sist","dclass");
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
		
		
		List<MemberRole> list = new ArrayList<>();
		
		while(rs.next()){ 
		
		
			MemberRole memberrole = new MemberRole(
				rs.getString("memberid"),
				rs.getString("roleid")
				);
		list.add(memberrole);
		}

		rs.close();
		st.close();
		con.close();
	
	
		return list;
	}
}
