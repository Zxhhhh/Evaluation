package com.why.Evaluation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.why.Evaluation.daoImpl.Exam_ExamDaoImpl;
import com.why.Evaluation.dto.Exam;

/**
 * 定时器工具类(Quartz框架)
 * @author K550J
 *
 */

@Component
public class WorkSchedulingUtil  {
	
	@Resource
	private Exam_ExamDaoImpl exam_ExamDaoImpl;

	/**
	 * 定时器:检查考试状态(一天检查一次)
	 */
    //@Scheduled(cron="*/3 * * * * *")  
    public void checkExamStatus(){  
    	
    	List<Exam> exams = exam_ExamDaoImpl.queryAllExams();
    	
    	for(Exam exam:exams){
    		try {
    			String examStatus = exam.getExamStatus();
    			Long currentTimeLong = new Date().getTime();
				Long examStartTimeLong = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(exam.getExamStartTime()).getTime();
				Long examEndTimeLong = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(exam.getExamEndTime()).getTime();
				
				if("已删除".equals(examStatus)){
					continue;
				}
				if(currentTimeLong<examStartTimeLong&&!("未开始".equals(examStatus))){
					exam.setExamStatus("未开始");
					exam_ExamDaoImpl.updateExamInformation(exam);
				}else if(currentTimeLong>examStartTimeLong&&currentTimeLong<examEndTimeLong&&!("进行中".equals(examStatus))){
					exam.setExamStatus("进行中");
					exam_ExamDaoImpl.updateExamInformation(exam);
				}else if(currentTimeLong>examEndTimeLong&&!("已结束".equals(examStatus))){
					exam.setExamStatus("已结束");
					exam_ExamDaoImpl.updateExamInformation(exam);
				}else{
					System.out.println("考试:"+exam.getExamName()+"状态正常");
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		
    	}
    	
    	
    }  

}
