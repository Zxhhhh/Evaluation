package com.why.Evaluation.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.why.Evaluation.dao.Exam_CatalogueDao;
import com.why.Evaluation.dto.Catalogue;
import com.why.Evaluation.dto.CatalogueExample;
import com.why.Evaluation.dto.CatalogueExample.Criteria;
import com.why.Evaluation.mapperImpl.CatalogueMapper;

@Repository
public class Exam_CatalogueDaoImpl implements Exam_CatalogueDao {

	@Resource
	private CatalogueMapper catalogueMapper;
	
	@Override
	public List<Catalogue> getAllCatalogues() {
		
		CatalogueExample catalogueExample = new CatalogueExample();
		
		Criteria cri = catalogueExample.createCriteria();
		
		List<Catalogue> catalogues = catalogueMapper.selectByExample(catalogueExample);
		
		return catalogues;
	}

}
