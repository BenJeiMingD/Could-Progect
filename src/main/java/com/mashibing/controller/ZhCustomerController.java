package com.mashibing.controller;


import com.mashibing.bean.ZhCustomer;
import com.mashibing.result.R;
import com.mashibing.service.ZhCustomerService;
import com.mashibing.util.ExcelUtil;
import com.mashibing.vo.CustomerMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主信息表 前端控制器
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@RestController
@RequestMapping("/zhCustomer")
public class ZhCustomerController {
    @Resource
    ZhCustomerService zhCustomerService;

    /**
     * 新增业主信息
     *
     * @return 返回存储信息
     */
    @PostMapping("/insertCustomer")
    public R insertCustomer(ZhCustomer zhCustomer) {
        Integer result = zhCustomerService.insertCustomer(zhCustomer);
        if (result == 1) {
            return new R("保存成功");
        }
        return new R("保存失败，用户已存在");
    }

    /**
     * 查询业主信息
     *
     * @return 返回所存储的全部信息
     */
    @GetMapping("/selectCustomer")
    public R selectCustomer() {
        List<ZhCustomer> customers = zhCustomerService.selectCustomer();
        return new R(customers);
    }

    /**
     * 对业主信息的搜索方式的整合
     * 传入参数==构建前端需要的实体类
     *
     * @return 一个查询的结果集对象
     */
    @PostMapping("selectCustomer")
    //当从实体类中，map中获取对象属性，必须使用RequestBody注解
    public R Customer(@RequestBody CustomerMessage customerMessage) {
        List<ZhCustomer> customers = zhCustomerService.findAll(customerMessage);
        return new R(customers);
    }

    @PostMapping("/selectCustomerByColumnAndValue")
    public R selectCustomerByColumnAndValue(@RequestParam("column") String column, @RequestParam("value") String value) {
        List<ZhCustomer> customers = zhCustomerService.selectCustomerByColumnAndValue(column, value);
        return new R(customers);
    }
    @PostMapping("/selectByCustomerByCustomerType")
    public R selectByCustomerByCustomerType(String customerType) {
        List<ZhCustomer> customers = zhCustomerService.selectByCustomerByCustomerType(customerType);
        return new R(customers);
    }

    /**
     * 根据前端传递的业主编码信息来修改业主状态
     * customerCodes 此参数为业主编码，如果出现多个业主编码，会通过"|"进行分割
     * status 状态：1开启 0禁用
     *
     * @return 结果为integer类型
     */
    @PostMapping("UpdateCustomerStatusByCustomerCode")
    public R UpdateCustomerStatusByCustomerCode(@RequestBody Map map) {
        String customerCodes = (String) map.get("customerCodes");
        String status = (String) map.get("status");
        Integer result = zhCustomerService.UpdateCustomerStatusByCustomerCode(customerCodes, status);
        if (result != null) {
            return new R("设置成功");
        }
        return new R("设置失败");
    }

    /**
     * 根据前端传递的Excel表格文件和对应公司信息，解析出业主信息数据，存入到数据库中
     * @param file    Excel文件（固定格式）
     * @param company 对应公司编号
     * @return 是否新增成功
     */
    @PostMapping("/uploadExcel")
    public R uploadExcel(MultipartFile file, String company) {
        Integer result = null;
        System.out.println("uploadExcel");
        if (file != null && file.getSize() > 0) {
            try {
                // 调用readExcel方法来进行解析Excel
                //Integer insertAll(List<ZhCustomer> customers,String company);接口层写这个实现方法
                List<ZhCustomer> customers = ExcelUtil.readExcel((FileInputStream) file.getInputStream(), ZhCustomer.class);
                //当文件上传excel次数并没有存储到数据库
                result = zhCustomerService.insertAll(customers,company);
                for (ZhCustomer customer : customers) {
                    System.out.println(customer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new R(result);
    }
}

