package com.why.Evaluation.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.why.Evaluation.dto.Situation;
import com.why.Evaluation.vo.Exam_VO4ExamStatisticsRtn;
import com.why.Evaluation.vo.Exam_VO4StudentExamRecordRtn;

public interface Exam_StatisticsService {
	
	/**
	 * 获取该场考试的统计数据
	 * @param exam_id
	 * @return
	 */
	public Exam_VO4ExamStatisticsRtn getExamStatisticsService(Integer exam_id);
	
	/**
	 * 解析统计考试时间
	 * @param situations
	 * @return
	 */
	public Map<String, Integer> parseTimeFromSituation(List<Situation> situations);
	
	/**
	 * 获取该场考试的考生考试记录(json)
	 * @param exam_id
	 * @return
	 */
	public Map getStudentRecordService(Integer exam_id,Integer pageNum);
	
	/**
	 * 获取各状态的考试总数
	 * @param response
	 */
	public void getAllExamStatusCountService(HttpServletResponse response,Integer admin_id);
	
	/**
	 * 获得考试成绩的图表数据
	 * @param response
	 * @param exam_id
	 */
	public void getExamScoreChartData(HttpServletResponse response,Integer exam_id);
	
	/**
	 * 获得考试时间的图表数据
	 * @param response
	 * @param exam_id
	 */
	public void getExamTimeChartData(HttpServletResponse response,Integer exam_id);
	
	/**
	 * 获取考试合格的图表数据
	 * @param response
	 * @param exam_id
	 */
	public void getExamPassChartData(HttpServletResponse response,Integer exam_id);
}
