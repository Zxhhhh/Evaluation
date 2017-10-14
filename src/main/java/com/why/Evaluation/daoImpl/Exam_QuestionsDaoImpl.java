package com.why.Evaluation.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.why.Evaluation.dao.Exam_QuestionsDao;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.dto.QuestionsExample;
import com.why.Evaluation.dto.QuestionsExample.Criteria;
import com.why.Evaluation.mapperImpl.QuestionsMapper;

@Repository
public class Exam_QuestionsDaoImpl implements Exam_QuestionsDao {
	
	@Resource
	private QuestionsMapper questionsMapper;

	@Override //新增试题并返回试题id
	public Integer addQuestion(Questions question) {
		
		Integer currentQuestion_id = 0;
		
		Integer result = questionsMapper.insert(question);
		
		if(result!=0){
			
			//通过创建时间来获取唯一id，有点不保险，容易出bug，后期要换成uuid
			Questions currentQuestion = getQuestionByCreateTimeAndTitle(question.getCreateTime(),question.getQuestionTitle());
			
			currentQuestion_id = currentQuestion.getQuestionId();
			
		}
		
		return currentQuestion_id;
	}
	
	@Override //通过考试创建时间获取考试(主要是要获取id)
	public Questions getQuestionByCreateTimeAndTitle(String create_time,String title){
		
		Questions question = null;
		
		QuestionsExample questionsExample = new QuestionsExample();
		
		Criteria cri = questionsExample.createCriteria();
		
		cri.andCreateTimeEqualTo(create_time);
		
		cri.andQuestionTitleEqualTo(title);
		
		List<Questions> questions = questionsMapper.selectByExample(questionsExample);
		
		if(questions.size()!=0){
			
			question = questions.get(0);
			
		}
		
		return question;
		
	}

	@Override //通过试题id获得试题
	public Questions getQuestionById(Integer question_id) {
		
		Questions question = questionsMapper.selectByPrimaryKey(question_id);
		
		return question;
	}
	

	@Override //根据试卷类型获取试题 
	public List<Questions> getQuestionsByType(String question_type) {
		
		QuestionsExample questionsExample = new QuestionsExample();
		
		Criteria cri = questionsExample.createCriteria();
		
		cri.andQuestionTypeEqualTo(question_type);
		
		List<Questions> questions = questionsMapper.selectByExample(questionsExample);
		
		return questions;
	}

	@Override //根据科目获取试题
	public List<Questions> getQuestionsByPro(Integer catalog_id) {
		
		QuestionsExample questionsExample = new QuestionsExample();
		
		Criteria cri = questionsExample.createCriteria();
		
		cri.andCatalogIdEqualTo(catalog_id);
		
		List<Questions> questions = questionsMapper.selectByExample(questionsExample);
		
		return questions;
		
	}

	@Override //获取所有试题
	public List<Questions> getAllQuestions() {
		
		QuestionsExample questionsExample = new QuestionsExample();
		
		Criteria cri = questionsExample.createCriteria();
		
		List<Questions> questions = questionsMapper.selectByExample(questionsExample);
		
		return questions;
	}

	@Override //通过创建时间段来获取考试
	public List<Questions> getQUestionsByCreateTimeQuantum(String start_time,
			String end_time) {
		
		QuestionsExample questionsExample = new QuestionsExample();
		
		Criteria cri = questionsExample.createCriteria();
		
		cri.andCreateTimeBetween(start_time, end_time);
		
		List<Questions> questions = questionsMapper.selectByExample(questionsExample);
		
		return questions;
	}


}
