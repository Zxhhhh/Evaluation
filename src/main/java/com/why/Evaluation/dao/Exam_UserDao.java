package com.why.Evaluation.dao;

import java.util.List;

import com.why.Evaluation.dto.User;

public interface Exam_UserDao {
	
	/**
	 * 根据id查询用户
	 * @param user_id
	 * @return
	 */
	public User queryUserById(Integer user_id);
	
}
