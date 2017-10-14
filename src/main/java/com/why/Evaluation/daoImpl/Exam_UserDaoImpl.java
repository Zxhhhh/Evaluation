package com.why.Evaluation.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.why.Evaluation.dao.Exam_UserDao;
import com.why.Evaluation.dto.User;
import com.why.Evaluation.dto.UserExample;
import com.why.Evaluation.dto.UserExample.Criteria;
import com.why.Evaluation.mapperImpl.UserMapper;

@Repository
public class Exam_UserDaoImpl implements Exam_UserDao {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User queryUserById(Integer user_id) {
		
		User user = userMapper.selectByPrimaryKey(user_id);
		
		return user;
	}


}
