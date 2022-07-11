package com.mashibing.service.impl;

import com.mashibing.bean.TblCompany;
import com.mashibing.mapper.TblCompanyMapper;
import com.mashibing.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    TblCompanyMapper tblCompanyMapper;

    @Override
    public List<TblCompany> Selectlist() {
        return  tblCompanyMapper.SelectCompany();

    }
}
