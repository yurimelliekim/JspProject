package com.newlecture.jspweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.dao.NoticeDao;
import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {
   
   public List<NoticeView> getList(){
      
     /* return getList(1, "title", "");   
   }*/
   
  /* public List<NoticeView> getList(String query) {
      
      return getList(1, "title", query);   
   }
   
   public List<NoticeView> getList(int page) {
   
      return getList(page, "title", "");   
   }
      
   public List<NoticeView> getList(int page, String field, String query) {*/
      
      String sql = "SELECT * FROM NOTICE_VIEW";
      
      // 드라이버 로드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         String id;
         String title;
         String writerId;
         String content;
         Date regDate;
         int hit;
         String writerName;
         String commentCnt;
         
         List<NoticeView> list = new ArrayList<>();
         
         while(rs.next()) { 
            /*id=rs.getString("ID");
            title = rs.getString("TITLE");
            writerId = rs.getString("WRITER_ID");
            content = rs.getString("content");
            regDate = rs.getDate("reg_Date");
            hit = rs.getInt("hit");
            writerName = rs.getString("writer_Name");
            commentCnt = rs.getString("comment_Cnt");*/
            
            NoticeView notice = new NoticeView(
            		/*
            		id,
                    title,
                    writerId,
                    content,
                    regDate,
                    hit,
                    writerName,
                    commentCnt*/
                             rs.getString("id"),
                             rs.getString("title"),
                             rs.getString("writer_id"),
                             rs.getString("content"),
                             rs.getDate("reg_Date"),
                             rs.getInt("hit"),
                             rs.getString("writer_name"),
                             rs.getString("comment_cnt")
                           );
            
           /* notice.setId(rs.getString("id"));
            notice.setTitle(rs.getString("title"));
            notice.setWriterId(rs.getString("writerId"));
            notice.setContent(rs.getString("content"));
            notice.setRegDate(rs.getDate("regDate"));
            notice.setHit(rs.getInt("hit"));
            notice.setWriterName(rs.getString("writerName"));
            notice.setCommentCnt(rs.getString("commentCnt"));*/
            
            
            list.add(notice);
         }
         
         rs.close();
         st.close();
         con.close();
         
         return list;
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
   }

   @Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}
   
   @Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}
   
   @Override
	public int delete(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}
   
   @Override
   public NoticeView get(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public NoticeView getPrev(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public NoticeView getNext(String id) {
      // TODO Auto-generated method stub
      return null;
   }
}