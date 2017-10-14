package com.why.Evaluation.vo;

public class Exam_VO4QuestionQueryParam {

	private String questionType;
	private String questionTitle;
	private String questionLevel;
	private String createStartTime;
	private String createEndTime;
	
	public Exam_VO4QuestionQueryParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam_VO4QuestionQueryParam(String questionType,
			String questionTitle, String questionLevel, String createStartTime,
			String createEndTime) {
		super();
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.questionLevel = questionLevel;
		this.createStartTime = createStartTime;
		this.createEndTime = createEndTime;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;
	}

	public String getCreateStartTime() {
		return createStartTime;
	}

	public void setCreateStartTime(String createStartTime) {
		this.createStartTime = createStartTime;
	}

	public String getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(String createEndTime) {
		this.createEndTime = createEndTime;
	}
	
}
