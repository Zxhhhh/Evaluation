package com.why.Evaluation.mapperImpl;

import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.dto.QuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionsMapper {
    int countByExample(QuestionsExample example);

    int deleteByExample(QuestionsExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(Questions record);

    int insertSelective(Questions record);

    List<Questions> selectByExample(QuestionsExample example);

    Questions selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByExample(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKey(Questions record);
}