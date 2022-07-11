package com.mashibing.controller;


import com.mashibing.bean.FcBuilding;
import com.mashibing.bean.FcCell;
import com.mashibing.bean.FcEstate;
import com.mashibing.bean.FcUnit;
import com.mashibing.result.R;
import com.mashibing.service.FcBuildingService;
import com.mashibing.service.FcCellService;
import com.mashibing.service.FcEstateService;
import com.mashibing.service.FcUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 楼盘信息 前端控制器
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@RestController
public class FcEstateController {

    @Autowired
    FcEstateService fcEstateService;
    @Autowired
    FcUnitService fcUnitService;
    @Autowired
    FcCellService fcCellService;
    @Autowired
    FcBuildingService fcBuildingService;
//登录判空处理
    @RequestMapping("/estate/insertEstate")
    public R insertEstste(FcEstate fcEstate){
        Integer result = fcEstateService.insterEstate(fcEstate);
        if (result!=0){
            return new R(200,result.toString(),"插入成功");
        }
       else {
            return new R("失败");
        }
    }
    //维护房间信息选择楼宇
    @RequestMapping("estate/selectBuildingByEstate")
    public R selectBuildingByEstate(String estateCode){//房产编号
        List<FcBuilding> fcBuildings = fcBuildingService.selectBuildingByEstate(estateCode);
        return  new R (fcBuildings);
    }

    @RequestMapping("/estate/selectBuildingByEstateCode")
    public R selectBuildingByEstateCode(String estateCode){
        List<FcBuilding> fcBuildings = fcBuildingService.selectBuildingByEstateCode(estateCode);
        return new R(fcBuildings);
    }
    //选择楼宇
    @RequestMapping("/estate/selectUnitByBuildingCode")
    public R selectUnitByBuildingCode(String buildingCode){
        System.out.println(buildingCode);
        List<FcUnit> fcUnits = fcUnitService.selectUnitByBuildingCode(buildingCode);
        System.out.println(fcUnits);
        return new R(fcUnits);
    }

    @RequestMapping("/estate/selectCell")
    public R selectCell(String unitCode){
        List<FcCell> fcCells = fcCellService.selectCell(unitCode);
        return new R(fcCells);
    }
    @RequestMapping("/estate/selectEstate")
    public R selectEstate(String company){
        List<FcEstate> fcEstates = fcEstateService.selectEstate(company);
        return new R(fcEstates);
    }

    @RequestMapping("/estate/selectAllEstate")
    public R selectAllEstate(){
        List<FcEstate> fcEstates = fcEstateService.selectAllEstate();
        return new R(fcEstates);
    }

}

