package com.hit.web.model;

import com.opensymphony.xwork2.ActionSupport;

public class EssayQuestion extends ActionSupport {
	private String question;
	private int questionid;
	private int authorid;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
}
