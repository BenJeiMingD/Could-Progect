package com.mashibing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.ZhCustomer;
import com.mashibing.mapper.ZhCustomerMapper;
import com.mashibing.service.ZhCustomerService;
import com.mashibing.vo.CustomerMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 业主信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@Service
public class ZhCustomerServiceImpl extends ServiceImpl<ZhCustomerMapper, ZhCustomer> implements ZhCustomerService {
    @Resource
    ZhCustomerMapper zhCustomerMapper;
    @Override
    public Integer insertCustomer(ZhCustomer zhCustomer) {
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        //根据customerCode判断是否已经存在
        queryWrapper.eq("customer_code",zhCustomer.getCustomerCode());
        ZhCustomer customer = zhCustomerMapper.selectOne(queryWrapper);
        //返回null则是有效用户
        if (customer==null){
            return zhCustomerMapper.insert(zhCustomer);
        }
        return null;
    }

    @Override
    public List<ZhCustomer> selectCustomer() {
       List<ZhCustomer> customers= zhCustomerMapper.selectAll();
        return customers;
    }

    @Override
    public List<ZhCustomer> selectByCustomerByCustomerType(String customerType) {
        //当选择全部业主类型返回空字符串，返回到显示全部的方法中
        if (customerType.equals("")){
            return selectCustomer();
        }
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_type",customerType);
        List<ZhCustomer> zhCustomerList = zhCustomerMapper.selectList(queryWrapper);
        return zhCustomerList;
    }

    @Override
    public List<ZhCustomer> selectCustomerByColumnAndValue(String column, String value) {
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(column,value);
        List<ZhCustomer> customers = zhCustomerMapper.selectList(queryWrapper);
        return customers;
    }
    @Override
    public Integer UpdateCustomerStatusByCustomerCode(String customerCodes, String status) {
        Integer result = null;
        UpdateWrapper<ZhCustomer>updateWrapper = new UpdateWrapper<>();
        //如果customerCodes包含这个|就为true
        if (customerCodes.contains("|")){//这里多个业主时|作为 业主编码customerCodes的分割符
            //这里对|符号中的内容进行拆封
            String[] split = customerCodes.split("[|]");
            for (int i = 0; i < split.length; i++) {
                UpdateWrapper<ZhCustomer> updateWrapper1 = new UpdateWrapper<>();
                //当有多个业主进行启用或禁用，需要进行修改的status是唯一的，customer_code由多个|进行分割的
                updateWrapper1.set("customer_status", status).eq("customer_code", split[i]);
                result = zhCustomerMapper.update(null, updateWrapper1);
            }
        }
        else {
            //这里条件只有一个物业时
            //先是设置修改，再写对应的条件时
            updateWrapper.set("customer_status",status).eq("customer_code",customerCodes);
            result = zhCustomerMapper.update(null, updateWrapper);
        }
        return result;
    }

    @Override
    public List<ZhCustomer> findAll(CustomerMessage customerMessage) {
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        //如果客户录入的查询条件getColumns，getValue都满足进行查询--精准查询
        // 这里判空处理调用StringUtils方法
        if (!StringUtils.isEmpty(customerMessage.getColumns())&&!StringUtils.isEmpty(customerMessage.getValue())){
            queryWrapper.eq(customerMessage.getColumns(),customerMessage.getValue());
        }
        //模糊查寻
        if (!StringUtils.isEmpty(customerMessage.getCustomerType())){//这里判空处理调用StringUtils方法
            queryWrapper.eq("customer_type",customerMessage.getCustomerType());
        }
        List<ZhCustomer> customers= zhCustomerMapper.selectList(queryWrapper);
        return customers;
    }

    @Override
    public Integer insertAll(List<ZhCustomer> customers, String company) {
        Integer result = null;
        if (customers.size()>0){
            for (ZhCustomer customer : customers) {
                customer.setCompany(company);
                result = zhCustomerMapper.insert(customer);
            }
        }
        return result;
    }
}
