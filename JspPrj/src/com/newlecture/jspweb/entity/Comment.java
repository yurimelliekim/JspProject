package com.newlecture.jspweb.entity;

import java.sql.Date;

public class Comment {
	private String id;
	private String content;
	private Date regdate;
	private String noticeid;
	
	public Comment() {
		
	}

	public Comment(String id, String content, Date regdate, String noticeid) {
		super();
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.noticeid = noticeid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}
	

}
