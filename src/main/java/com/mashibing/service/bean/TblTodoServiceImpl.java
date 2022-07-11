package com.mashibing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.TblTodo;
import com.mashibing.mapper.bean.TblTodoMapper;
import com.mashibing.service.TblTodoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author lian
 * @since 2022-07-05
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
