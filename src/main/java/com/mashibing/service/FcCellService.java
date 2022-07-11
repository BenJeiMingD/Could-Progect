package com.mashibing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.bean.FcCell;
import com.mashibing.vo.FcCellMessage;

import java.util.List;

/**
 * <p>
 * 房间信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public interface FcCellService extends IService<FcCell> {
    List<FcCell> insertCell(FcCellMessage fcCellMessage);

    List<FcCell> selectCell(String unitCode);
}
