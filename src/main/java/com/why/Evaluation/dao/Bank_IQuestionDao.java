package com.why.Evaluation.dao;

import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.vo.VO4QuestionUpdateParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Lhy on 2017/6/4 0004.
 */
public interface Bank_IQuestionDao {
    Map<String, Object> queryAllQuestion(Integer pageNum);

    Map<String, Object> queryQuestionsByKey(Map<String,Object> map);
    String insertQuestion(Questions question);
    Integer deleteByIds(Integer[] ids);
    Questions queryById(Integer Id);
    String UpdateQuestion(Questions question);
}
