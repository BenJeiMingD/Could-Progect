package com.mashibing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.FcCell;
import com.mashibing.mapper.bean.FcCellMapper;
import com.mashibing.service.FcCellService;
import com.mashibing.vo.FcCellMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 房间信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class FcCellServiceImpl extends ServiceImpl<FcCellMapper, FcCell> implements FcCellService {
    @Resource
    FcCellMapper fcCellMapper;
    @Override
    public List<FcCell> insertCell(FcCellMessage fcCellMessage) {

        List<FcCell> fcCells = new ArrayList<>();
        for (int i = 0; i < fcCellMessage.getStopFloor(); i++) {
            for (int j = 0; j < fcCellMessage.getStopCellId(); j++) {
                FcCell fcCell = new FcCell();
                fcCell.setUnitCode(fcCellMessage.getUnitCode());//单元编号--从前端页面中获取
                //添加唯一标识
                fcCell.setCellCode("C"+(i+1)+"0"+(j+1));//房间编码
                fcCell.setCellName((i+1)+"0"+(j+1));//房间名称
                fcCell.setFloorNumber(fcCellMessage.getStopFloor());//楼层数--从前端页面中获取
                fcCellMapper.insert(fcCell);
                fcCells.add(fcCell);
            }
        }
        return fcCells;
    }

    @Override
    public List<FcCell> selectCell(String unitCode) {
        QueryWrapper<FcCell> wrapper = new QueryWrapper<>();
        wrapper.eq("unit_code",unitCode);
        List<FcCell> fcCells = fcCellMapper.selectList(wrapper);
        return fcCells;
    }
}
