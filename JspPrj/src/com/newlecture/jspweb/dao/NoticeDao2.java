package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.Notice;

public class NoticeDao2 {
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException{
		return getList(1,"title","");
	}
	
	public List<Notice> getList(String query) throws ClassNotFoundException, SQLException{
		return getList(1,"title",query);
	}
	
	public List<Notice> getList(int page) throws ClassNotFoundException, SQLException{
		return getList(page,"title","");
	}
	
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url,"c##sist","dclass");
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
		
		String id;
		String title;
		String writerid;
		String content;
		Date regDate;
		int hit;
		
		List<Notice> list = new ArrayList<>();
		
		while(rs.next()){ 
		id = rs.getString("id");
		title = rs.getString("title");
		writerid = rs.getString("writer_id");
		content = rs.getString("content");
		regDate = rs.getDate("reg_date");
		hit = rs.getInt("hit");
		
		Notice notice = new Notice(
				id,
				title,
				writerid,
				content,
				regDate,
				hit
				);
		list.add(notice);
		}

		rs.close();
		st.close();
		con.close();
	
	
		return list;
	}
}
