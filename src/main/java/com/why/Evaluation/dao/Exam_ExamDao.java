package com.why.Evaluation.dao;

import java.util.List;
import java.util.Map;

import com.why.Evaluation.dto.Exam;
import com.why.Evaluation.vo.Exam_VO4ExamAddInformationParam;

public interface Exam_ExamDao {
	
	public Exam queryExamById(Integer exam_id);
	
	/**
	 * 获取所有考试
	 * @return
	 */
	public List<Exam> queryAllExams();
	
	/**
	 * 通过考试状态获取考试(分页)
	 * @param exam_status
	 * @param pageNum
	 * @param admin_id
	 * @return
	 */
	public List<Exam> queryExamsByStatus_Pagination(String exam_status,Integer pageNum,Integer admin_id,Integer pageSize);
	
	/**
	 * 按考试状态获取部分考试的总数(按创建的管理员id查)
	 * @param exam_status
	 * @param admin_id
	 * @return
	 */
	public Integer countExamsByStatus(String exam_status,Integer admin_id);
	
	/**
	 * 按考试状态获取部分考试的总数
	 * @param exam_status
	 * @param admin_id
	 * @return
	 */
	public Integer countAllExamsByStatus(String exam_status);
	
	/**
	 * 按管理员id查询全部考试(分页）
	 * @param pageNum
	 * @return
	 */
	public List<Exam> queryAllExams_Pagination(Integer pageNum,Integer admin_id);
	
	/**
	 * 按管理员id按年份查询考试(分页)
	 * @param pageNum
	 * @param create_time
	 * @return
	 */
	public List<Exam> queryExamsByCreateYear_Pagination(Integer pageNum,String create_time,Integer admin_id);
	
	/**
	 * 按管理员id按年份按考试状态查询考试(分页)
	 */
	public List<Exam> queryExamsByCreateYearAndStatus_Pagination(Integer pageNum,String create_time,String exam_status,Integer admin_id);
	
	/**
	 * 按考试进行时间段查询考试(分页)
	 * @param pageNum
	 * @param start_time
	 * @param end_time
	 * @param admin_id
	 * @return
	 */
	public List<Exam> queryExamsByDurationTime_Pagination(Integer pageNum,String start_time,String end_time,Integer admin_id);
	
	/**
	 * 判断考试是否已存在
	 * @param exam_name
	 * @return
	 */
	public boolean examExist(String examName,String examStartTime,String examEndTime);
	
	/**
	 * 插入考试，插入成功后返回考试id
	 * @param exam
	 * @return
	 */
	public Integer addExamInformation(Exam exam);
	
	/**
	 * 更新考试，更新成功后返回完整的考试对象
	 * @param exam
	 * @return
	 */
	public Exam updateExamInformation(Exam exam);
	
	/**
	 * 通过试卷id获取考试对象
	 * @param paper_id
	 * @return
	 */
	public Exam queryExamByPaperId(Integer paper_id);
}
