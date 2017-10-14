package com.why.Evaluation.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.Situation;
import com.why.Evaluation.service.Exam_StatisticsService;
import com.why.Evaluation.serviceImpl.Exam_ExamServiceImpl;
import com.why.Evaluation.vo.Exam_VO4ExamStatisticsRtn;
import com.why.Evaluation.vo.Exam_VO4StudentExamRecordRtn;

@Controller
public class Exam_StatisticsController {
	
	@Resource
	private Exam_ExamServiceImpl exam_ExamServiceImpl;
	
	@Resource
	private Exam_StatisticsService exam_StatisticsService;
	
	@RequestMapping("getExamStatistics")
	public String getExamStatistics(Integer exam_id,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		Exam_VO4ExamStatisticsRtn exam_VO4ExamStatisticsRtn =  exam_StatisticsService.getExamStatisticsService(exam_id);
		session.setAttribute("examStatistics",exam_VO4ExamStatisticsRtn);
		session.setAttribute("exam_id",exam_id);
		
		Map result = exam_StatisticsService.getStudentRecordService(exam_id,1);
		PageInfo<Situation> pageInfo = (PageInfo<Situation>)result.get("pageInfo");
		List<Exam_VO4StudentExamRecordRtn> records = (List<Exam_VO4StudentExamRecordRtn>)result.get("records");
		session.setAttribute("StudentRecordPage",pageInfo);
		request.setAttribute("records",records);
		System.out.println("--大小:"+records.size());
		
		return "exam_examStatistics.jsp";
	}
	
	@RequestMapping("getStudentRecords")
	public String getStudentRecords(HttpServletRequest request,HttpSession session,Integer exam_id,Integer pageNum){
		
		if(pageNum==null){
			pageNum=1;
		}
		
		Map result = exam_StatisticsService.getStudentRecordService(exam_id,pageNum);
		PageInfo<Situation> pageInfo = (PageInfo<Situation>)result.get("pageInfo");
		List<Exam_VO4StudentExamRecordRtn> records = (List<Exam_VO4StudentExamRecordRtn>)result.get("records");
		System.out.println("--大小:"+records.size());
		session.setAttribute("StudentRecordPage",pageInfo);
		request.setAttribute("records",records);
		
		return "exam_examStatistics.jsp";
	}
	
	@RequestMapping("getAllExamStatusCount")
	public void getAllExamStatusCount(HttpServletResponse response,HttpSession session){
		Integer admin_id = 0;
		if(session.getAttribute("admin_id")!=null){
			admin_id = (int)session.getAttribute("admin_id");
		}else{
			admin_id = 1;
		}
		exam_StatisticsService.getAllExamStatusCountService(response, admin_id);
	}
	
	@RequestMapping(value="getChartData/{dataType}")
	public void getChartData(@PathVariable("dataType") String dataType,Integer exam_id,HttpServletResponse response){
		
		System.out.println("进入方法:"+dataType+"--"+exam_id);
		
		if("score".equals(dataType)){
			exam_StatisticsService.getExamScoreChartData(response, exam_id);
		}else if("time".equals(dataType)){
			exam_StatisticsService.getExamTimeChartData(response, exam_id);
		}else if("pass".equals(dataType)){
			exam_StatisticsService.getExamPassChartData(response, exam_id);
		}
		
	}

}
