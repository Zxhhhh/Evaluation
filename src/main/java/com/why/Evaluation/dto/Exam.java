package com.why.Evaluation.dto;

public class Exam {
    private Integer examId;

    private String examName;

    private Integer paparId;

    private String examStartTime;

    private String examEndTime;

    private Integer examDuration;

    private Double examScore;

    private Double examPassScore;

    private String examPassword;

    private String examType;

    private String examQcodeUrl;

    private String examUrl;

    private String examStatus;

    private String examCompleted;

    private String checkAns;

    private String examPassTips;

    private String examNopassTips;

    private String createTime;

    private Integer adminId;

    private String examNotice;

    private Integer proId;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    public Integer getPaparId() {
        return paparId;
    }

    public void setPaparId(Integer paparId) {
        this.paparId = paparId;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime == null ? null : examStartTime.trim();
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime == null ? null : examEndTime.trim();
    }

    public Integer getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(Integer examDuration) {
        this.examDuration = examDuration;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Double getExamPassScore() {
        return examPassScore;
    }

    public void setExamPassScore(Double examPassScore) {
        this.examPassScore = examPassScore;
    }

    public String getExamPassword() {
        return examPassword;
    }

    public void setExamPassword(String examPassword) {
        this.examPassword = examPassword == null ? null : examPassword.trim();
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    public String getExamQcodeUrl() {
        return examQcodeUrl;
    }

    public void setExamQcodeUrl(String examQcodeUrl) {
        this.examQcodeUrl = examQcodeUrl == null ? null : examQcodeUrl.trim();
    }

    public String getExamUrl() {
        return examUrl;
    }

    public void setExamUrl(String examUrl) {
        this.examUrl = examUrl == null ? null : examUrl.trim();
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus == null ? null : examStatus.trim();
    }

    public String getExamCompleted() {
        return examCompleted;
    }

    public void setExamCompleted(String examCompleted) {
        this.examCompleted = examCompleted == null ? null : examCompleted.trim();
    }

    public String getCheckAns() {
        return checkAns;
    }

    public void setCheckAns(String checkAns) {
        this.checkAns = checkAns == null ? null : checkAns.trim();
    }

    public String getExamPassTips() {
        return examPassTips;
    }

    public void setExamPassTips(String examPassTips) {
        this.examPassTips = examPassTips == null ? null : examPassTips.trim();
    }

    public String getExamNopassTips() {
        return examNopassTips;
    }

    public void setExamNopassTips(String examNopassTips) {
        this.examNopassTips = examNopassTips == null ? null : examNopassTips.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getExamNotice() {
        return examNotice;
    }

    public void setExamNotice(String examNotice) {
        this.examNotice = examNotice == null ? null : examNotice.trim();
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}