package com.mashibing.service.bean;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblCommonMessage;
import com.mashibing.mapper.bean.TblCommonMessageMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 常用短信 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class TblCommonMessageServiceImpl extends ServiceImpl<TblCommonMessageMapper, TblCommonMessage> implements TblCommonMessageService {

}
