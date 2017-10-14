package com.why.Evaluation.mapperImpl;

import com.why.Evaluation.dto.Catalogue;
import com.why.Evaluation.dto.CatalogueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatalogueMapper {
    int countByExample(CatalogueExample example);

    int deleteByExample(CatalogueExample example);

    int deleteByPrimaryKey(Integer catalogId);

    int insert(Catalogue record);

    int insertSelective(Catalogue record);

    List<Catalogue> selectByExample(CatalogueExample example);

    Catalogue selectByPrimaryKey(Integer catalogId);

    int updateByExampleSelective(@Param("record") Catalogue record, @Param("example") CatalogueExample example);

    int updateByExample(@Param("record") Catalogue record, @Param("example") CatalogueExample example);

    int updateByPrimaryKeySelective(Catalogue record);

    int updateByPrimaryKey(Catalogue record);
}