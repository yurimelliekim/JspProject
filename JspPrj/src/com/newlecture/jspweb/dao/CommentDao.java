package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.Comment;

public class CommentDao {
	public List<Comment> getList() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM Comment";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url,"c##sist","dclass");
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
		
		
	    List<Comment> list = new ArrayList<>();
		
		while(rs.next()){ 	
		
		Comment comment = new Comment(
				rs.getString("id"),
				rs.getString("content"),
				rs.getDate("regDate"),
				rs.getString("noticeid")
				);
		list.add(comment);
		}

		rs.close();
		st.close();
		con.close();
	
		return list;
	}
}
