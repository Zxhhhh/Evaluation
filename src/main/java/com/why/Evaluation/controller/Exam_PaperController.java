package com.why.Evaluation.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.Paper;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.serviceImpl.Exam_PaperServicempl;

@Controller
public class Exam_PaperController {
	
	@Resource
	private Exam_PaperServicempl exam_PaperServicempl;
	
	
	@RequestMapping("getBigquestions") //获取试卷的所有大题
	public void getBigquestions(HttpServletResponse response,Integer paper_id){
		
		List<Bigquestion> bigquestions = exam_PaperServicempl.getBigquestions(response,paper_id);
		

	}
	
	@RequestMapping("getQuestionsFromBigquestion") //获取大题的所有试题
	public void getQuestionsFromBigquestion(HttpServletResponse response,String question_ids){
		
		
		List<Questions> questions = exam_PaperServicempl.getQuestionsFromBigquestion(response, question_ids);
		
	}
	
	@RequestMapping("addBigquestion") //新增大题
	public void addBigquestion(HttpServletResponse response,Integer paper_id,Integer part_id){
		
		
		Bigquestion bigquestion  = exam_PaperServicempl.addBigquestion(response, paper_id, part_id);
	}
	
	@RequestMapping("deleteBigquestion") //删除大题
	public void deleteBigquestion(HttpServletResponse response,Integer paper_id,Integer bigquestion_id,Integer part_id){
		
		exam_PaperServicempl.deleteBigquestion(
				response,paper_id, part_id, bigquestion_id);
		
	}
	
	@RequestMapping("choiceQuestionsToBigquestion")
	public String choiceQuestionsToBigquestion(HttpServletRequest request,Integer paper_id,Integer bigquestion_id,String[] question_ids){
		
		
		boolean choiceQuestionsToBigquestionResult = exam_PaperServicempl.choiceQUestionsToBigquestion(question_ids, bigquestion_id);
		
		request.setAttribute("choiceQuestionsToBigquestionResult", choiceQuestionsToBigquestionResult);
		
		request.setAttribute("paper_id",paper_id);
		
		return "exam_addExamPaper.jsp";
	}
	
	@RequestMapping("deleteQuestionFromBigquestion") //在大题中删除试题
	public String deleteQuestionFromBigquestion(HttpServletRequest request,Integer bigquestion_id,Integer question_id){
		
		System.out.println(question_id+"--"+bigquestion_id);
		
		exam_PaperServicempl.deleteQuestionsFromBigquestionService(bigquestion_id, question_id);
		
		return "exam_addExamPaper.jsp";
	}
	

}
