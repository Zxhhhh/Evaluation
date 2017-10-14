package com.why.Evaluation.vo;

import com.why.Evaluation.dto.Exam;

/**
 * 考试统计
 * @author K550J
 *
 */
public class Exam_VO4ExamStatisticsRtn {
	
	private Integer exam_id;//考试id
	private Integer examCount; //考试次数
	private Integer examStudentCount; //考试人数(重复不记)
	private Integer examPassCount; //考试合格次数
	private Integer examNoPassCount;//考试不合格次数
	private Double examPassRate; //考试合格率
	private Double examNoPassRate; //考试不合格率
	private Double highestScore; //考试最高分
	private Double lowestScore; // 考试最低分
	private Double avarageScore; //考试平均分
	private Integer fastestFinishTime; //最快完成考试的时间(分钟)
	private Integer slowestFinishTime; //最慢完成考试的时间(分钟)
	private Integer avarageFinishTime; //平均完成考试的时间(分钟)
	private Double highestScoreScale; //最高分占总分的比例
	private Double lowestScoreScale;  //最低分占总分的比例
	private Double avarageScoreScale; //平均分占总分的比例
	private Double fastestFinishTimeScale; //最快完成时间占总时间的比例
	private Double slowestFinishTimeScale; //最慢完成时间占总时间的比例
	private Double avarageFinishTimeScale; //平均完成时间占总时间的比例
	
	private Integer highestScoreRank;//最高分排名
	private Integer avarageScoreRank;//平均分排名
	private Integer examTimeRank;//考试次数排名
	private Integer passScaleRank;//合格率排名
	private Integer fastestFinishRank;//最快完成时间排名
	private Integer avarageFinishRank;//平均完成时间排名
	
	
	private Exam examInformation; //考试的信息

	public Exam_VO4ExamStatisticsRtn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam_VO4ExamStatisticsRtn(Integer exam_id, Integer examCount,
			Integer examPassCount, Integer examNoPassCount,
			Double examPassRate, Double examNoPassRate, Double highestScore,
			Double lowestScore, Double avarageScore, Integer fastestFinishTime,
			Integer slowestFinishTime, Integer avarageFinishTime,
			Exam examInformation) {
		super();
		this.exam_id = exam_id;
		this.examCount = examCount;
		this.examPassCount = examPassCount;
		this.examNoPassCount = examNoPassCount;
		this.examPassRate = examPassRate;
		this.examNoPassRate = examNoPassRate;
		this.highestScore = highestScore;
		this.lowestScore = lowestScore;
		this.avarageScore = avarageScore;
		this.fastestFinishTime = fastestFinishTime;
		this.slowestFinishTime = slowestFinishTime;
		this.avarageFinishTime = avarageFinishTime;
		this.examInformation = examInformation;
	}

	public Integer getExam_id() {
		return exam_id;
	}

	public void setExam_id(Integer exam_id) {
		this.exam_id = exam_id;
	}

	public Integer getExamCount() {
		return examCount;
	}

	public void setExamCount(Integer examCount) {
		this.examCount = examCount;
	}

	public Integer getExamPassCount() {
		return examPassCount;
	}

	public void setExamPassCount(Integer examPassCount) {
		this.examPassCount = examPassCount;
	}

	public Integer getExamNoPassCount() {
		return examNoPassCount;
	}

	public void setExamNoPassCount(Integer examNoPassCount) {
		this.examNoPassCount = examNoPassCount;
	}

	public Double getExamPassRate() {
		return examPassRate;
	}

	public void setExamPassRate(Double examPassRate) {
		this.examPassRate = examPassRate;
	}

	public Double getExamNoPassRate() {
		return examNoPassRate;
	}

	public void setExamNoPassRate(Double examNoPassRate) {
		this.examNoPassRate = examNoPassRate;
	}

	public Double getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(Double highestScore) {
		this.highestScore = highestScore;
	}

	public Double getLowestScore() {
		return lowestScore;
	}

	public void setLowestScore(Double lowestScore) {
		this.lowestScore = lowestScore;
	}

	public Double getAvarageScore() {
		return avarageScore;
	}

	public void setAvarageScore(Double avarageScore) {
		this.avarageScore = avarageScore;
	}

	public Integer getFastestFinishTime() {
		return fastestFinishTime;
	}

	public void setFastestFinishTime(Integer fastestFinishTime) {
		this.fastestFinishTime = fastestFinishTime;
	}

	public Integer getAvarageFinishTime() {
		return avarageFinishTime;
	}

	public void setAvarageFinishTime(Integer avarageFinishTime) {
		this.avarageFinishTime = avarageFinishTime;
	}

	public Exam getExamInformation() {
		return examInformation;
	}

	public void setExamInformation(Exam examInformation) {
		this.examInformation = examInformation;
	}

	public Integer getSlowestFinishTime() {
		return slowestFinishTime;
	}

	public void setSlowestFinishTime(Integer slowestFinishTime) {
		this.slowestFinishTime = slowestFinishTime;
	}

	public Double getHighestScoreScale() {
		return highestScoreScale;
	}

	public void setHighestScoreScale(Double highestScoreScale) {
		this.highestScoreScale = highestScoreScale;
	}

	public Double getLowestScoreScale() {
		return lowestScoreScale;
	}

	public void setLowestScoreScale(Double lowestScoreScale) {
		this.lowestScoreScale = lowestScoreScale;
	}

	public Double getAvarageScoreScale() {
		return avarageScoreScale;
	}

	public void setAvarageScoreScale(Double avarageScoreScale) {
		this.avarageScoreScale = avarageScoreScale;
	}

	public Double getFastestFinishTimeScale() {
		return fastestFinishTimeScale;
	}

	public void setFastestFinishTimeScale(Double fastestFinishTimeScale) {
		this.fastestFinishTimeScale = fastestFinishTimeScale;
	}

	public Double getSlowestFinishTimeScale() {
		return slowestFinishTimeScale;
	}

	public void setSlowestFinishTimeScale(Double slowestFinishTimeScale) {
		this.slowestFinishTimeScale = slowestFinishTimeScale;
	}

	public Double getAvarageFinishTimeScale() {
		return avarageFinishTimeScale;
	}

	public void setAvarageFinishTimeScale(Double avarageFinishTimeScale) {
		this.avarageFinishTimeScale = avarageFinishTimeScale;
	}

	public Integer getExamStudentCount() {
		return examStudentCount;
	}

	public void setExamStudentCount(Integer examStudentCount) {
		this.examStudentCount = examStudentCount;
	}

	public Integer getHighestScoreRank() {
		return highestScoreRank;
	}

	public void setHighestScoreRank(Integer highestScoreRank) {
		this.highestScoreRank = highestScoreRank;
	}

	public Integer getAvarageScoreRank() {
		return avarageScoreRank;
	}

	public void setAvarageScoreRank(Integer avarageScoreRank) {
		this.avarageScoreRank = avarageScoreRank;
	}

	public Integer getExamTimeRank() {
		return examTimeRank;
	}

	public void setExamTimeRank(Integer examTimeRank) {
		this.examTimeRank = examTimeRank;
	}

	public Integer getPassScaleRank() {
		return passScaleRank;
	}

	public void setPassScaleRank(Integer passScaleRank) {
		this.passScaleRank = passScaleRank;
	}

	public Integer getFastestFinishRank() {
		return fastestFinishRank;
	}

	public void setFastestFinishRank(Integer fastestFinishRank) {
		this.fastestFinishRank = fastestFinishRank;
	}

	public Integer getAvarageFinishRank() {
		return avarageFinishRank;
	}

	public void setAvarageFinishRank(Integer avarageFinishRank) {
		this.avarageFinishRank = avarageFinishRank;
	}
	
	

}
