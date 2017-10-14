package com.why.Evaluation.serviceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.codehaus.jackson.map.util.Comparators;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.bind.v2.TODO;
import com.why.Evaluation.daoImpl.Exam_BigquestionDaoImpl;
import com.why.Evaluation.daoImpl.Exam_ExamDaoImpl;
import com.why.Evaluation.daoImpl.Exam_PaperDaoImpl;
import com.why.Evaluation.daoImpl.Exam_SituationDaoImpl;
import com.why.Evaluation.daoImpl.Exam_UserDaoImpl;
import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.Situation;
import com.why.Evaluation.dto.User;
import com.why.Evaluation.service.Exam_StatisticsService;
import com.why.Evaluation.vo.Exam_VO4ExamStatisticsRtn;
import com.why.Evaluation.vo.Exam_VO4PieChartInfo;
import com.why.Evaluation.vo.Exam_VO4StudentExamRecordRtn;

@Service
public class Exam_StatisticsServiceImpl implements Exam_StatisticsService {

	@Resource
	private Exam_ExamDaoImpl exam_ExamDaoImpl;
	
	@Resource
	private Exam_SituationDaoImpl exam_SituationDaoImpl;
	
	@Resource
	private Exam_PaperDaoImpl exam_PaperDaoImpl;
	
	@Resource
	private Exam_UserDaoImpl exam_UserDaoImpl;
	
	/**
	 * 获取考生考试排名
	 * @param scores
	 * @param score
	 * @return
	 */
	private Integer getRank(Double[] scores,Double score){
		
		Integer rank=0;
		Arrays.sort(scores);
		
		Double[] ascScores = new Double[scores.length];
		for(int i=0,j=scores.length-1;j>=0;i++,j--){
			ascScores[i] = scores[j];
		}
		
		for(int k=0;k<ascScores.length;k++){
			if(ascScores[k]==score){
				rank = k+1;
				break;
			}
		}
		return rank;
	}
	
	/**
	 * 获取考试的各种排名(直接可在数据库获取的，如最高分，平均分，考试次数排名)
	 * @param data
	 * @param exam_id
	 * @return
	 */
	public Integer getExamRank(List<Map> data,Integer exam_id){
		
		Integer rank = 0;
		
		for(Map map:data){
			rank++;
			Integer currentExam_id = (int)map.get("id");
			if(exam_id==currentExam_id){
				break;
			}
		}
		return rank;
	}
	
	/**
	 * 获取考试的其他数据在所有考试的排名(不可直接在数据库获取的，如合格率,完成时间)
	 * @param exam_id
	 * @return
	 */
	public Integer getPassRateRank(Integer exam_id){
		Integer rank=0;
		List<Exam> exams = exam_ExamDaoImpl.queryAllExams();
		Map[] maps = new Map[exams.size()];
		Integer i = 0;
		for(Exam exam:exams){
			//获取考试记录次数
			Integer situationCount = exam_SituationDaoImpl.querySituationCountByExamId(exam.getExamId());
			//获取考试及格次数
			Integer situationPassCount = exam_SituationDaoImpl.queryPassSituaionCountByExamId(exam);
			//获取考试合格率
			double passRate = Math.floor(((double)situationPassCount/(double)situationCount)*100);
			if(situationCount==null||situationCount==0){
				passRate =0;
			}
			HashMap map = new HashMap<>();
			map.put("id",exam.getExamId());
			map.put("stuff",passRate);
			maps[i] = map;
			i++;
		}
		Arrays.sort(maps,new Comparator<Map>() {

			@Override
			public int compare(Map o1, Map o2) {
				double rate1 = (double)o1.get("stuff");
				double rate2 = (double)o2.get("stuff");
				return (rate1>rate2)?-1:(rate1==rate2)?0:1;
			}
		});
		for(Map map:maps){
			rank++;
			if((int)map.get("id")==exam_id){
				break;
			}
		}

		return rank;
	}
	
	public Map<String,Integer> getTimeRank(Integer exam_id){
		
		Map<String,Integer> ranks = new HashMap<String, Integer>();
		
		List<Exam> exams = exam_ExamDaoImpl.queryAllExams();
		
		Map[] fastTimeMap = new Map[exams.size()];
		Map[] avgTimeMap =  new Map[exams.size()];
		
		Integer i=0;
		for(Exam exam:exams){
			List<Situation> situations = exam_SituationDaoImpl.querySituationsByExamId(exam_id);
				Map<String,Integer> times = parseTimeFromSituation(situations);
				
				fastTimeMap[i] = new HashMap<>();
				avgTimeMap[i] = new HashMap<>();
				
				fastTimeMap[i].put("id",exam.getExamId());
				fastTimeMap[i].put("data",times.get("fastestTime"));
				avgTimeMap[i].put("id",exam.getExamId());
				avgTimeMap[i].put("data",times.get("avarageTime"));
			i++;
		}
		//对时间排序应为升序，时间最少的排名最高
		Arrays.sort(fastTimeMap,new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
				int rate1 = (int)o1.get("data");
				int rate2 = (int)o2.get("data");
				return (rate1>rate2)?1:(rate1==rate2)?0:-1;
			}
		});
		//对时间排序应为升序，时间最少的排名最高
		Arrays.sort(avgTimeMap,new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
				int rate1 = (int)o1.get("data");
				int rate2 = (int)o2.get("data");
				return (rate1>rate2)?1:(rate1==rate2)?0:-1;
			}
		});
		Integer fastestRank=0;
		for(Map map:fastTimeMap){
			fastestRank++;
			if((int)map.get("id")==exam_id){
				ranks.put("fastestRank",fastestRank);
				break;
			}
		}
		Integer avgRank=0;
		for(Map map:fastTimeMap){
			avgRank++;
			if((int)map.get("id")==exam_id){
				ranks.put("avgRank",avgRank);
				break;
			}
		}
		
		return ranks;
	}
	/**
	 * 构造考生考试记录的实体VO类
	 * @param situation
	 * @param exam
	 * @param scores
	 * @return
	 */
	public Exam_VO4StudentExamRecordRtn tranSituation2Exam_VO4StudentExamRecordRtn(Situation situation,Exam exam,Double[] scores){
		
		User user = exam_UserDaoImpl.queryUserById(situation.getUserId());
		
		Long date_start = null;
		Long date_end = null;
		try {
			date_end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(situation.getEndTime()).getTime();
			date_start = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(situation.getStartTime()).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer duringTime = (int) ((date_end-date_start)/1000/60);
		
		boolean isPass = situation.getExamScore()>exam.getExamPassScore()?true:false;
		
		Exam_VO4StudentExamRecordRtn exam_VO4StudentExamRecordRtn = new Exam_VO4StudentExamRecordRtn();
		
		exam_VO4StudentExamRecordRtn.setDuringTime(duringTime);
		exam_VO4StudentExamRecordRtn.setExam(exam);
		exam_VO4StudentExamRecordRtn.setExamWay("电脑");//考试方法待定全是"电脑"
		exam_VO4StudentExamRecordRtn.setFinishTime(situation.getEndTime());
		exam_VO4StudentExamRecordRtn.setStartTime(situation.getStartTime());
		exam_VO4StudentExamRecordRtn.setPass(isPass);
		exam_VO4StudentExamRecordRtn.setRank(getRank(scores,situation.getExamScore()));
		exam_VO4StudentExamRecordRtn.setScore(situation.getExamScore());
		exam_VO4StudentExamRecordRtn.setStudentName(user.getUserAccount());
		exam_VO4StudentExamRecordRtn.setUser(user);
		
		return exam_VO4StudentExamRecordRtn;
	}
	
	@Override
	public Exam_VO4ExamStatisticsRtn getExamStatisticsService(Integer exam_id) {
		
		Exam_VO4ExamStatisticsRtn exam_VO4ExamStatisticsRtn = new Exam_VO4ExamStatisticsRtn();
		Exam exam  = exam_ExamDaoImpl.queryExamById(exam_id);
		
		Double examScore = exam.getExamScore();
		Integer examTime = exam.getExamDuration();
		
		List<Situation> situations = exam_SituationDaoImpl.querySituationsByExamId(exam_id);
		
		//获取考试人数
		Integer studentCount = exam_SituationDaoImpl.queryStudentCountByExamId(exam);
		//获取考试记录次数
		Integer situationCount = exam_SituationDaoImpl.querySituationCountByExamId(exam_id);
		//获取考试及格次数
		Integer situationPassCount = exam_SituationDaoImpl.queryPassSituaionCountByExamId(exam);
		//获取考试不及格次数
		Integer situationNoPassCount = exam_SituationDaoImpl.queryNoPassSituationCountByExamId(exam);
		//获取考试平均分
		double avarageScore = exam_SituationDaoImpl.queryAvarageScoreByExamId(exam_id);
		//获取考试最高分
		double highestScore = exam_SituationDaoImpl.queryHightestScoreByExamId(exam_id);
		//获取考试最低分
		double lowestScore =  exam_SituationDaoImpl.queryLowestScoreByExamId(exam_id);
		//获取考试合格率
		double passRate = Math.floor(((double)situationPassCount/(double)situationCount)*100);
		
		
		
		Map<String,Integer> exam_times = parseTimeFromSituation(situations);
		
		exam_VO4ExamStatisticsRtn.setExam_id(exam_id);
		exam_VO4ExamStatisticsRtn.setExamStudentCount(studentCount);
		exam_VO4ExamStatisticsRtn.setAvarageScore(avarageScore);
		exam_VO4ExamStatisticsRtn.setHighestScore(highestScore);
		exam_VO4ExamStatisticsRtn.setLowestScore(lowestScore);
		exam_VO4ExamStatisticsRtn.setExamCount(situationCount);
		exam_VO4ExamStatisticsRtn.setExamPassCount(situationPassCount);
		exam_VO4ExamStatisticsRtn.setExamNoPassCount(situationNoPassCount);
		exam_VO4ExamStatisticsRtn.setFastestFinishTime(exam_times.get("fastestTime"));
		exam_VO4ExamStatisticsRtn.setSlowestFinishTime(exam_times.get("slowestTime"));
		exam_VO4ExamStatisticsRtn.setAvarageFinishTime(exam_times.get("avarageTime"));
		exam_VO4ExamStatisticsRtn.setExamPassRate(passRate);
		exam_VO4ExamStatisticsRtn.setExamNoPassRate(Math.floor(((double)situationNoPassCount/(double)situationCount)*100));
		exam_VO4ExamStatisticsRtn.setHighestScoreScale(Math.floor((highestScore/examScore)*100));
		exam_VO4ExamStatisticsRtn.setLowestScoreScale(Math.floor((lowestScore/examScore)*100));
		exam_VO4ExamStatisticsRtn.setAvarageScoreScale(Math.floor((avarageScore/examScore)*100));
		exam_VO4ExamStatisticsRtn.setFastestFinishTimeScale(Math.floor(((double)exam_times.get("fastestTime")/(double)examTime)*100));
		exam_VO4ExamStatisticsRtn.setSlowestFinishTimeScale(Math.floor(((double)exam_times.get("slowestTime")/(double)examTime)*100));
		exam_VO4ExamStatisticsRtn.setAvarageFinishTimeScale(Math.floor(((double)exam_times.get("avarageTime")/(double)examTime)*100));
		
		exam_VO4ExamStatisticsRtn.setHighestScoreRank(getExamRank(exam_SituationDaoImpl.getMaxScore(), exam_id));
		exam_VO4ExamStatisticsRtn.setAvarageScoreRank(getExamRank(exam_SituationDaoImpl.getAvgScore(), exam_id));
		exam_VO4ExamStatisticsRtn.setExamTimeRank(getExamRank(exam_SituationDaoImpl.getExamTime(), exam_id));
		exam_VO4ExamStatisticsRtn.setPassScaleRank(getPassRateRank(exam_id));
		exam_VO4ExamStatisticsRtn.setFastestFinishRank(getTimeRank(exam_id).get("fastestRank"));
		exam_VO4ExamStatisticsRtn.setAvarageFinishRank(getTimeRank(exam_id).get("avgRank"));
		
		System.out.println("当前考试在所有考试中的最高分排名:"+getExamRank(exam_SituationDaoImpl.getMaxScore(), exam_id));
		System.out.println("当前考试在所有考试中的平均分排名:"+getExamRank(exam_SituationDaoImpl.getAvgScore(), exam_id));
		System.out.println("当前考试在所有考试中的考试次数分排名:"+getExamRank(exam_SituationDaoImpl.getExamTime(), exam_id));
		
		
		exam_VO4ExamStatisticsRtn.setExamInformation(exam);
		System.out.println(exam_VO4ExamStatisticsRtn);
		
		return exam_VO4ExamStatisticsRtn;
	}

	
	@Override
	public Map<String, Integer> parseTimeFromSituation(
			List<Situation> situations) {
		
		
		List<Integer> times = new ArrayList<Integer>();
		
		//1.获取所有记录的完成时间
		for(Situation situation:situations){
			
			String start_time = situation.getStartTime();
			String end_time = situation.getEndTime();
			
			try {
				Long date_start = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(start_time).getTime();
				Long date_end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(end_time).getTime();
				
				Integer time = (int) ((date_end-date_start)/1000/60);
				
				System.out.println("开始时间:"+date_start);
				System.out.println("结束时间:"+date_end);
				System.out.println("考试时间:"+(date_end-date_start)/1000/60);
				
				times.add(time);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//2.
		Integer fastestTime = 0;
		Integer slowestTime = 0;
		Integer totalTime = 0;
		Integer avarageTime = 0;
		
		for(Integer time:times){
			
			if(time<fastestTime){
				fastestTime=time;
			}
			
			if(time>slowestTime){
				slowestTime=time;
			}
			
			totalTime+=time;
			
		}
		if(situations.size()!=0){
			avarageTime = totalTime/situations.size();
		}else{
			avarageTime = 0;
		}
		
		Map<String,Integer> timeStatistics = new HashMap<String, Integer>();
		
		timeStatistics.put("fastestTime",fastestTime);
		timeStatistics.put("slowestTime",slowestTime);
		timeStatistics.put("avarageTime",avarageTime);
		
		return timeStatistics;
	}


	@Override
	public Map getStudentRecordService(
			Integer exam_id,Integer pageNum) {
		
		Exam exam = exam_ExamDaoImpl.queryExamById(exam_id);
		
		List<Exam_VO4StudentExamRecordRtn> records = new ArrayList<>();
		//对应考试记录
		List<Situation> situations = exam_SituationDaoImpl.querySituationByExamIdPagination(exam_id, pageNum);
		
		PageInfo<Situation> pageInfo =  new PageInfo<Situation>(situations);
		
		Double[] scores = new Double[situations.size()];
		Integer i=0;
		for(Situation s:situations){
			scores[i] = s.getExamScore();
			i+=1;
		}
		for(Situation s:situations){
			User user = exam_UserDaoImpl.queryUserById(s.getUserId());
			Exam_VO4StudentExamRecordRtn exam_VO4StudentExamRecordRtn = tranSituation2Exam_VO4StudentExamRecordRtn(s, exam, scores);
			records.add(exam_VO4StudentExamRecordRtn);
		}
		
		Map result = new HashMap<>();
		result.put("records",records);
		result.put("pageInfo",pageInfo);
		
		return result;
	}

	@Override
	public void getAllExamStatusCountService(HttpServletResponse response,Integer admin_id) {
		HashMap<String,Integer> countMap = new HashMap<>();
		Integer startCount = exam_ExamDaoImpl.countExamsByStatus("进行中", admin_id);
		Integer unstartCount = exam_ExamDaoImpl.countExamsByStatus("未开始", admin_id);
		Integer endCount = exam_ExamDaoImpl.countExamsByStatus("已结束", admin_id);
		Integer deleteCount = exam_ExamDaoImpl.countExamsByStatus("已删除", admin_id);
		countMap.put("startCount", startCount);
		countMap.put("unstartCount",unstartCount);
		countMap.put("endCount",endCount);
		countMap.put("deleteCount",deleteCount);
		
		JSONArray json = JSONArray.fromObject(countMap);
		System.out.println("各状态:"+json.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getExamScoreChartData(HttpServletResponse response,
			Integer exam_id) {
		
		Exam_VO4ExamStatisticsRtn exam_VO4ExamStatisticsRtn =  getExamStatisticsService(exam_id);
		
		Double avarageScore = exam_VO4ExamStatisticsRtn.getAvarageScore();
		List<Situation> situations = exam_SituationDaoImpl.querySituationsByExamId(exam_id);
		
		Integer higherCount = 0;
		Integer lowerCount = 0;
		for(Situation situation:situations){
			Double score = situation.getExamScore();
			if(score>avarageScore){
				higherCount++;
			}else{
				lowerCount++;
			}
		}
		List<Exam_VO4PieChartInfo> result = new ArrayList<Exam_VO4PieChartInfo>();
		result.add(new Exam_VO4PieChartInfo("高于平均分次数",higherCount));
		result.add(new Exam_VO4PieChartInfo("低于平均分次数",lowerCount));
		JSONArray json = JSONArray.fromObject(result);
		System.out.println("成绩情况:"+json);
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getExamTimeChartData(HttpServletResponse response,
			Integer exam_id) {
		
		List<Situation> situations = exam_SituationDaoImpl.querySituationsByExamId(exam_id);
		Integer avarageTime = parseTimeFromSituation(situations).get("avarageTime");
		
		Integer fasterCount = 0;
		Integer slowerCount = 0;
		for(Situation s:situations){
			Long date_start;
			try {
				date_start = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(s.getStartTime()).getTime();
				Long date_end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(s.getEndTime()).getTime();
				Integer time = (int) ((date_end-date_start)/1000/60);
				if(time<avarageTime){
					fasterCount++;
				}else{
					slowerCount++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Exam_VO4PieChartInfo> result = new ArrayList<Exam_VO4PieChartInfo>();
		result.add(new Exam_VO4PieChartInfo("快于平均时间",fasterCount));
		result.add(new Exam_VO4PieChartInfo("慢于平均时间",slowerCount));
		JSONArray json = JSONArray.fromObject(result);
		System.out.println("考试时间情况:"+json);
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getExamPassChartData(HttpServletResponse response,
			Integer exam_id) {
		
		Exam exam = exam_ExamDaoImpl.queryExamById(exam_id);
		
		//获取考试及格次数
		Integer situationPassCount = exam_SituationDaoImpl.queryPassSituaionCountByExamId(exam);
		//获取考试不及格次数
		Integer situationNoPassCount = exam_SituationDaoImpl.queryNoPassSituationCountByExamId(exam);
		
		List<Exam_VO4PieChartInfo> result = new ArrayList<Exam_VO4PieChartInfo>();
		result.add(new Exam_VO4PieChartInfo("及格数",situationPassCount));
		result.add(new Exam_VO4PieChartInfo("不及格数",situationNoPassCount));
		JSONArray json = JSONArray.fromObject(result);
		System.out.println("考试及格情况:"+json);
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
