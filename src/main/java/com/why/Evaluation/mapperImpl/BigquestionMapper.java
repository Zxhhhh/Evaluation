package com.why.Evaluation.mapperImpl;

import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.BigquestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BigquestionMapper {
    int countByExample(BigquestionExample example);

    int deleteByExample(BigquestionExample example);

    int deleteByPrimaryKey(Integer bigquestionId);

    int insert(Bigquestion record);

    int insertSelective(Bigquestion record);

    List<Bigquestion> selectByExample(BigquestionExample example);

    Bigquestion selectByPrimaryKey(Integer bigquestionId);

    int updateByExampleSelective(@Param("record") Bigquestion record, @Param("example") BigquestionExample example);

    int updateByExample(@Param("record") Bigquestion record, @Param("example") BigquestionExample example);

    int updateByPrimaryKeySelective(Bigquestion record);

    int updateByPrimaryKey(Bigquestion record);

    int selectMaxBigquestionN(Integer paper_id);
    
    int selectSumScore(Integer paper_id);
}