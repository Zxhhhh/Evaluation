package com.why.Evaluation.mapperImpl;

import com.why.Evaluation.dto.Examresults;
import com.why.Evaluation.dto.ExamresultsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamresultsMapper {
    int countByExample(ExamresultsExample example);

    int deleteByExample(ExamresultsExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(Examresults record);

    int insertSelective(Examresults record);

    List<Examresults> selectByExample(ExamresultsExample example);

    Examresults selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") Examresults record, @Param("example") ExamresultsExample example);

    int updateByExample(@Param("record") Examresults record, @Param("example") ExamresultsExample example);

    int updateByPrimaryKeySelective(Examresults record);

    int updateByPrimaryKey(Examresults record);
}