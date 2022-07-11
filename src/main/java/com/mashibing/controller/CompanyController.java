package com.mashibing.controller;

import com.mashibing.bean.TblCompany;
import com.mashibing.result.R;
import com.mashibing.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CompanyController {
    @Resource
    private CompanyService companyService;
    @RequestMapping("/estate/selectCompany")
    public R SelectCompany(){
        List<TblCompany> selectlist = companyService.Selectlist();
        return new R(selectlist);
    }
}
