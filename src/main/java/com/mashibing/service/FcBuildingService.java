package com.mashibing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.bean.FcBuilding;

import java.util.List;

/**
 * <p>
 * 楼宇信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public interface FcBuildingService extends IService<FcBuilding> {
    List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode);

    Integer updateBuilding(FcBuilding fcBuilding);

    List<FcBuilding> selectBuildingByEstate(String estateCode);

    List<FcBuilding> selectBuildingByEstateCode(String estateCode);
}
