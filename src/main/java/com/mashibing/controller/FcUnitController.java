package com.mashibing.controller;


import com.mashibing.bean.FcUnit;
import com.mashibing.result.R;
import com.mashibing.service.FcUnitService;
import com.mashibing.vo.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 单元信息表 前端控制器
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@RestController
public class FcUnitController {
    @Autowired
    FcUnitService fcUnitService;
    @RequestMapping("estate/selectUnit")
    public R findUnit(@RequestBody UnitMessage[] unitMessages){
        List<FcUnit> allFcUnit = new ArrayList<>();
        for (UnitMessage message : unitMessages) {
            //将集合中的元素放到arraylist中（数组中）
            allFcUnit.addAll(fcUnitService.findUnit(message));
        }
        return new R(allFcUnit);
    }

    @RequestMapping("/estate/updateUnit")
    public R updateUnit(FcUnit fcUnit){
        fcUnitService.updateUnit(fcUnit);
        return new R("保存成功");
    }
}

