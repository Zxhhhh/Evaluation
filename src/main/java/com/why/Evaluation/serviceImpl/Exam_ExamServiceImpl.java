package com.why.Evaluation.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.why.Evaluation.dao.Exam_ExamDao;
import com.why.Evaluation.daoImpl.Exam_BigquestionDaoImpl;
import com.why.Evaluation.daoImpl.Exam_ExamDaoImpl;
import com.why.Evaluation.daoImpl.Exam_PaperDaoImpl;
import com.why.Evaluation.daoImpl.Exam_SituationDaoImpl;
import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.Paper;
import com.why.Evaluation.service.Exam_ExamService;
import com.why.Evaluation.utils.QRCodeUtil;
import com.why.Evaluation.vo.Exam_VO4ExamAddInformationParam;
import com.why.Evaluation.vo.Exam_VO4ExamShowRtn;
import com.why.Evaluation.vo.Exam_VO4ExamUpdateInformationParam;
import com.why.Evaluation.vo.Exam_VO4QRCodeInfo;

import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
import org.springframework.scheduling.quartz.QuartzJobBean;

@Service
public class Exam_ExamServiceImpl  implements Exam_ExamService  {
	
	public static Exam tranExam_VO4ExamUpdateInformationParam2Exam(Exam_VO4ExamUpdateInformationParam exam_VO4ExamUpdateInformationParam){
		
		Exam exam = new Exam();
		
		exam.setExamId(exam_VO4ExamUpdateInformationParam.getExam_id());
		exam.setCheckAns(exam_VO4ExamUpdateInformationParam.getCheck_ans());
		exam.setExamCompleted(exam_VO4ExamUpdateInformationParam.getExam_completed());
		exam.setExamDuration(exam_VO4ExamUpdateInformationParam.getExam_duration());
		exam.setExamName(exam_VO4ExamUpdateInformationParam.getExam_name());
		exam.setExamNopassTips(exam_VO4ExamUpdateInformationParam.getExam_nopass_tips());
		exam.setExamPassScore(exam_VO4ExamUpdateInformationParam.getExam_pass_score());
		exam.setExamPassTips(exam_VO4ExamUpdateInformationParam.getExam_pass_tips());
		exam.setExamPassword(exam_VO4ExamUpdateInformationParam.getExam_password());
		exam.setExamScore(exam_VO4ExamUpdateInformationParam.getExam_score());
		exam.setExamNotice(exam_VO4ExamUpdateInformationParam.getExam_notice());
		
		
		return exam;
	}
	
	public static Exam tranExam_VO4ExamAddInformationParam2Exam(Exam_VO4ExamAddInformationParam exam_VO4ExamAddInformationParam){
		
		Exam exam = new Exam();
		
		exam.setAdminId(exam_VO4ExamAddInformationParam.getAdmin_id());
		exam.setCheckAns(exam_VO4ExamAddInformationParam.getCheck_ans());
		exam.setCreateTime(exam_VO4ExamAddInformationParam.getExam_create_time());
		exam.setExamCompleted(exam_VO4ExamAddInformationParam.getExam_completed());
		exam.setExamDuration(exam_VO4ExamAddInformationParam.getExam_duration());
		exam.setExamEndTime(exam_VO4ExamAddInformationParam.getExam_end_time());
		exam.setExamName(exam_VO4ExamAddInformationParam.getExam_name());
		exam.setExamNopassTips(exam_VO4ExamAddInformationParam.getExam_nopass_tips());
		exam.setExamPassScore(exam_VO4ExamAddInformationParam.getExam_pass_score());
		exam.setExamPassTips(exam_VO4ExamAddInformationParam.getExam_pass_tips());
		exam.setExamPassword(exam_VO4ExamAddInformationParam.getExam_password());
		exam.setExamScore(exam_VO4ExamAddInformationParam.getExam_score());
		exam.setExamStartTime(exam_VO4ExamAddInformationParam.getExam_start_time());
		exam.setExamNotice(exam_VO4ExamAddInformationParam.getExam_notice());
		
		Date today = new Date();
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(exam.getExamStartTime());
			 endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(exam.getExamEndTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer dateSq_1 = new Date().compareTo(startDate);
		Integer dateSq_2 = new Date().compareTo(endDate);
		
		if(dateSq_1<0){
			exam.setExamStatus("未开始");
		}else if(dateSq_2>0){
			exam.setExamStatus("已结束");
		}else{
			exam.setExamStatus("进行中");
		}
		return exam;
	}
	
	public Exam_VO4ExamShowRtn tranExam2Exam_VO4ExamShowRtn(Exam exam){
		
		Exam_VO4ExamShowRtn exam_VO4ExamShowRtn = new Exam_VO4ExamShowRtn();
		exam_VO4ExamShowRtn.setExam(exam);
		
		//获取考试记录次数
		Integer situationCount = exam_SituationDaoImpl.querySituationCountByExamId(exam.getExamId());
		//获取考试及格次数
		Integer situationPassCount = exam_SituationDaoImpl.queryPassSituaionCountByExamId(exam);
		
		//计算合格率
		double passRate=0;
		if(situationCount!=0){
			passRate = Math.floor(((double)situationPassCount/(double)situationCount)*100);
		}
		
		exam_VO4ExamShowRtn.setExamPassRate(passRate);
		exam_VO4ExamShowRtn.setExamUserCount(situationCount);
		
		return exam_VO4ExamShowRtn;
	}
	
	@Resource
	private Exam_ExamDaoImpl exam_ExamDaoImpl;
	
	@Resource
	private Exam_PaperDaoImpl exam_PaperDaoImpl;
	
	@Resource
	private Exam_BigquestionDaoImpl exam_BigquestionDaoImpl;
	
	@Resource
	private Exam_SituationDaoImpl exam_SituationDaoImpl;

	@Override //通过考试状态来获取考试(分页),通过json写回前端
	public List<Exam> getExamsByStatusService(String exam_status,
			Integer pageNum,HttpServletResponse response,Integer admin_id) {
		
		List<Exam> exams = null;
		
		if(exam_status!=null&&pageNum!=null){
			exams = exam_ExamDaoImpl.queryExamsByStatus_Pagination(exam_status, pageNum,admin_id,3);
			List<Exam_VO4ExamShowRtn> examShowRtn = new ArrayList<>();
			for(Exam exam:exams){
				Exam_VO4ExamShowRtn exam_VO4ExamShowRtn = tranExam2Exam_VO4ExamShowRtn(exam);
				examShowRtn.add(exam_VO4ExamShowRtn);
			}
			
			JSONArray jsons = JSONArray.fromObject(examShowRtn);
			System.out.println("Exams:"+jsons.toString());
			
			try {
				response.getWriter().print(jsons);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return exams;
	}

	@Override //根据条件来获取考试(分页)
	public Integer getExamsCountByStatusService(String exam_status,Integer admin_id) {
		
		Integer count=0;
		
		if(exam_status!=null){
			count = exam_ExamDaoImpl.countExamsByStatus(exam_status,admin_id);
		}
		
		return count;
	}

	@Override
	public List<Exam> getExamBySelectService(String exam_status,
			String createTime, Integer pageNum,Integer admin_id) {
		
		List<Exam> exams = new ArrayList<Exam>();
		
		if(exam_status!=null&&createTime!=null){
			exams = exam_ExamDaoImpl.queryExamsByCreateYearAndStatus_Pagination(pageNum, createTime, exam_status, admin_id);
		}else if(exam_status!=null&&createTime==null){
			exams = exam_ExamDaoImpl.queryExamsByStatus_Pagination(exam_status, pageNum, admin_id,8);
		}else if(exam_status==null&&createTime!=null){
			exams = exam_ExamDaoImpl.queryExamsByCreateYear_Pagination(pageNum, createTime, admin_id);
		}else{
			exams = exam_ExamDaoImpl.queryAllExams_Pagination(pageNum, admin_id);
		}
		
		return exams;
	}

	@Override
	public List<Exam> getExamBySelectAjaxService(HttpServletResponse response,String exam_status,
			String createTime, Integer pageNum, Integer admin_id) {
		
		List<Exam> exams = new ArrayList<Exam>();
		
		if(exam_status!=null&&createTime!=null){
			exams = exam_ExamDaoImpl.queryExamsByCreateYearAndStatus_Pagination(pageNum, createTime, exam_status, admin_id);
		}else if(exam_status!=null&&createTime==null){
			exams = exam_ExamDaoImpl.queryExamsByStatus_Pagination(exam_status, pageNum, admin_id,8);
		}else if(exam_status==null&&createTime!=null){
			exams = exam_ExamDaoImpl.queryExamsByCreateYear_Pagination(pageNum, createTime, admin_id);
		}else{
			exams = exam_ExamDaoImpl.queryAllExams_Pagination(pageNum, admin_id);
		}
		
		JSONArray json = JSONArray.fromObject(exams);
		System.out.println("exams:"+json.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exams;		
		
		
	}

	
	@Override //新增考试信息
	public Map addExamInformationService(
			Exam_VO4ExamAddInformationParam exam_VO4ExamAddInformationParam) {
		
		Map addExamInformationResult = new HashMap();
		
		String addExamInformation = "";
		Integer exam_id=0;
		
		String examName = exam_VO4ExamAddInformationParam.getExam_name();
		String examStartTime = exam_VO4ExamAddInformationParam.getExam_start_time();
		String examEndTime = exam_VO4ExamAddInformationParam.getExam_end_time();
		
		if(examName!=null&&examStartTime!=null&&examEndTime!=null){
			
			if(!exam_ExamDaoImpl.examExist(examName, examStartTime, examEndTime)){
				
				Paper paper = new Paper();
				paper.setPaperUuid(UUID.randomUUID().toString());
				Integer paper_id = exam_PaperDaoImpl.addPaper(paper); //创建一张试卷 
				
				Bigquestion bigquestion = new Bigquestion();
				bigquestion.setPaperId(paper_id);
				bigquestion.setBigquestionN(1);
				bigquestion.setBigquestionScore(0.0);
				exam_BigquestionDaoImpl.addBigquestion(bigquestion);
				
				Exam exam = tranExam_VO4ExamAddInformationParam2Exam(exam_VO4ExamAddInformationParam);
				exam.setPaparId(paper_id);
				
				exam_id = exam_ExamDaoImpl.addExamInformation(exam);
				
				addExamInformation = "新增考试信息成功,请继续完成试卷创建";
				
				addExamInformationResult.put("addExamInformation", addExamInformation);
				addExamInformationResult.put("exam_id", exam_id);
				addExamInformationResult.put("paper_id", paper_id);
				
			}else{
				addExamInformation = "该时间段已有同名考试,请更改考试时间段或考试名";
			}
		}else{
			addExamInformation = "考试信息填写未完善";
			addExamInformationResult.put("addExamInformation", addExamInformation);
		}
		
		return addExamInformationResult;
	}

	@Override
	public Exam publishExamService(HttpServletRequest request,Integer paper_id) {
		
		Paper paper = exam_PaperDaoImpl.getPaperById(paper_id);
		Exam exam = exam_ExamDaoImpl.queryExamByPaperId(paper_id);
		
		String url = exam.getExamUrl();
		
		String codeUrl = exam.getExamQcodeUrl();
		
		if(url==null||codeUrl==null){//新增的考试
			
			String realPath = request.getSession().getServletContext().getRealPath("/");
			System.out.println("真实路径:"+realPath);
			
			String imgPath = "img/exam/qrlogo/"+new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
			File file = new File(realPath+imgPath);
			if(!file.exists()){
				file.mkdirs();
				System.out.println("创建成功");
			}
			
			String imgName = exam.getExamPassword()+"qrlogo.png";
			Integer imgWidth = 90;
			Integer imgHeight = 90;
			String imgFormat = "png";
			
			//设置考试url通道，并设置二维码 在kk那里拿url字符串
			String imgContent = "http://localhost:8080/Client/home.do"; //测试用
			
			//二维码信息
			Exam_VO4QRCodeInfo exam_VO4QRCodeInfo = new Exam_VO4QRCodeInfo(realPath+imgPath, imgName, imgContent, imgWidth, imgHeight, imgFormat);

			try {
				new QRCodeUtil().Encode(exam_VO4QRCodeInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			exam.setExamUrl(imgContent);
			exam.setExamQcodeUrl(imgPath+"/"+imgName);
			
			exam_ExamDaoImpl.updateExamInformation(exam);
			
		}else{//更新的考试
			
		}
		
		return exam;
	}

	@Override
	public Map updateExamInformationService(
			Exam_VO4ExamUpdateInformationParam exam_VO4ExamUpdateInformationParam) {
		
		Map updateExamInformationResult = new HashMap(); 
		
		String updateExamInformation="";
		
		if(exam_VO4ExamUpdateInformationParam!=null){
			
			//转化vo为dto
			Exam exam = tranExam_VO4ExamUpdateInformationParam2Exam(exam_VO4ExamUpdateInformationParam);
			
			Exam updatedExam = exam_ExamDaoImpl.updateExamInformation(exam);
			
			if(updatedExam!=null){
				
				updateExamInformation = "更新成功";
				
				Integer paper_id = updatedExam.getPaparId();
				updateExamInformationResult.put("paper_id",paper_id);
				
			}else{
				
				updateExamInformation = "更新失败";
				updateExamInformationResult.put("exam",exam);
			}
			
		}else{
			
			updateExamInformation = "非法参数";
			
		}
		
		updateExamInformationResult.put("updateExamInformation", updateExamInformation);
		
		
		return updateExamInformationResult;
	}

	@Override
	public Exam getExam(Integer exam_id) {
		
		Exam exam = null;
		
		if(exam_id!=null){
			
			exam = exam_ExamDaoImpl.queryExamById(exam_id);
			
		}
		
		return exam;
	}

	@Override
	public String scoreCheck(Integer paper_id, Double exam_score) {
		
		String checkResult = "";
		
		Integer paperScore = exam_BigquestionDaoImpl.getBigquestionScoreSum(paper_id);
		
		if(paperScore>exam_score){
			
			checkResult = "more";
			
		}else if(paperScore<exam_score){
			
			checkResult = "less";
			
		}else{
			
			checkResult = "equals";
		}
		
		return checkResult;
	}

}
