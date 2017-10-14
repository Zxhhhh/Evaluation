package com.why.Evaluation.dao;

import java.util.List;


import com.why.Evaluation.dto.Questions;

public interface Exam_QuestionsDao {
	
	/**
	 * 新增试题并返回试题id
	 * @param question
	 * @return
	 */
	public Integer addQuestion(Questions question);
	
	/**
	 * 通过考试创建时间和题干获取考试(主要是要获取id)
	 * @param create_time
	 * @return
	 */
	public Questions getQuestionByCreateTimeAndTitle(String create_time,String title);
	
	/**
	 * 通过试题id获得试题
	 * @param questions_id
	 * @return
	 */
	public Questions getQuestionById(Integer question_id);
	
	/**
	 * 根据试卷类型获取试题 
	 * @param question_type
	 * @return
	 */
	public List<Questions> getQuestionsByType(String question_type);
	
	/**
	 * 根据职业分页获取试题
	 * @param pro_id
	 * @return
	 */
	public List<Questions> getQuestionsByPro(Integer pro_id);
	
	
	/**
	 * 获取所有试题
	 * @return
	 */
	public List<Questions> getAllQuestions();
	
	/**
	 * 通过创建时间段来获取考试
	 * @param start_time
	 * @param end_time
	 * @return
	 */
	public List<Questions> getQUestionsByCreateTimeQuantum(String start_time,String end_time);
	
	
}	
