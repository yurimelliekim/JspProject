package com.newlecture.jspweb.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public interface NoticeDao {
	
	List<NoticeView> getList();
	/*List<Notice> getList(String query);
	List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query);*/
	
	NoticeView get(String id);
	NoticeView getPrev(String id);
	NoticeView getNext(String id);
	
	int insert(Notice notice);
	int update(Notice notice); //좋아요
	int delete(Notice notice);
}
