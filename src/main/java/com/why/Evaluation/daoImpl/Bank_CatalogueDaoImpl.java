package com.why.Evaluation.daoImpl;

import com.why.Evaluation.dao.Bank_CatalogueDao;
import com.why.Evaluation.dto.Catalogue;
import com.why.Evaluation.mapperImpl.CatalogueMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Lhy on 2017/6/20 0020.
 */


@Repository
public class Bank_CatalogueDaoImpl implements Bank_CatalogueDao {
    @Resource
    CatalogueMapper  catalogueMapper;



    @Override
    public String queryCatalogNameById(Integer Id) {

        Catalogue catalogue =  catalogueMapper.selectByPrimaryKey(Id);


        return catalogue.getCatalogName();
    }
}
