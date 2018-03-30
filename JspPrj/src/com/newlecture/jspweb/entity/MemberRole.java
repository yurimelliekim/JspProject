package com.newlecture.jspweb.entity;

public class MemberRole {
	
	private String memberid;
	private String roleid;
	
	public MemberRole() {
		
	}

	public MemberRole(String memberid, String roleid) {
		super();
		this.memberid = memberid;
		this.roleid = roleid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	

}
