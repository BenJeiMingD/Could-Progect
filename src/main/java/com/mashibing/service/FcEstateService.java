package com.mashibing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.bean.FcEstate;

import java.util.List;

/**
 * <p>
 * 楼盘信息 服务类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public interface FcEstateService extends IService<FcEstate> {
   List<FcEstate> selectBuildingByEstate(String estateCode);
   List<FcEstate> selectEstate(String company);
   List<FcEstate> selectAllEstate();
   Integer insterEstate(FcEstate fcEstate);
}
