package com.why.Evaluation.daoImpl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.why.Evaluation.dao.Exam_PaperDao;
import com.why.Evaluation.dto.Paper;
import com.why.Evaluation.dto.PaperExample;
import com.why.Evaluation.dto.PaperExample.Criteria;
import com.why.Evaluation.mapperImpl.PaperMapper;

@Repository
public class Exam_PaperDaoImpl implements Exam_PaperDao {
	
	@Resource
	private PaperMapper paperMapper;

	@Override
	public Integer addPaper(Paper paper) {
		
		Integer result = 0;
		
		String uuid = paper.getPaperUuid();
		
		paperMapper.insert(paper);
		
		PaperExample paperExample = new PaperExample();
		Criteria cri = paperExample.createCriteria();
		cri.andPaperUuidEqualTo(uuid);
		
		List<Paper> papers = paperMapper.selectByExample(paperExample);
		
		if(papers.size()!=0){
			result = papers.get(0).getPaperId();
		}
		
		return result;
	}

	@Override
	public boolean deletePaper(Integer paper_id) {
		
		Integer result = paperMapper.deleteByPrimaryKey(paper_id); 
		
		return result==0?false:true;
	}

	@Override
	public boolean updatePaper(Paper paper) {
		
		Integer result = paperMapper.updateByPrimaryKeySelective(paper);
		
		return result==0?false:true;
	}

	@Override
	public Paper getPaperById(Integer paper_id) {
		
		Paper paper = paperMapper.selectByPrimaryKey(paper_id);
		
		return paper;
	}

}
