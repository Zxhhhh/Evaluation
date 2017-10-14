package com.why.Evaluation.vo;

public class Exam_VO4QuestionAddParam {
	
	private String questionType; //试题类型
    private String questionTitle; //试题提干
    private String questionLevel; //试题难度
    private Double questionSocre; //试题分值
    private String optionA; //A选项(仅单选，多选有)
    private String optionB;	//B选项(仅单选，多选有)
    private String optionC;	//C选项(仅单选，多选有)
    private String optionD; //D选项(仅单选，多选有)
    private String answerTrue; //正确答案
    private String questionAnalysis; //题目分析
    private String createTime; //题目创建时间
    private Integer catalogId; //科目id
	
    public Exam_VO4QuestionAddParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam_VO4QuestionAddParam(String questionType, String questionTitle,
			String questionLevel, Double questionSocre, String optionA,
			String optionB, String optionC, String optionD, String answerTrue,
			String questionAnalysis, String createTime, Integer catalogId) {
		super();
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.questionLevel = questionLevel;
		this.questionSocre = questionSocre;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answerTrue = answerTrue;
		this.questionAnalysis = questionAnalysis;
		this.createTime = createTime;
		this.catalogId = catalogId;
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

	public Double getQuestionSocre() {
		return questionSocre;
	}

	public void setQuestionSocre(Double questionSocre) {
		this.questionSocre = questionSocre;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswerTrue() {
		return answerTrue;
	}

	public void setAnswerTrue(String answerTrue) {
		this.answerTrue = answerTrue;
	}

	public String getQuestionAnalysis() {
		return questionAnalysis;
	}

	public void setQuestionAnalysis(String questionAnalysis) {
		this.questionAnalysis = questionAnalysis;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public String toString() {
		return "Exam_VO4QuestionAddParam [questionType=" + questionType
				+ ", questionTitle=" + questionTitle + ", questionLevel="
				+ questionLevel + ", questionSocre=" + questionSocre
				+ ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD
				+ ", answerTrue=" + answerTrue + ", questionAnalysis="
				+ questionAnalysis + ", createTime=" + createTime
				+ ", catalogId=" + catalogId + "]";
	}
	
}
