package com.newlecture.jspprj.entity;

import java.util.Date;

public class AnswerisView extends Answeris {
	
	private int commentCount;
	
	public AnswerisView() {
		
	}
	

	public AnswerisView(
			String id, 
			String language, 
			String platform, 
			String runtime, 
			String title, 
			String errorCode,
			String errorMessage, 
			String situation, 
			String triedToFix, 
			String reason, 
			String writerId, 
			String howToFix,
			Date regDate, 
			int hit, 
			String attachedFile,
			int commentCount) {
		super(id, language, platform, runtime, title, errorCode, errorMessage, situation, triedToFix, reason, writerId,
				howToFix, regDate, hit, attachedFile);
		
		this.commentCount = commentCount;
	}


	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
