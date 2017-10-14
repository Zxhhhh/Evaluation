package com.why.Evaluation.daoImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.why.Evaluation.dao.Exam_ExamDao;
import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.dto.ExamExample;
import com.why.Evaluation.dto.ExamExample.Criteria;
import com.why.Evaluation.mapperImpl.ExamMapper;
import com.why.Evaluation.utils.Exam_PaginationUtil;
import com.why.Evaluation.vo.Exam_VO4ExamAddInformationParam;

/**
 * 考试模块的Exam表Dao
 * @author K550J
 *
 */
@Repository
public class Exam_ExamDaoImpl implements Exam_ExamDao {
	
	@Resource
	private ExamMapper examMapper;

	@Override //通过考试状态获取考试(分页)
	public List<Exam> queryExamsByStatus_Pagination(String exam_status,
			Integer pageNum,Integer admin_id,Integer pageSize) {
		
		
		PageHelper.startPage(pageNum, Exam_PaginationUtil.EXAM_QUERY_SIZE,true);
		ExamExample examExample = new ExamExample();
		Criteria cri = examExample.createCriteria();
		cri.andExamStatusEqualTo(exam_status);
		cri.andAdminIdEqualTo(admin_id);
		
		List<Exam> results = examMapper.selectByExample(examExample);
		
		
		return results;
	}

	@Override //按考试状态获取部分考试的总数(按创建的管理员id查)
	public Integer countExamsByStatus(String exam_status,Integer admin_id) {
		
		ExamExample examExample = new ExamExample();
		Criteria cri = examExample.createCriteria();
		cri.andExamStatusEqualTo(exam_status);
		cri.andAdminIdEqualTo(admin_id);
		
		Integer count = examMapper.countByExample(examExample);
		
		return count;
	}
	
	@Override //按考试状态获取部分考试的总数
	public Integer countAllExamsByStatus(String exam_status) {
		
		ExamExample examExample = new ExamExample();
		Criteria cri = examExample.createCriteria();
		cri.andExamStatusEqualTo(exam_status);
		
		Integer count = examMapper.countByExample(examExample);
		return count;
	}

	@Override //按管理员id查询全部考试(分页）
	public List<Exam> queryAllExams_Pagination(Integer pageNum,Integer admin_id) {
		
		PageHelper.startPage(pageNum, Exam_PaginationUtil.EXAM_QUERY_SIZE);
		
		ExamExample examExample = new ExamExample();
		
		Criteria cri = examExample.createCriteria();
		
		cri.andAdminIdEqualTo(admin_id);
		
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		return exams;
	}

	@Override //按管理员id按年份查询考试(分页)
	public List<Exam> queryExamsByCreateYear_Pagination(Integer pageNum,String create_time,Integer admin_id) {

		PageHelper.startPage(pageNum, Exam_PaginationUtil.EXAM_QUERY_SIZE);
		
		ExamExample examExample = new ExamExample();
		
		Criteria cri = examExample.createCriteria();
		
		cri.andCreateTimeLike(create_time+"%");
		cri.andAdminIdEqualTo(admin_id);
		
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		for(Exam exam:exams){
			System.out.println(exam);
		}
		
		return exams;
	}
	


	@Override //按管理员id按年份按考试状态查询考试(分页)
	public List<Exam> queryExamsByCreateYearAndStatus_Pagination(
			Integer pageNum, String create_time, String exam_status,
			Integer admin_id) {
		
		PageHelper.startPage(pageNum, Exam_PaginationUtil.EXAM_QUERY_SIZE);
		
		ExamExample examExample = new ExamExample();
		
		Criteria cri = examExample.createCriteria();
		cri.andCreateTimeLike(create_time+"%");
		cri.andExamStatusEqualTo(exam_status);
		cri.andAdminIdEqualTo(admin_id);
		
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		return exams;
	}
	
	@Override //按考试进行时间段查询考试(分页)
	public List<Exam> queryExamsByDurationTime_Pagination(Integer pageNum,
			String start_time, String end_time, Integer admin_id) {
		
		return null;
	}


	@Override //判断考试是否已存在
	public boolean examExist(String examName,String examStartTime,String examEndTime) {
		
		ExamExample examExample = new ExamExample();
		
		//"与"条件2:考试时间段有重合
		Criteria cri_start_time = examExample.createCriteria();
		cri_start_time.andExamStartTimeBetween(examStartTime, examEndTime);
		cri_start_time.andExamNameEqualTo(examName);
		
		Criteria cri_end_time = examExample.createCriteria();
		cri_end_time.andExamEndTimeBetween(examStartTime, examEndTime);
		cri_end_time.andExamNameEqualTo(examName);
		
		examExample.or(cri_start_time);
		examExample.or(cri_end_time);
		
//		cri_time.andExamStartTimeBetween(examStartTime,examEndTime);
//		cri_time.andExamEndTimeBetween(examStartTime,examEndTime);
		
		System.out.println(examExample.getOrderByClause());
		
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		if(exams.size()==0){
			return false;
		}else{
			return true;
		}
		
	}

	@Override //插入考试，插入成功后返回考试id
	public Integer addExamInformation(Exam exam) {
		
		Integer exam_id= 0;
		
		examMapper.insert(exam);
		
		ExamExample examExample = new ExamExample();
		Criteria cri = examExample.createCriteria();
		
		cri.andExamNameEqualTo(exam.getExamName());
		cri.andExamStartTimeEqualTo(exam.getExamStartTime());
		cri.andExamEndTimeEqualTo(exam.getExamEndTime());
		
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		if(exams.size()!=0){
			exam_id = exams.get(0).getExamId();
		}
		
		return exam_id;
	}

	@Override
	public Exam queryExamByPaperId(Integer paper_id) {
		
		Exam exam = null;
		
		ExamExample examExample = new ExamExample();
		
		Criteria cri = examExample.createCriteria();
		
		cri.andPaparIdEqualTo(paper_id);
		
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		if(exams.size()!=0){
			exam = exams.get(0);
		}
		
		return exam;
	}

	@Override
	public Exam updateExamInformation(Exam exam) {
		
		Exam resultExam = null;
		
		if(exam!=null){
			
			//更新exam非空
			Integer result = examMapper.updateByPrimaryKeySelective(exam);
			
			if(result!=0){
				
				resultExam = examMapper.selectByPrimaryKey(exam.getExamId());
				
			}
			
		}
		
		return resultExam;
	}

	@Override
	public Exam queryExamById(Integer exam_id) {
		
		Exam exam = examMapper.selectByPrimaryKey(exam_id);
		
		return exam;
	}

	@Override
	public List<Exam> queryAllExams() {
		
		ExamExample examExample = new ExamExample();
		Criteria cri = examExample.createCriteria();
		List<Exam> exams = examMapper.selectByExample(examExample);
		
		return exams;
	}

}
