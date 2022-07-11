package com.mashibing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.FcEstate;
import com.mashibing.mapper.FcEstateMapper;
import com.mashibing.service.FcEstateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 楼盘信息 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
@Service
public class FcEstateServiceImpl extends ServiceImpl<FcEstateMapper, FcEstate> implements FcEstateService {

    @Resource
    private FcEstateMapper fcEstateMapper;

    @Override

    public List<FcEstate> selectBuildingByEstate(String estateCode) {
        QueryWrapper<FcEstate> wrapper = new QueryWrapper<>();
        QueryWrapper<FcEstate> estate_code = wrapper.eq("estate_code", estateCode);
        List<FcEstate> fcEstates = fcEstateMapper.selectList(estate_code);
        return fcEstates;
    }

    @Override
    public List<FcEstate> selectEstate(String company) {
        QueryWrapper<FcEstate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company",company);
        List<FcEstate> fcEstates = fcEstateMapper.selectList(queryWrapper);
        return fcEstates;
    }

    @Override
    public List<FcEstate> selectAllEstate() {
        List<FcEstate> fcEstates = fcEstateMapper.selectAllEstate();
        return fcEstates;
    }

    @Override
    public Integer insterEstate(FcEstate fcEstate) {
        Integer result=0;
        //QueryWrapper<>()的对象，调用eq方法，传入从前端获取的字段进行查询
        QueryWrapper<FcEstate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
        //调用selectone方法把字段传入，返回实体类对象
        FcEstate selectOne = fcEstateMapper.selectOne(queryWrapper);
        if (selectOne==null){
            result = fcEstateMapper.insert(fcEstate);
            return result;
        }
        return result;
    }
}
