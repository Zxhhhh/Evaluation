package com.why.Evaluation.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.Questions;

public interface Exam_PaperService {
	
	/**
	 * 获取试卷的所有大题
	 * @param response
	 * @param paper_id
	 * @return
	 */
	public List<Bigquestion> getBigquestions(HttpServletResponse response,Integer paper_id);
	
	
	/**
	 * 获取一道大题的所有小题
	 * @param response
	 * @param question_ids
	 * @return
	 */
	public List<Questions> getQuestionsFromBigquestion(HttpServletResponse response,String question_ids);
	
	/**
	 * 新增大题
	 * @param response
	 * @param paper_id
	 * @return
	 */
	public Bigquestion addBigquestion(HttpServletResponse response,Integer paper_id,Integer part_id);
	
	/**
	 * 删除大题
	 * @param paper_id
	 * @param part_id
	 * @param bigquestion_id
	 */
	public boolean deleteBigquestion(HttpServletResponse response,Integer paper_id,Integer part_id,Integer bigquestion_id);
	
	/**
	 * 绑定试题到大题中
	 * @param bigquestion_id
	 * @param question_id
	 * @return
	 */
	public boolean bindQuestionToBigquestion(Integer bigquestion_id,Integer question_id);
	
	/**
	 * 解除大题中绑定的试题
	 * @param bigquestion_id
	 * @param question_id
	 * @return
	 */
	public boolean unbindQuestionToBigquestion(Integer bigquestion_id,Integer question_id);
	
	/**
	 * 在试题库选择试题加入到大题中
	 * @param question_ids
	 * @param bigquestion_id
	 * @return
	 */
	public boolean choiceQUestionsToBigquestion(String[] question_ids,Integer bigquestion_id);
	
	public boolean deleteQuestionsFromBigquestionService(Integer bigquestion_id,Integer question_id);
}
