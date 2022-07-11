package com.mashibing.controller;


import com.mashibing.bean.FcCell;
import com.mashibing.result.R;
import com.mashibing.service.FcCellService;
import com.mashibing.vo.FcCellMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 房间信息表 前端控制器
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@RestController
public class FcCellController {
    @Resource
    FcCellService fcCellService;
    @RequestMapping("/estate/insertCell")
    public R insertCell(@RequestBody FcCellMessage[] fcCellMessages){
        List<FcCell> fcCells = new ArrayList<>();
        for (FcCellMessage cellMessage : fcCellMessages) {
            fcCells.addAll(fcCellService.insertCell(cellMessage));
        }
        return new R(fcCells);
    }


}

