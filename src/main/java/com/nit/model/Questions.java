package com.nit.model;

public class Questions {

	private int questionId;
	private String questionName;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;
	private String createdBy;
	private String createdDate;

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOption4() {
		return option4;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}
}
