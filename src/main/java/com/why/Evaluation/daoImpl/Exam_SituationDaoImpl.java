package com.why.Evaluation.daoImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.why.Evaluation.dao.Exam_SituationDao;
import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.Situation;
import com.why.Evaluation.dto.SituationExample;
import com.why.Evaluation.dto.SituationExample.Criteria;
import com.why.Evaluation.mapperImpl.SituationMapper;

@Repository
public class Exam_SituationDaoImpl implements Exam_SituationDao {

	
	@Resource
	private SituationMapper situationMapper;


	@Override
	public Situation querySituationById(Integer id) {
		
		Situation situation = situationMapper.selectByPrimaryKey(id);
		
		return situation;
	}

	@Override
	public List<Situation> querySituationsByUserId(Integer user_id,
			Integer exam_id) {
		
		SituationExample situationExample = new SituationExample();
		
		Criteria cri = situationExample.createCriteria();
		
		cri.andUserIdEqualTo(user_id);
		cri.andExamIdEqualTo(exam_id);
		
		List<Situation> situations = situationMapper.selectByExample(situationExample);
		
		return situations;
	}

	@Override
	public List<Situation> querySituationsByExamId(Integer exam_id) {
		
		
		SituationExample situationExample = new SituationExample();
		
		Criteria cri = situationExample.createCriteria();
		
		cri.andExamIdEqualTo(exam_id);
		
		List<Situation> situations = situationMapper.selectByExample(situationExample);
		
		return situations;
	}
	
	@Override
	public Double queryAvarageScoreByExamId(Integer exam_id) {
		
		Double avarageScore =0.0;
		try{
			avarageScore = situationMapper.queryAvarageScoreByExamId(exam_id);
		}catch (Exception e) {
			avarageScore = 0.0;
		}
		return avarageScore;
	}

	@Override
	public Double queryHightestScoreByExamId(Integer exam_id) {
		
		Double highestScore = 0.0;
		try{
			highestScore = situationMapper.queryHightestScoreByExamId(exam_id);
		}catch (Exception e) {
			highestScore = 0.0;
		}
		return highestScore;
	}

	@Override
	public Double queryLowestScoreByExamId(Integer exam_id) {
		
		Double lowestScore = 0.0;
		try{
			lowestScore = situationMapper.queryLowestScoreByExamId(exam_id);
		}catch (Exception e) {
			lowestScore = 0.0;
		}
		return lowestScore;
	}

	@Override
	public Integer querySituationCountByExamId(Integer exam_id) {
		
		SituationExample situationExample = new SituationExample();
		Criteria cri = situationExample.createCriteria();
		cri.andExamIdEqualTo(exam_id);
		Integer situationCount = situationMapper.countByExample(situationExample);
		return situationCount;
	}

	@Override
	public Integer queryPassSituaionCountByExamId(Exam exam) {
		
		Integer exam_id = exam.getExamId();
		Double exam_pass_score =  exam.getExamPassScore();
		
		SituationExample situationExample = new SituationExample();
		Criteria cri = situationExample.createCriteria();
		cri.andExamIdEqualTo(exam_id);
		cri.andExamScoreGreaterThanOrEqualTo(exam_pass_score);
		Integer passSituationCount = situationMapper.countByExample(situationExample);
		
		return passSituationCount;
	}

	@Override
	public Integer queryNoPassSituationCountByExamId(Exam exam) {
		
		Integer exam_id = exam.getExamId();
		Double exam_pass_score =  exam.getExamPassScore();
		
		SituationExample situationExample = new SituationExample();
		
		Criteria cri = situationExample.createCriteria();
		cri.andExamIdEqualTo(exam_id);
		cri.andExamScoreLessThan(exam_pass_score);
		
		Integer passSituationCount = situationMapper.countByExample(situationExample);
		
		return passSituationCount;
		
	}

	@Override
	public Integer queryStudentCountByExamId(Exam exam) {
		Integer exam_id = exam.getExamId();
		List<Situation> results = situationMapper.queryStudentCountByExamId(exam_id);
		return results.size();
	}

	@Override
	public List<Situation> querySituationByExamIdPagination(Integer exam_id,
			Integer pageNum) {
		PageHelper.startPage(pageNum,2);
		SituationExample situationExample = new SituationExample();
		Criteria cri = situationExample.createCriteria();
		cri.andExamIdEqualTo(exam_id);
		List<Situation> situations = situationMapper.selectByExample(situationExample);
		return situations;
	}

	@Override
	public List<Map> getMaxScore() {
		
		List<Map> result = situationMapper.maxScore();
		
		return result;
	}

	@Override
	public List<Map> getAvgScore() {
		
		List<Map> result = situationMapper.avgScore();
		
		return result;
	}

	@Override
	public List<Map> getExamTime() {
		
		List<Map> result = situationMapper.examTime();
		
		return result;
	}

}
