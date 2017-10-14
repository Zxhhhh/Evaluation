package com.why.Evaluation.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.why.Evaluation.dao.Exam_ProDao;
import com.why.Evaluation.dto.Pro;
import com.why.Evaluation.dto.ProExample;
import com.why.Evaluation.dto.ProExample.Criteria;
import com.why.Evaluation.mapperImpl.ProMapper;

@Repository
public class Exam_ProDaoImpl implements Exam_ProDao {
	
	@Resource
	private ProMapper proMapper;

	@Override
	public List<Pro> getAllPro() {
		
		ProExample proExample = new ProExample();
		Criteria cri = proExample.createCriteria();
		
		List<Pro> pros =  proMapper.selectByExample(proExample);
		
		return null;
	}
	
	

}
