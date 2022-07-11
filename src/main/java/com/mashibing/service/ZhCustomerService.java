package com.mashibing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.bean.ZhCustomer;
import com.mashibing.vo.CustomerMessage;

import java.util.List;

/**
 * <p>
 * 业主信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
public interface ZhCustomerService extends IService<ZhCustomer> {

    /**
     * 新增住户信息
     * @param zhCustomer 传入住户信息表
     * @return 返回插入的影响行数
     */
    Integer insertCustomer(ZhCustomer zhCustomer);

    /**
     * 显示住户信息
     * @return 查询到的住户信息
     */
    List<ZhCustomer> selectCustomer();

    List<ZhCustomer> selectByCustomerByCustomerType(String customerType);

    List<ZhCustomer> selectCustomerByColumnAndValue(String column, String value);
    /**
     * 更具用户业主编码修改物业类型，返回结果为integer类型
     * @param customerCodes 业主编码
     * @param status 物业类型
     * @return 结果为integer类型
     */
    Integer UpdateCustomerStatusByCustomerCode(String customerCodes, String status);

    /**
     *
     * @param customerMessage 传入实体类数据的对象属性
     * @return 返回根据条件查询的结果集
     */
    List<ZhCustomer> findAll(CustomerMessage customerMessage);

    Integer insertAll(List<ZhCustomer> customers, String company);
}
