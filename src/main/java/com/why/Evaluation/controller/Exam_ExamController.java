package com.why.Evaluation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.why.Evaluation.daoImpl.Exam_ExamDaoImpl;
import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.serviceImpl.Exam_ExamServiceImpl;
import com.why.Evaluation.vo.Exam_VO4ExamAddInformationParam;
import com.why.Evaluation.vo.Exam_VO4ExamUpdateInformationParam;

@Controller
public class Exam_ExamController {
	

	@Resource
	private Exam_ExamServiceImpl exam_ExamServiceImpl;
	
	@Resource
	private Exam_ExamDaoImpl exam_ExamDaoImpl;
	
	

	@RequestMapping(value="getExamsByStatus")
	public void getExamsByStatus(String exam_status, Integer pageNum,
			HttpServletResponse response, HttpSession session) {
		
		if(pageNum==null){
			pageNum=1;
		}
		
		switch (exam_status) {
		case "1":exam_status="进行中";break;
		case "2":exam_status="未开始";break;
		case "3":exam_status="已结束";break;
		case "4":exam_status="已删除";break;
		default:exam_status="进行中";break;
		}
		
		System.out.println(exam_status);
		
		List<Exam> exams = exam_ExamServiceImpl.getExamsByStatusService(exam_status, pageNum, response,1);
		
		PageInfo<Exam> pageInfo = new PageInfo<Exam>(exams);
		
		session.setAttribute("ExamPageInfo", pageInfo);

	}
	
	@RequestMapping("getStatusExamTotalNum")
	public void  getExamTotalNum(String exam_status,HttpServletResponse response){
		
		switch (exam_status) {
			case "1":exam_status="进行中";break;
			case "2":exam_status="未开始";break;
			case "3":exam_status="已结束";break;
			case "4":exam_status="已删除";break;
			default:exam_status="进行中";break;
		}
		
		
		Integer count  = exam_ExamServiceImpl.getExamsCountByStatusService(exam_status,1);
		
		Map<String, Integer> values = new HashMap<String, Integer>();
		
		values.put("count", count);
		
		JSONArray json = JSONArray.fromObject(values);
		
		System.out.println("count:"+json);
		
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 新增考卷:增加考试信息
	 * @return
	 */
	@RequestMapping("addExam_Information")
	public String addExam_Information(HttpSession session,HttpServletRequest request,Exam_VO4ExamAddInformationParam exam_VO4ExamAddInformationParam){
		
		//注入新增的管理员id
		Integer admin_id = (Integer)session.getAttribute("admin_id");
		if(admin_id==null){
			admin_id = 1;
		}
		exam_VO4ExamAddInformationParam.setAdmin_id(admin_id);
		
		//注入多选框
		String exam_completed = exam_VO4ExamAddInformationParam.getExam_completed();
		String check_ans = exam_VO4ExamAddInformationParam.getCheck_ans();
		if(exam_completed==null){
			exam_VO4ExamAddInformationParam.setExam_completed("off");
		}
		
		if(check_ans==null){
			exam_VO4ExamAddInformationParam.setCheck_ans("off");
		}
		
		
		//注入考试创建时间
		exam_VO4ExamAddInformationParam.setExam_create_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		System.out.println("新增考试信息:"+exam_VO4ExamAddInformationParam);
		
		Map addExamInformationResult = exam_ExamServiceImpl.addExamInformationService(exam_VO4ExamAddInformationParam);
		
		String addExamInformation = (String)addExamInformationResult.get("addExamInformation");
		Integer exam_id = (Integer)addExamInformationResult.get("exam_id");
		Integer paper_id = (Integer)addExamInformationResult.get("paper_id");
		
		if(exam_id!=null){
			
			Double exam_score = exam_VO4ExamAddInformationParam.getExam_score();
			//request.setAttribute("exam_id",exam_id);
			request.setAttribute("paper_id", paper_id);
			session.setAttribute("exam_score", exam_score);
			request.setAttribute("goodInformation",addExamInformation);
			
			return "exam_addExamPaper.jsp";
			
		}else{
			
			request.setAttribute("badInformation",addExamInformation);
			
			return "exam_addInformation.jsp";
		}
		
	}
	
	/**
	 * 更新考试:更新考试信息
	 * @param session
	 * @param request
	 * @param exam_VO4ExamUpdateInformationParam
	 * @return
	 */
	@RequestMapping("updateExam_Information")
	public String updateExam_Information(HttpSession session,HttpServletRequest request,Exam_VO4ExamUpdateInformationParam exam_VO4ExamUpdateInformationParam){
		
		
		//注入多选框
		String exam_completed = exam_VO4ExamUpdateInformationParam.getExam_completed();
		String check_ans = exam_VO4ExamUpdateInformationParam.getCheck_ans();
		if(exam_completed==null){
			exam_VO4ExamUpdateInformationParam.setExam_completed("off");
		}
		if(check_ans==null){
			exam_VO4ExamUpdateInformationParam.setCheck_ans("off");
		}
		
		System.out.println("vo对象:"+exam_VO4ExamUpdateInformationParam);
		
		Map updateExamInformationResult = exam_ExamServiceImpl.updateExamInformationService(exam_VO4ExamUpdateInformationParam);
		
		String updateExamInformation = (String)updateExamInformationResult.get("updateExamInformation");
		
		if("更新成功".equals(updateExamInformation)){

			Double exam_score = exam_VO4ExamUpdateInformationParam.getExam_score();
			
			Integer paper_id = (Integer)updateExamInformationResult.get("paper_id");
			System.out.println("paper_id:"+paper_id);
			request.setAttribute("paper_id",paper_id);
			session.setAttribute("exam_score", exam_score);
			request.setAttribute("goodInformation",updateExamInformation);
			
			return "exam_addExamPaper.jsp";
		}else{
			
			Exam exam = (Exam)updateExamInformationResult.get("exam");
			request.setAttribute("exam", exam);
			request.setAttribute("badInformation", updateExamInformation);
			return "exam_addExamInformation.jsp";
		}
	}
	
//	public String addExam_Paper(){
//		
//		return "exam_addExamPublish";
//	}
	
	@RequestMapping("updateExam")
	public String updateExam(HttpServletRequest request,HttpServletResponse response,Integer exam_id){
		
		Exam exam = exam_ExamServiceImpl.getExam(exam_id);
		
		String exam_status = exam.getExamStatus();
		
		if(!"进行中".equals(exam_status)){
			request.setAttribute("exam", exam);
			return "exam_addExamInformation.jsp";
		}else{
			String badInformation = "只有非进行中的考试才能编辑考试信息";
			request.setAttribute("badInformation", badInformation);
			return "exam_index.jsp";
		}
	}
	
	
	@RequestMapping("getExamsBySelect")
	public String getExamBySelect(HttpSession session,HttpServletRequest request,Integer pageNum,String exam_status,String createTime){
		
		if(exam_status!=null){
			switch (exam_status) {
				case "1":exam_status="进行中";break;
				case "2":exam_status="未开始";break;
				case "3":exam_status="已结束";break;
				case "4":exam_status="已删除";break;
				default:exam_status="进行中";break;
			}
		}
		
		if(pageNum==null){
			pageNum=1;
		}
		
		List<Exam> exams = exam_ExamServiceImpl.getExamBySelectService(exam_status, createTime, pageNum,1);
		
		PageInfo<Exam> pageInfo = new PageInfo<Exam>(exams);
		
		session.setAttribute("queryExamPageInfo", pageInfo);
		
		request.setAttribute("exams", exams);
		
		return "exam_check_examList.jsp";
	}
	
	@RequestMapping("getExamsBySelect_ajax")
	public void getExamsBySelect_ajax(HttpSession session,HttpServletRequest request,HttpServletResponse response,Integer pageNum,String exam_status,String createTime){
		
		if(pageNum==null){
			pageNum=1;
		}
		
		if(exam_status!=null){
			switch (exam_status) {
				case "1":exam_status="进行中";break;
				case "2":exam_status="未开始";break;
				case "3":exam_status="已结束";break;
				case "4":exam_status="已删除";break;
				default:exam_status="进行中";break;
			}
		}
		
		List<Exam> exams = exam_ExamServiceImpl.getExamBySelectAjaxService(response, exam_status, createTime, pageNum, 1);
		
		PageInfo<Exam> pageInfo = new PageInfo<Exam>(exams);
		
		session.setAttribute("queryExamPageInfo", pageInfo);
		
	}
	
	@RequestMapping("publishExam")
	public String publishExam(HttpServletRequest request,Integer paper_id,Double exam_score){
		
		System.out.println("考试总分:"+exam_score);
		
		String checkResult = exam_ExamServiceImpl.scoreCheck(paper_id, exam_score);
		
		if("more".equals(checkResult)){
			request.setAttribute("badInformation","试卷总分大于考试总分,请减少试题");
			request.setAttribute("paper_id", paper_id);
			return "exam_addExamPaper.jsp";
		}else if("less".equals(checkResult)){
			request.setAttribute("badInformation","试卷总分小于考试总分,请增加试题");
			request.setAttribute("paper_id", paper_id);
			return "exam_addExamPaper.jsp";
		}else{
			Exam exam = exam_ExamServiceImpl.publishExamService(request,paper_id);//发布考试(第一次)
			request.setAttribute("exam",exam);
			return "exam_addExamPublish.jsp";
		}
	}
	
	@RequestMapping("previewExam")
	public String previewExam(Integer exam_id,HttpServletRequest request){
		
		Exam targetExam = exam_ExamDaoImpl.queryExamById(exam_id);
		request.setAttribute("exam",targetExam);
		return "exam_examLink.jsp";
	}
	
	@RequestMapping(value="deleteExam",method=RequestMethod.GET)
	public String  deleteExam(Integer exam_id,HttpServletRequest request){
		
		Exam exam = exam_ExamServiceImpl.getExam(exam_id);
		exam.setExamStatus("已删除");
		exam_ExamDaoImpl.updateExamInformation(exam);
		
		return "exam_index.jsp";
	}
}
