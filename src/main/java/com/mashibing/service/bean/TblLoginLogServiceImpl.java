package com.mashibing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblLoginLog;
import com.mashibing.mapper.bean.TblLoginLogMapper;
import com.mashibing.service.TblLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录日志 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@Service
public class TblLoginLogServiceImpl extends ServiceImpl<TblLoginLogMapper, TblLoginLog> implements TblLoginLogService {

}
