package com.why.Evaluation.vo;

import com.why.Evaluation.dto.Exam;

public class Exam_VO4ExamShowRtn {

	private Integer examUserCount;
	private Double examPassRate;
	private Exam exam;

	public Exam_VO4ExamShowRtn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getExamUserCount() {
		return examUserCount;
	}

	public void setExamUserCount(Integer examUserCount) {
		this.examUserCount = examUserCount;
	}

	public Double getExamPassRate() {
		return examPassRate;
	}

	public void setExamPassRate(Double examPassRate) {
		this.examPassRate = examPassRate;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
