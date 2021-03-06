package com.mashibing.service.bean;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblEmailSend;
import com.mashibing.mapper.bean.TblEmailSendMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 邮件发送 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class TblEmailSendServiceImpl extends ServiceImpl<TblEmailSendMapper, TblEmailSend> implements TblEmailSendService {

}
