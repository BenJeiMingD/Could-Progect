package com.mashibing;

import com.mashibing.bean.FcUnit;
import com.mashibing.service.FcUnitService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CloudProgramApplicationTests {
    @Resource
    FcUnitService fcUnitService;
    @Test
    void contextLoads(String buildingCode) {
        buildingCode = "7B2";
        List<FcUnit> fcUnits = fcUnitService.selectUnitByBuildingCode(buildingCode);
        System.out.println(fcUnits);
    }
}
