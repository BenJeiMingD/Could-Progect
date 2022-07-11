package com.mashibing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.bean.FcUnit;
import com.mashibing.vo.UnitMessage;

import java.util.List;

/**
 * <p>
 * 单元信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public interface FcUnitService extends IService<FcUnit> {
    List<FcUnit> findUnit(UnitMessage unitMessages);
    List<FcUnit> selectUnitByBuildingCode(String buildingCode);
    Integer updateUnit(FcUnit fcUnit);
}
