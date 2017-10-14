package com.why.Evaluation.serviceImpl;

import com.why.Evaluation.dao.Bank_CatalogueDao;
import com.why.Evaluation.service.Bank_CatalogueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Lhy on 2017/6/20 0020.
 */
@Service
public class Bank_CatalogueServiceImpl implements Bank_CatalogueService {
        @Resource
    private Bank_CatalogueDao bank_catalogueDao;

    @Override
    public String queryCatalogNameById(Integer Id) {

      return bank_catalogueDao.queryCatalogNameById(Id);
    }
}
