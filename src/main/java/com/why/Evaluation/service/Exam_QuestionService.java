package com.why.Evaluation.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.why.Evaluation.dto.Catalogue;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.vo.Exam_VO4QuestionAddParam;

public interface Exam_QuestionService {
	
	/**
	 * 获取所有的科目
	 * @return
	 */
	public List<Catalogue> getAllCatalogues();
	
	/**
	 * 在大题中新增试题
	 * @param bigquestion_id
	 * @param exam_VO4QuestionAddParam
	 * @return
	 */
	public String addQuestionFromBigquestionService(Integer bigquestion_id,Exam_VO4QuestionAddParam exam_VO4QuestionAddParam);

	
	/**
	 * 获取所有试题
	 * @return
	 */
	public List<Questions> getAllQuestionsExceptBigquestionHave(Integer bigquestion_id,HttpServletResponse response);
	

	/**
	 * 检查试题字符串是否符合格式，在response中返回各种结果
	 * @param response
	 * @param str
	 */
	public void checkQuestionStringFormat(HttpServletResponse response,String str);
	
	public String addMoreQuestionsToBigquestionService(Integer bigquestion_id,String str,Integer questions_type);
	
	
}
