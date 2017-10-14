package com.why.Evaluation.dao;

import com.why.Evaluation.dto.Paper;

public interface Exam_PaperDao {
	
	/**
	 * 新增试卷并返回其id
	 * @return
	 */
	public Integer addPaper(Paper paper);
	
	/**
	 * 删除试卷(在删除考试前要进行的操作)
	 * @param paper_id
	 * @return
	 */
	public boolean deletePaper(Integer paper_id);
	
	/**
	 * 更新试卷(新增，删除大题时用)
	 * @param paper
	 * @return
	 */
	public boolean updatePaper(Paper paper);
	
	/**
	 * 根据id获取试卷
	 * @param paper_id
	 * @return
	 */
	public Paper getPaperById(Integer paper_id);
		

}
