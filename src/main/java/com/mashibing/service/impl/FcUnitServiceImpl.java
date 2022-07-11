package com.mashibing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.FcUnit;
import com.mashibing.mapper.bean.FcUnitMapper;
import com.mashibing.service.FcUnitService;
import com.mashibing.vo.UnitMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 单元信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class FcUnitServiceImpl extends ServiceImpl<FcUnitMapper, FcUnit> implements FcUnitService {

    @Resource
    FcUnitMapper fcUnitMapper;
    @Override
    public List<FcUnit> findUnit(UnitMessage unitMessages) {
        List<FcUnit> fcUnits = new ArrayList<>();
        for (int i = 0; i < unitMessages.getUnitCount(); i++) {
            FcUnit fcUnit = new FcUnit();
            //从前端传入的数组unitMessages给信息调用
            fcUnit.setBuildingCode(unitMessages.getBuildingCode());
            //添加唯一标识fcEstate.getEstateCode(),通过了判空处理
            fcUnit.setUnitCode(unitMessages.getBuildingCode()+"U"+(i+1));
            fcUnit.setUnitName("第"+(i+1)+"单元");
            fcUnitMapper.insert(fcUnit);
            fcUnits.add(fcUnit);
        }
        return fcUnits;
    }
//选择楼宇
    @Override
    public List<FcUnit> selectUnitByBuildingCode(String buildingCode) {
        QueryWrapper<FcUnit> queryWrapper = new QueryWrapper<>();
       queryWrapper.eq("building_code", buildingCode);
        List<FcUnit> fcUnits = fcUnitMapper.selectList(queryWrapper);
        return fcUnits;
    }
    @Override
    public Integer updateUnit(FcUnit fcUnit) {
        return fcUnitMapper.insert(fcUnit);
    }

}
