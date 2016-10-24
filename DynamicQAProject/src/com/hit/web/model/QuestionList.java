package com.hit.web.model;

import com.opensymphony.xwork2.ActionSupport;

public class QuestionList extends ActionSupport {
	private int authorid;
	private String questionlist;

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getQuestionlist() {
		return questionlist;
	}

	public void setQuestionlist(String questionlist) {
		this.questionlist = questionlist;
	}

}
