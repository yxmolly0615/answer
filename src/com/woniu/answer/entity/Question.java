package com.woniu.answer.entity;

import java.util.Date;

public class Question {
	private int questionid;
	private String title;
	private String content;
	private Date createdate;
	private String status;
	private String answercount;
	private int userid;
	private int cateid;
	private String catename;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAnswercount() {
		return answercount;
	}
	public void setAnswercount(String answercount) {
		this.answercount = answercount;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	
}
