package com.why.Evaluation.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.vo.Exam_VO4ExamAddInformationParam;
import com.why.Evaluation.vo.Exam_VO4ExamUpdateInformationParam;

public interface Exam_ExamService {
	
	/**
	 * 通过考试状态来获取考试(分页),通过json写回前端
	 * @param exam_status
	 * @param pageNum
	 * @param response
	 * @return
	 */
	public List<Exam> getExamsByStatusService(String exam_status,Integer pageNum,HttpServletResponse response,Integer admin_id);
	
	public Integer getExamsCountByStatusService(String exam_status,Integer admin_id);
	
	/**
	 * 根据条件来获取考试(分页)
	 * @return
	 */
	public List<Exam> getExamBySelectService(String exam_status,String createTime,Integer pageNum,Integer admin_id);
	
	
	public List<Exam> getExamBySelectAjaxService(HttpServletResponse response,String exam_status,String createTime,Integer pageNum,Integer admin_id);

	/**
	 * 新增考试信息
	 * @param exam_VO4ExamAddInformationParam
	 * @return
	 */
	public Map addExamInformationService(Exam_VO4ExamAddInformationParam exam_VO4ExamAddInformationParam);
	
	public Map updateExamInformationService(Exam_VO4ExamUpdateInformationParam exam_VO4ExamUpdateInformationParam);
	
	/**
	 * 完成发布考试
	 * @param paper_id
	 * @return
	 */
	public Exam publishExamService(HttpServletRequest request,Integer paper_id);
	
	public Exam getExam(Integer exam_id);
	
	/**
	 * 检查试卷分数与考试要求的总分是否一致
	 * @param paper_id
	 * @param exam_score
	 * @return
	 */
	public String scoreCheck(Integer paper_id,Double exam_score);
}
