package com.why.Evaluation.dao;

import java.util.List;

import com.why.Evaluation.dto.Bigquestion;

public interface Exam_BigquestionDao  {
	
	/**
	 * 新增大题并返回大题的编号
	 * @param bigquestion
	 * @return
	 */
	public Integer addBigquestion(Bigquestion bigquestion);
	
	/**
	 * 通过试卷id和大题号获取唯一大题(主要是用于获取id)
	 * @param paper_id
	 * @param bigquestion_n
	 * @return
	 */
	public Bigquestion getBigquestionByPaperAndNumber(Integer paper_id,Integer bigquestion_n);
	
	/**
	 * 根据大题id获取大题
	 * @param bigquestion_id
	 * @return
	 */
	public Bigquestion getBigquestionById(Integer bigquestion_id);
	
	/**
	 * 根据试卷id来获取该试卷的所有大题
	 * @param paper_id
	 * @return
	 */
	public List<Bigquestion> getBigquestionsByPaperId(Integer paper_id);
	
	/**
	 * 修改大题(增加,删除小题,修改大题的总分值)
	 * @param bigquestion
	 * @return
	 */
	public boolean updateBigquestion(Bigquestion bigquestion);
	
	/**
	 * 降低大题的序号(在大题被删除后，在其后面大题的序号-1)
	 * @param bigquestion
	 * @return
	 */
	public boolean decreaseBigquestionNumber(Bigquestion bigquestion);
	
	/**
	 * 删除大题
	 * @param bigquestion_id
	 * @return
	 */
	public boolean deleteBigquestion(Integer bigquestion_id);

	/**
	 * 获取需要减少大题序号的大题(删除大题时要做的动作)
	 * @param bigquestion
	 * @return
	 */
	public List<Bigquestion> getUnderNumberExam(Bigquestion bigquestion);
	
	/**
	 * 获取最大的序号
	 * @param paper_id
	 * @return
	 */
	public Integer getBiggestBigquestionN(Integer paper_id);
	
	/**
	 * 获得试卷所有大题的总分
	 * @param paper_id
	 * @return
	 */
	public Integer getBigquestionScoreSum(Integer paper_id);
}
