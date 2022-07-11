package com.mashibing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.FcBuilding;
import com.mashibing.mapper.bean.FcBuildingMapper;
import com.mashibing.service.FcBuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 楼宇信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class FcBuildingServiceImpl extends ServiceImpl<FcBuildingMapper, FcBuilding> implements FcBuildingService {
    @Resource
    FcBuildingMapper fcBuildingMapper;

    @Override
    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode) {
        //先创建一个arraysList集合
        List<FcBuilding> fcBuildings = new ArrayList<>();
        //for循环，调用set方法修改属性数据
        for (int i = 0; i < buildingNumber; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode(estateCode+"B"+(i+1));
            fcBuilding.setBuildingName("第"+(i+1)+"号");
            fcBuilding.setEstateCode(estateCode);
            //通过循环向表中插入数据。先把数据通过实体类对象调用set方法为其设值，然后调用mapper的插入方法，把实体类对象传入
            fcBuildingMapper.insert(fcBuilding);
            //把前端所需的字段装入集合，返回回显
            fcBuildings.add(fcBuilding);
        }


        return fcBuildings;
    }
    /**
     * updateBuilding 方法名，实现用户数据插入
     * @param fcBuilding 前端传的对象数据
     * @return 返回一个数据类型
     */
    @Override
    public Integer updateBuilding(FcBuilding fcBuilding) {
        Integer insert = fcBuildingMapper.insert(fcBuilding);
        return insert;
    }
    @Override
    public List<FcBuilding> selectBuildingByEstate(String estateCode) {
        QueryWrapper<FcBuilding> wrapper = new QueryWrapper<>();
        wrapper.eq("estate_code",estateCode);
        wrapper.select("building_name","building_code");
        List<FcBuilding> fcBuildings = fcBuildingMapper.selectList(wrapper);
        return fcBuildings;
    }

    @Override
    public List<FcBuilding> selectBuildingByEstateCode(String estateCode) {
        QueryWrapper<FcBuilding> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("estate_code",estateCode);
        List<FcBuilding> fcBuildings = fcBuildingMapper.selectList(queryWrapper);
        return fcBuildings;
    }
}
