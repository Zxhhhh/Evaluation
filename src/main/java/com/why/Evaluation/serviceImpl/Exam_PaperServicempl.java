package com.why.Evaluation.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.why.Evaluation.dao.Exam_PaperDao;
import com.why.Evaluation.daoImpl.Exam_BigquestionDaoImpl;
import com.why.Evaluation.daoImpl.Exam_QuestionsDaoImpl;
import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.Paper;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.service.Exam_PaperService;

@Service
public class Exam_PaperServicempl implements Exam_PaperService {
	
	@Resource
	private Exam_BigquestionDaoImpl exam_BigquestionDaoImpl;
	
	@Resource
	private Exam_QuestionsDaoImpl exam_QuestionsDaoImpl;

	@Override //获取试卷的所有大题
	public List<Bigquestion> getBigquestions(HttpServletResponse response,
			Integer paper_id) {
		
		List<Bigquestion> bigquestions = exam_BigquestionDaoImpl.getBigquestionsByPaperId(paper_id);
		
		JSONArray json = JSONArray.fromObject(bigquestions);
		
		try {
			System.out.println("大题:"+json.toString());
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bigquestions;
	}

	@Override
	public List<Questions> getQuestionsFromBigquestion(
			HttpServletResponse response, String question_ids) {
		
		List<Questions> questions = new ArrayList<Questions>();
		
		String[] idStrings = question_ids.split(",");
		
			
		for(int i=0;i<idStrings.length;i++){
			if("".equals(idStrings[i])){
				continue;
			}
			Questions question = exam_QuestionsDaoImpl.getQuestionById(Integer.parseInt(idStrings[i]));
			questions.add(question);
		}
		
		JSONArray json = JSONArray.fromObject(questions);
	
		System.out.println("小题:"+json.toString());
		
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questions;
	}

	@Override
	public Bigquestion addBigquestion(HttpServletResponse response,
			Integer paper_id, Integer part_id) {
		
		Bigquestion bigquestion = null;
		
		if(paper_id!=null&&part_id!=null){
			
			Integer biggestN = exam_BigquestionDaoImpl.getBiggestBigquestionN(paper_id);
			
			if(part_id!=biggestN+1){
				part_id=biggestN+1;
			}
			
			//构造新大题
			bigquestion = new Bigquestion();
			bigquestion.setPaperId(paper_id);
			bigquestion.setBigquestionN(part_id);
			bigquestion.setBigquestionScore(0.0);
			
			//保存大题并获取id
			Integer bigquestion_id = exam_BigquestionDaoImpl.addBigquestion(bigquestion);
			bigquestion.setBigquestionId(bigquestion_id);
			
			try {
				JSONArray json = JSONArray.fromObject(bigquestion);
				response.getWriter().print(json.toString());
				System.out.println("新增大题:"+json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return bigquestion;
	}

	@Override
	public boolean deleteBigquestion(HttpServletResponse response,Integer paper_id, Integer part_id,
			Integer bigquestion_id) {
		
		Bigquestion bigquestion = exam_BigquestionDaoImpl.getBigquestionById(bigquestion_id);
		
		System.out.println("数据库的次序:"+bigquestion.getBigquestionN()+"\n前端给的次序:"+part_id);
		
		if(bigquestion.getBigquestionN()!=part_id){
			part_id=bigquestion.getBigquestionN();
		}
		
		List<Bigquestion> bigquestions = exam_BigquestionDaoImpl.getUnderNumberExam(bigquestion);
		
		for(Bigquestion bq:bigquestions){
			
			exam_BigquestionDaoImpl.decreaseBigquestionNumber(bq);
			
		}
		
		boolean result = exam_BigquestionDaoImpl.deleteBigquestion(bigquestion_id);
		
		JSONArray json =JSONArray.fromObject(result);
		
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("boolean:"+json);
		
		return result;
	}

	@Override
	public boolean bindQuestionToBigquestion(Integer bigquestion_id,
			Integer question_id) {
		
		if(bigquestion_id!=null&&question_id!=null){
			
			Bigquestion bigquestion = exam_BigquestionDaoImpl.getBigquestionById(bigquestion_id);
			Questions question =exam_QuestionsDaoImpl.getQuestionById(question_id);
			
			String question_idStr = String.valueOf(question_id);
			
			String bigquestion_questionIds = bigquestion.getQuestionIds();
			
			if(bigquestion_questionIds==null||"".equals(bigquestion_questionIds)){
				
				bigquestion_questionIds=question_idStr;
				
			}else{
				String[] ids_array = bigquestion_questionIds.split(",");
				
				for(String str:ids_array){
					
					if(str.equals(question_idStr)){
						System.out.println("id相同?");
						return false;
					}
				}
				
				bigquestion_questionIds = bigquestion_questionIds+","+question_idStr;
			}
			
			//改变试题绑定
			bigquestion.setQuestionIds(bigquestion_questionIds);
			
			//改变大题总分
			Double oldScore = bigquestion.getBigquestionScore();
			Double newScore = oldScore+ question.getQuestionSocre();
			bigquestion.setBigquestionScore(newScore);
			
			System.out.println("ids:"+bigquestion_questionIds);
			
			System.out.println(bigquestion);
			
			boolean result =  exam_BigquestionDaoImpl.updateBigquestion(bigquestion);
				
			return result;
			
		}
		
		return false;
	}

	
	@Override
	public boolean unbindQuestionToBigquestion(Integer bigquestion_id,
			Integer question_id) {
		
		if(bigquestion_id!=null&&question_id!=null){
			
			Bigquestion bigquestion = exam_BigquestionDaoImpl.getBigquestionById(bigquestion_id);
			Questions question =exam_QuestionsDaoImpl.getQuestionById(question_id);
			
			String question_idStr = String.valueOf(question_id);
			
			String bigquestion_questionIds = bigquestion.getQuestionIds();
			
			
			String[] ids_array = bigquestion_questionIds.split(",");
			
			List<String> ids_list = Arrays.asList(ids_array);
			
			ids_list.remove(question_idStr);
			
			bigquestion_questionIds = ids_list.toString();
			
			System.out.println("list转回来后:"+bigquestion_questionIds);
			
			bigquestion_questionIds.substring(1, bigquestion_questionIds.length()-1);
			
			System.out.println("斩去头尾后:"+bigquestion_questionIds);
			
			bigquestion.setQuestionIds(bigquestion_questionIds);
			
			Double oldScore = bigquestion.getBigquestionScore();
			Double newScore = oldScore-question.getQuestionSocre();
			bigquestion.setBigquestionScore(newScore);
			
			boolean result =  exam_BigquestionDaoImpl.updateBigquestion(bigquestion);
				
			return result;
			
		}
		
		return false;	
		
	}

	@Override
	public boolean choiceQUestionsToBigquestion(String[] question_ids,
			Integer bigquestion_id) {
		
		System.out.println("选择的试题Id集合:"+Arrays.asList(question_ids).toString());
		
		Bigquestion bigquestion = exam_BigquestionDaoImpl.getBigquestionById(bigquestion_id);
		
		Double bigquestionScore = bigquestion.getBigquestionScore();
		Double scoreCount = 0.0;
		String question_idsStr="";
		for(int i=0;i<question_ids.length;i++){
			
			Integer question_id = Integer.parseInt(question_ids[i]);
			
			Questions question = exam_QuestionsDaoImpl.getQuestionById(question_id);
			
			scoreCount+= question.getQuestionSocre();
			
			if(i!=question_ids.length-1){
				question_idsStr+=question_ids[i]+",";
			}else{
				question_idsStr+=question_ids[i];
			}
		}
		
		bigquestion.setBigquestionScore(scoreCount+bigquestionScore);
		
		
		String bigquestionQuestions = bigquestion.getQuestionIds();
		if(bigquestionQuestions==null||"".equals(bigquestionQuestions)){
			bigquestion.setQuestionIds(question_idsStr);
		}else{
			bigquestionQuestions+=","+question_idsStr;
			bigquestion.setQuestionIds(bigquestionQuestions);
		}
		
		boolean result = exam_BigquestionDaoImpl.updateBigquestion(bigquestion);
		
		return result;
	}

	@Override
	public boolean deleteQuestionsFromBigquestionService(
			Integer bigquestion_id, Integer question_id) {
		
		Bigquestion bigquestion = exam_BigquestionDaoImpl.getBigquestionById(bigquestion_id);
		
		Questions question = exam_QuestionsDaoImpl.getQuestionById(question_id);
		
		String question_idStr = String.valueOf(question_id);
		String oldQuestionIds = bigquestion.getQuestionIds();
		
		System.out.println("旧的试题字符串:"+oldQuestionIds);
		
		String newQuestionIds ="";
		
		String[] questionIds = oldQuestionIds.split(",");
		
		for(int i=0;i<questionIds.length;i++){
			
			if(questionIds[i].equals(question_idStr)){
				
				questionIds[i] = "delete";
				
			}
			
//			if(!questionIds[i].equals(question_idStr)){
//				
//				if(i!=questionIds.length-1){
//					if(questionIds[i+1].equals(question_idStr)){
//						newQuestionIds+=questionIds[i];
//					}else{
//						newQuestionIds+=questionIds[i]+",";
//					}
//				}else{
//					newQuestionIds+=questionIds[i];
//				}
//			}
		}
		
		for(int i=0;i<questionIds.length;i++){
			
			if(i!=questionIds.length-1){
				
				if("delete".equals(questionIds[i])){
					continue;
				}else{
					newQuestionIds+=questionIds[i]+",";
				}
				
			}else{
				
				if("delete".equals(questionIds[i])){
					
					if(i==0){
						newQuestionIds = "";
					}else{
						newQuestionIds = newQuestionIds.substring(0,newQuestionIds.lastIndexOf(","));
					}
					
				}else{
					newQuestionIds+=questionIds[i];
				}
			}
		}

		
		System.out.println("新的试题字符串:"+newQuestionIds);
		
		Double oldScore = bigquestion.getBigquestionScore();
		
		Double newScore = oldScore-question.getQuestionSocre();
		
		bigquestion.setBigquestionScore(newScore);
		
		bigquestion.setQuestionIds(newQuestionIds);
		
		exam_BigquestionDaoImpl.updateBigquestion(bigquestion);
		
		return true;
	}

}
