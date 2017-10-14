package com.why.Evaluation.dao;

import java.util.List;
import java.util.Map;

import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.Situation;

public interface Exam_SituationDao {
	
	/**
	 * 通过主键找到考试记录
	 * @param id
	 * @return
	 */
	public Situation querySituationById(Integer id);
	
	/**
	 * 通过用户id找到该用户在该场考试的所有考试记录
	 * @param user_id
	 * @return
	 */
	public List<Situation> querySituationsByUserId(Integer user_id,Integer exam_id);
	
	/**
	 * 通过考试id找到该考试的所有考试记录
	 * @param exam_id
	 * @return
	 */
	public List<Situation> querySituationsByExamId(Integer exam_id);
	
	/**
	 * 通过考试id分页获取考试记录
	 * @param exam_id
	 * @param pageNum
	 * @return
	 */
	public List<Situation> querySituationByExamIdPagination(Integer exam_id,Integer pageNum);
	
	/**
	 * 找到一场考试的平均分
	 * @param exam_id
	 * @return
	 */
	public Double queryAvarageScoreByExamId(Integer exam_id);
	
	/**
	 * 找到一场考试的最高分
	 * @param exam_id
	 * @return
	 */
	public Double queryHightestScoreByExamId(Integer exam_id);
	
	/**
	 * 找到一场考试的最低分
	 * @param exam_id
	 * @return
	 */
	public Double queryLowestScoreByExamId(Integer exam_id);
	
	/**
	 * 找到一场考试的考试记录数
	 * @param exam_id
	 * @return
	 */
	public Integer querySituationCountByExamId(Integer exam_id);
	
	/**
	 * 找到一场考试中及格的记录数
	 * @param exam
	 * @return
	 */
	public Integer queryPassSituaionCountByExamId(Exam exam);
	
	/**
	 * 找到一场考试中不及格的记录数
	 * @param exam
	 * @param examNoPassScore
	 * @return
	 */
	public Integer queryNoPassSituationCountByExamId(Exam exam);
	
	/**
	 * 找到参与一场考试的考生总数
	 * @return
	 */
	public Integer queryStudentCountByExamId(Exam exam);
	
	/**
	 * 获得所有每场考试的所有考试记录的最高分
	 * @return
	 */
	public List<Map> getMaxScore();
	
	/**
	 * 获得每场考试的所有考试记录的平均分
	 * @return
	 */
	public List<Map> getAvgScore();
	
	/**
	 * 获得每场考试的考试次数
	 * @return
	 */
	public List<Map> getExamTime();

}
