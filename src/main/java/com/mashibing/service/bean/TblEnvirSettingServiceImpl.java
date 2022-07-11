package com.mashibing.service.bean;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblEnvirSetting;
import com.mashibing.mapper.bean.TblEnvirSettingMapper;
import com.mashibing.service.TblEnvirSettingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 环境配置 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@Service
public class TblEnvirSettingServiceImpl extends ServiceImpl<TblEnvirSettingMapper, TblEnvirSetting> implements TblEnvirSettingService {

}
