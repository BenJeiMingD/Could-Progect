package com.mashibing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.bean.ZhCustomer;

import java.util.List;

/**
 * <p>
 * 业主信息表 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
public interface ZhCustomerMapper extends BaseMapper<ZhCustomer> {


    List<ZhCustomer> selectAll();
}
