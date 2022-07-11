package com.mashibing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblMyNote;
import com.mashibing.mapper.bean.TblMyNoteMapper;
import com.mashibing.service.TblMyNoteService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 我的记事本 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@Service
public class TblMyNoteServiceImpl extends ServiceImpl<TblMyNoteMapper, TblMyNote> implements TblMyNoteService {

}
