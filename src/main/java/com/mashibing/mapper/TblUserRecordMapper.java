package com.mashibing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.bean.TblUserRecord;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {
TblUserRecord login(@Param("username") String username,@Param("password") String password);
}
