package com.why.Evaluation.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;

import com.why.Evaluation.dao.Exam_CatalogueDao;
import com.why.Evaluation.daoImpl.Exam_BigquestionDaoImpl;
import com.why.Evaluation.daoImpl.Exam_CatalogueDaoImpl;
import com.why.Evaluation.daoImpl.Exam_QuestionsDaoImpl;
import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.Catalogue;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.service.Exam_QuestionService;
import com.why.Evaluation.utils.Exam_StringParseUtil;
import com.why.Evaluation.vo.Exam_VO4QuestionAddParam;

@Service
public class Exam_QuestionServiceImpl implements Exam_QuestionService {
	
	@Resource
	private Exam_PaperServicempl exam_PaperServicempl;
	
	@Resource
	private Exam_QuestionsDaoImpl exam_QuestionsDaoImpl;
	
	@Resource
	private Exam_CatalogueDaoImpl exam_CatalogueDaoImpl;
	
	@Resource
	private Exam_BigquestionDaoImpl exam_BigquestionDaoImpl;
	
	public static Questions tranExam_VO4QuestionAddParam2Question(Exam_VO4QuestionAddParam exam_VO4QuestionAddParam){
		
		Questions question = new Questions();
		
		question.setAnswerTrue(exam_VO4QuestionAddParam.getAnswerTrue());
		question.setCatalogId(exam_VO4QuestionAddParam.getCatalogId());
		question.setCreateTime(exam_VO4QuestionAddParam.getCreateTime());
		question.setOptionA(exam_VO4QuestionAddParam.getOptionA());
		question.setOptionB(exam_VO4QuestionAddParam.getOptionB());
		question.setOptionC(exam_VO4QuestionAddParam.getOptionC());
		question.setOptionD(exam_VO4QuestionAddParam.getOptionD());
		question.setQuestionAnalysis(exam_VO4QuestionAddParam.getQuestionAnalysis());
		question.setQuestionLevel(exam_VO4QuestionAddParam.getQuestionLevel());
		question.setQuestionSocre(exam_VO4QuestionAddParam.getQuestionSocre());
		question.setQuestionTitle(exam_VO4QuestionAddParam.getQuestionTitle());
		question.setQuestionType(exam_VO4QuestionAddParam.getQuestionType());
		
		return question;
	}
	
	@Override
	public List<Catalogue> getAllCatalogues() {
		
		List<Catalogue> catalogues = exam_CatalogueDaoImpl.getAllCatalogues();
		
		return catalogues;
	}

	@Override
	public String addQuestionFromBigquestionService(Integer bigquestion_id,
			Exam_VO4QuestionAddParam exam_VO4QuestionAddParam) {
		
		
		String addQuestionFromBigquestionInformation = "";
		
		if(bigquestion_id!=null&&exam_VO4QuestionAddParam!=null){
			
			Questions question = tranExam_VO4QuestionAddParam2Question(exam_VO4QuestionAddParam);
			
			Integer question_id =  exam_QuestionsDaoImpl.addQuestion(question);
			
			System.out.println("试题Id:"+question_id);
			
			if(question_id!=0){
				
				boolean flag = exam_PaperServicempl.bindQuestionToBigquestion(bigquestion_id, question_id);
				
				if(flag){
					
					addQuestionFromBigquestionInformation = "试题绑定成功";
					
				}else{
					addQuestionFromBigquestionInformation = "试题新增成功,试题绑定失败";
				}
				
			}else{
				addQuestionFromBigquestionInformation = "试题新增失败";
			}
			
		}else{
			addQuestionFromBigquestionInformation = "非法参数";
		}
		
		return addQuestionFromBigquestionInformation;
	}

	@Override
	public List<Questions> getAllQuestionsExceptBigquestionHave(Integer bigquestion_id,HttpServletResponse response){
		
		Bigquestion bigquestion = exam_BigquestionDaoImpl.getBigquestionById(bigquestion_id);
		if(bigquestion.getQuestionIds()==null){
			bigquestion.setQuestionIds("");
		}
			
		List<String> bigquestionQuestionIds = Arrays.asList(bigquestion.getQuestionIds().split(","));
		
		
		List<Questions> questions = exam_QuestionsDaoImpl.getAllQuestions();
		
		for(int i=0;i<questions.size();i++){
			
			String idStr = String.valueOf(questions.get(i).getQuestionId());
			
			for(String str:bigquestionQuestionIds){
				if(idStr.equals(str)){
					System.out.println("删除已有试题");
					questions.remove(i);
					i--;
					break;
				}
			}
		}
		
		
		JSONArray json = JSONArray.fromObject(questions);
		
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("所有试题:"+json.toString());
		
		return questions;
	}

	@Override //检查新增试题字符串的格式
	public void checkQuestionStringFormat(HttpServletResponse response,
			String str) {
		
		boolean isAjax = true;
		
		
		//获取解析字符串的结果,因为只是见检查格式所以不需要传入类型
		Map parseQuestionStringResult = Exam_StringParseUtil.parseQuestionStr(str,isAjax,0);
		
		JSONArray json = JSONArray.fromObject(parseQuestionStringResult);
		
		System.out.println("解析结果:"+json.toString());
		
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override //通过合符格式的字符串新增多个试题
	public String addMoreQuestionsToBigquestionService(Integer bigquestion_id,
			String str,Integer questions_catalog) {
		
		boolean isAjax = false;
		
		Map parseQuestionStringsResult = new Exam_StringParseUtil().parseQuestionStr(str,isAjax,questions_catalog);
		
		
		List<Exam_VO4QuestionAddParam> exam_VO4QuestionAddParams = (ArrayList<Exam_VO4QuestionAddParam>)parseQuestionStringsResult.get("vo4QuestionAddParams");
		
		for(Exam_VO4QuestionAddParam exam_VO4QuestionAddParam:exam_VO4QuestionAddParams){
			String str2 =  addQuestionFromBigquestionService(bigquestion_id, exam_VO4QuestionAddParam);
			System.out.println(str2);
		}
		
		Integer pastQuestionCount = (Integer)parseQuestionStringsResult.get("pastQuestionCount");
		Integer notPastQuestionCount = (Integer)parseQuestionStringsResult.get("notPastQuestionCount");
		String notPastNumStr = (String)parseQuestionStringsResult.get("notPastNumStr");
		
		String result = "";
		if(notPastQuestionCount==0){
			result = "所有试题新增成功!";
		}else{
			result = "成功新增"+pastQuestionCount+"道试题,试题"+notPastNumStr+"格式错误,新增失败";
		}

		return result;
		
	}


}
