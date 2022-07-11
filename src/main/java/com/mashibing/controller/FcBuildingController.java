package com.mashibing.controller;


import com.mashibing.bean.FcBuilding;
import com.mashibing.result.R;
import com.mashibing.service.FcBuildingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 楼宇信息表 前端控制器
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@RestController
public class FcBuildingController {
    @Resource
    FcBuildingService fcBuildingService;
    @RequestMapping("estate/selectBuilding")
    public R selectBuilding(Integer buildingNumber,String estateCode){
        List<FcBuilding> fcBuildings = fcBuildingService.selectBuilding(buildingNumber, estateCode);
        return new R(fcBuildings);
    }

    @RequestMapping("/estate/updateBuilding")
    public R updateBuilding(FcBuilding fcBuilding){
        fcBuildingService.updateBuilding(fcBuilding);
        return new R("保存成功");
    }
}

