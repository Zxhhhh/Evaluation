package com.why.Evaluation.mapperImpl;

import com.why.Evaluation.dto.Pro;
import com.why.Evaluation.dto.ProExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProMapper {
    int countByExample(ProExample example);

    int deleteByExample(ProExample example);

    int deleteByPrimaryKey(Integer proId);

    int insert(Pro record);

    int insertSelective(Pro record);

    List<Pro> selectByExample(ProExample example);

    Pro selectByPrimaryKey(Integer proId);

    int updateByExampleSelective(@Param("record") Pro record, @Param("example") ProExample example);

    int updateByExample(@Param("record") Pro record, @Param("example") ProExample example);

    int updateByPrimaryKeySelective(Pro record);

    int updateByPrimaryKey(Pro record);
}