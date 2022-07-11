package com.mashibing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.bean.FcEstate;

import java.util.List;

/**
 * <p>
 * 楼盘信息 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public interface FcEstateMapper extends BaseMapper<FcEstate> {

    List<FcEstate> selectAllEstate();
}
