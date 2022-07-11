package com.mashibing.service.bean;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblEmployeeContact;
import com.mashibing.mapper.bean.TblEmployeeContactMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工通讯录 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@Service
public class TblEmployeeContactServiceImpl extends ServiceImpl<TblEmployeeContactMapper, TblEmployeeContact> implements TblEmployeeContactService {

}
