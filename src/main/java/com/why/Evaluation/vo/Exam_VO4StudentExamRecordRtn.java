package com.why.Evaluation.vo;

import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.User;

/**
 * 学生考试记录
 * @author K550J
 *
 */
public class Exam_VO4StudentExamRecordRtn {
	
	private String studentName;//考生姓名
	private String startTime;//开始时间
	private String finishTime;//胶卷时间
	private Integer duringTime;//考试用时(分钟)
	private Double score;//考试成绩
	private boolean isPass;//考试是否合格
	private String examWay;//考试方式:手机,电脑
	private Integer rank;//排名
	
	private Exam exam;//这场考试的信息
	private User user;//考生信息
	
	public Exam_VO4StudentExamRecordRtn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Exam_VO4StudentExamRecordRtn(String studentName, String startTime,
			String finishTime, Integer duringTime, Double score,
			boolean isPass, String examWay, Integer rank, Exam exam, User user) {
		super();
		this.studentName = studentName;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.duringTime = duringTime;
		this.score = score;
		this.isPass = isPass;
		this.examWay = examWay;
		this.rank = rank;
		this.exam = exam;
		this.user = user;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public Integer getDuringTime() {
		return duringTime;
	}
	public void setDuringTime(Integer duringTime) {
		this.duringTime = duringTime;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	public String getExamWay() {
		return examWay;
	}
	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Exam_VO4StudentExamRecordRtn [studentName=" + studentName
				+ ", startTime=" + startTime + ", finishTime=" + finishTime
				+ ", duringTime=" + duringTime + ", score=" + score
				+ ", isPass=" + isPass + ", examWay=" + examWay + ", rank="
				+ rank +"]";
	}
	
}
