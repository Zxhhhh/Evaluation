package com.why.Evaluation.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.why.Evaluation.dto.Catalogue;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.serviceImpl.Exam_QuestionServiceImpl;
import com.why.Evaluation.utils.Exam_StringParseUtil;
import com.why.Evaluation.vo.Exam_VO4QuestionAddParam;
import com.why.Evaluation.vo.Exam_VO4QuestionQueryParam;

@Controller
public class Exam_QuestionController {
	
	@Resource
	private Exam_QuestionServiceImpl exam_QuestionServiceImpl;
	
	
	@RequestMapping("addQuestionPage")
	public String addQuestionPage(HttpServletRequest request){
		
		List<Catalogue> catalogues = exam_QuestionServiceImpl.getAllCatalogues();
		
		System.out.println("科目数量:"+catalogues.size());
		
		request.setAttribute("catalogues", catalogues);
		
		return "exam_addExamPaper_addExaminationQuestion.jsp";
	}
	
	@RequestMapping("addMoreQuestionsPage")
	public String addQuestionPage(Integer bigquestion_id,Integer paper_id,HttpServletRequest request){
		
		List<Catalogue> catalogues = exam_QuestionServiceImpl.getAllCatalogues();
		
		System.out.println("科目数量:"+catalogues.size());
		
		request.setAttribute("catalogues", catalogues);
		
		request.setAttribute("bigquestion_id",bigquestion_id);
		
		request.setAttribute("paper_id",paper_id);
		
		return "exam_addExamPaper_addMoreExaminationQuestion.jsp";
	}
	
	@RequestMapping("choiceQuestionPage")
	public String choiceQuestionPage(Integer paper_id,Integer bigquestion_id,HttpServletRequest request){
	
		
		List<Catalogue> catalogues = exam_QuestionServiceImpl.getAllCatalogues();
		
		System.out.println("科目数量:"+catalogues.size());
		
		request.setAttribute("catalogues", catalogues);
		
		request.setAttribute("bigquestion_id",bigquestion_id);
		
		request.setAttribute("paper_id", paper_id);
		
		return "exam_addExamPaper_choiceExaminationQuestion.jsp";
		
	}
	
	@RequestMapping(value="addQuestionFromBigquestion") //新增试题并把试题加入到大题中
	public String addQuestionFromBigquestion(HttpServletRequest request,Integer bigquestion_id,Integer paper_id,Exam_VO4QuestionAddParam exam_VO4QuestionAddParam){
		
		String questionType = exam_VO4QuestionAddParam.getQuestionType();
		String questionLevel = exam_VO4QuestionAddParam.getQuestionLevel();
		
		switch (questionType) {
		case "1":exam_VO4QuestionAddParam.setQuestionType("单选题");break;
		case "2":exam_VO4QuestionAddParam.setQuestionType("多选题");break;
		case "3":exam_VO4QuestionAddParam.setQuestionType("判断题");break;
		case "4":exam_VO4QuestionAddParam.setQuestionType("问答题");break;
		case "5":exam_VO4QuestionAddParam.setQuestionType("填空题");break;
		default:exam_VO4QuestionAddParam.setQuestionType("单选题");break;
		}
		
		switch (questionLevel) {
		case "1":exam_VO4QuestionAddParam.setQuestionLevel("低级");break;
		case "2":exam_VO4QuestionAddParam.setQuestionLevel("中级");break;
		case "3":exam_VO4QuestionAddParam.setQuestionLevel("高级");break;
		default:exam_VO4QuestionAddParam.setQuestionLevel("低级");break;
		
		}
		
		
		exam_VO4QuestionAddParam.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		System.out.println(exam_VO4QuestionAddParam);
		
		String addQuestionFromBigquestionResult = exam_QuestionServiceImpl.addQuestionFromBigquestionService(bigquestion_id, exam_VO4QuestionAddParam);
		
		request.setAttribute("paper_id",paper_id);
		
		return "exam_addExamPaper.jsp";
	}
	
	@RequestMapping("queryQuestionsBySelect")
	public void queryQuestionsBySelect(HttpServletResponse response,Exam_VO4QuestionQueryParam exam_VO4QuestionQueryParam){
		
	}
	
	@RequestMapping("getAllQuestionsExceptBigquestionHave") //获取所有试题但大题以加入的试题除外
	public void getAllQuestionsExceptBigquestionHave(Integer bigquestion_id,HttpServletResponse response){
		
		System.out.println("大题Id:"+bigquestion_id);
		
		List<Questions> questions = exam_QuestionServiceImpl.getAllQuestionsExceptBigquestionHave(bigquestion_id,response);
	}
	
	@RequestMapping("addMoreQuestions") //增加多个试题
	public String addMoreQuestions(HttpServletRequest request,String str,Integer bigquestion_id,Integer paper_id,Integer questions_catalog){
		
		System.out.println("试题的目录:"+questions_catalog);
		
		String result = exam_QuestionServiceImpl.addMoreQuestionsToBigquestionService(bigquestion_id, str,questions_catalog);
		
		request.setAttribute("paper_id",paper_id);
		request.setAttribute("goodInformation", result);
		
		return "exam_addExamPaper.jsp";
	}
	
	@RequestMapping("checkMoreQuestions") //检查试题字符串格式
	public void checkMoreQuestions(HttpServletResponse response,String str){
		
		System.out.println("Controller被调用");
		
		//Exam_StringParseUtil.parseQuestionStr(str);
		exam_QuestionServiceImpl.checkQuestionStringFormat(response, str);
	}
	
	
	

}
