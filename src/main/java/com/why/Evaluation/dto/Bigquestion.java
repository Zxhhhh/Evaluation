package com.why.Evaluation.dto;

public class Bigquestion {
    private Integer bigquestionId;

    private Integer paperId;

    private Integer bigquestionN;

    private String questionIds;

    private Double bigquestionScore;

    public Integer getBigquestionId() {
        return bigquestionId;
    }

    public void setBigquestionId(Integer bigquestionId) {
        this.bigquestionId = bigquestionId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getBigquestionN() {
        return bigquestionN;
    }

    public void setBigquestionN(Integer bigquestionN) {
        this.bigquestionN = bigquestionN;
    }

    public String getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds == null ? null : questionIds.trim();
    }

    public Double getBigquestionScore() {
        return bigquestionScore;
    }

    public void setBigquestionScore(Double bigquestionScore) {
        this.bigquestionScore = bigquestionScore;
    }
}