package com.why.Evaluation.vo;

/**
 * 考试信息更新vo
 * @author K550J
 *
 */
public class Exam_VO4ExamUpdateInformationParam {
	
	private Integer exam_id; //考试id
	private String exam_name; //考试名称
	private Integer exam_duration; //考试时长(分钟)
	private Double exam_pass_score; //考试及格分
	private Double exam_score; //考试总分
	private String exam_password; //考试口令
	private String exam_completed; //考生是否需要完成答卷才交卷
	private String check_ans; //考生交卷后是否可以看查案
	private String exam_notice; //考试须知(类似公告,在考试前告知考生)
	private String exam_pass_tips; //通过考试的提示信息
	private String exam_nopass_tips; //没有通过考试的提示信息
	public Exam_VO4ExamUpdateInformationParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam_VO4ExamUpdateInformationParam(Integer exam_id,
			String exam_name, Integer exam_duration, Double exam_pass_score,
			Double exam_score, String exam_password, String exam_completed,
			String check_ans, String exam_notice, String exam_pass_tips,
			String exam_nopass_tips) {
		super();
		this.exam_id = exam_id;
		this.exam_name = exam_name;
		this.exam_duration = exam_duration;
		this.exam_pass_score = exam_pass_score;
		this.exam_score = exam_score;
		this.exam_password = exam_password;
		this.exam_completed = exam_completed;
		this.check_ans = check_ans;
		this.exam_notice = exam_notice;
		this.exam_pass_tips = exam_pass_tips;
		this.exam_nopass_tips = exam_nopass_tips;
	}
	public Integer getExam_id() {
		return exam_id;
	}
	public void setExam_id(Integer exam_id) {
		this.exam_id = exam_id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public Integer getExam_duration() {
		return exam_duration;
	}
	public void setExam_duration(Integer exam_duration) {
		this.exam_duration = exam_duration;
	}
	public Double getExam_pass_score() {
		return exam_pass_score;
	}
	public void setExam_pass_score(Double exam_pass_score) {
		this.exam_pass_score = exam_pass_score;
	}
	public Double getExam_score() {
		return exam_score;
	}
	public void setExam_score(Double exam_score) {
		this.exam_score = exam_score;
	}
	public String getExam_password() {
		return exam_password;
	}
	public void setExam_password(String exam_password) {
		this.exam_password = exam_password;
	}
	public String getExam_completed() {
		return exam_completed;
	}
	public void setExam_completed(String exam_completed) {
		this.exam_completed = exam_completed;
	}
	public String getCheck_ans() {
		return check_ans;
	}
	public void setCheck_ans(String check_ans) {
		this.check_ans = check_ans;
	}
	public String getExam_notice() {
		return exam_notice;
	}
	public void setExam_notice(String exam_notice) {
		this.exam_notice = exam_notice;
	}
	public String getExam_pass_tips() {
		return exam_pass_tips;
	}
	public void setExam_pass_tips(String exam_pass_tips) {
		this.exam_pass_tips = exam_pass_tips;
	}
	public String getExam_nopass_tips() {
		return exam_nopass_tips;
	}
	public void setExam_nopass_tips(String exam_nopass_tips) {
		this.exam_nopass_tips = exam_nopass_tips;
	}
	@Override
	public String toString() {
		return "Exam_VO4ExamUpdateInformationParam [exam_id=" + exam_id
				+ ", exam_name=" + exam_name + ", exam_duration="
				+ exam_duration + ", exam_pass_score=" + exam_pass_score
				+ ", exam_score=" + exam_score + ", exam_password="
				+ exam_password + ", exam_completed=" + exam_completed
				+ ", check_ans=" + check_ans + ", exam_notice=" + exam_notice
				+ ", exam_pass_tips=" + exam_pass_tips + ", exam_nopass_tips="
				+ exam_nopass_tips + "]";
	}
	
	
	
}
