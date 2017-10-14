package com.why.Evaluation.dao;

import java.util.List;

import com.why.Evaluation.dto.Catalogue;

public interface Exam_CatalogueDao {
	
	/**
	 * 获取全部科目
	 * @return
	 */
	public List<Catalogue> getAllCatalogues();

}
