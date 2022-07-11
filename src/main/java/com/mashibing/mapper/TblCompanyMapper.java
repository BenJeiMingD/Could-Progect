package com.mashibing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.bean.TblCompany;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */



public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    @Select("SELECT id,company_full_name FROM tbl_company")
    List<TblCompany> SelectCompany();
}
