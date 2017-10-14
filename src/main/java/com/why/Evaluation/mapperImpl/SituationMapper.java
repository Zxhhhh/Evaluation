package com.why.Evaluation.mapperImpl;

import com.why.Evaluation.dto.Situation;
import com.why.Evaluation.dto.SituationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SituationMapper {
    int countByExample(SituationExample example);

    int deleteByExample(SituationExample example);

    int deleteByPrimaryKey(Integer msgId);

    int insert(Situation record);

    int insertSelective(Situation record);

    List<Situation> selectByExample(SituationExample example);

    Situation selectByPrimaryKey(Integer msgId);

    int updateByExampleSelective(@Param("record") Situation record, @Param("example") SituationExample example);

    int updateByExample(@Param("record") Situation record, @Param("example") SituationExample example);

    int updateByPrimaryKeySelective(Situation record);

    int updateByPrimaryKey(Situation record);
    
    double queryAvarageScoreByExamId(Integer exam_id);
    
    double queryHightestScoreByExamId(Integer exam_id);
    
    double queryLowestScoreByExamId(Integer exam_id);
    
    List<Situation> queryStudentCountByExamId(Integer exam_id);
    
    List<Map> maxScore();
    
    List<Map> avgScore();
    
    List<Map> examTime();
    
}