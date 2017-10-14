package com.why.Evaluation.vo;

import java.io.Serializable;

/**
 * Created by Lhy on 2017/6/16 0016.
 */
public class VO4QuestionUpdateParam {



    private Integer questionId;
    private String questionType;
    private Integer category;
    private String questionTitle;
    private Double questionSocre;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answerTrue;
    private String questionAnalysis;
    private String createTime;
    private Integer catalogId;
    private String questionLevel;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getQuestionAnalysis() {
        return questionAnalysis;
    }

    public void setQuestionAnalysis(String questionAnalysis) {
        this.questionAnalysis = questionAnalysis;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public Double getQuestionSocre() {
        return questionSocre;
    }

    public void setQuestionSocre(Double questionSocre) {
        this.questionSocre = questionSocre;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(String answerTrue) {
        this.answerTrue = answerTrue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", questionType=").append(questionType);
        sb.append(", category=").append(category);
        sb.append(", questionTitle=").append(questionTitle);
        sb.append(", questionSocre=").append(questionSocre);
        sb.append(", optionA=").append(optionA);
        sb.append(", optionB=").append(optionB);
        sb.append(", optionC=").append(optionC);
        sb.append(", optionD=").append(optionD);
        sb.append(", answerTrue=").append(answerTrue);
        sb.append(", questionAnalysis=").append(questionAnalysis);
        sb.append(", createTime=").append(createTime);
        sb.append(", catalogId=").append(catalogId);
        sb.append(", questionLevel=").append(questionLevel);

        sb.append("]");
        return sb.toString();
    }

    }
