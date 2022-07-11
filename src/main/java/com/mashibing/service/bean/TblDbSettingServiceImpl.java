package com.mashibing.service.bean;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblDbSetting;
import com.mashibing.mapper.bean.TblDbSettingMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库设置 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class TblDbSettingServiceImpl extends ServiceImpl<TblDbSettingMapper, TblDbSetting> implements TblDbSettingService {

}
