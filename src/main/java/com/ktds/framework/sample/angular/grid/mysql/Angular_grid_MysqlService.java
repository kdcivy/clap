package com.ktds.framework.sample.angular.grid.mysql;

import java.util.HashMap;
import java.util.List;

import com.ktdsframework.core.mvc.BaseService;

public interface Angular_grid_MysqlService extends BaseService<Angular_grid_MysqlVO> {

    @Override
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo);

    @Override
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo, HashMap param);
		
    @Override
    public Integer insert(Angular_grid_MysqlVO vo);
    
    @Override
    public Integer insert(Angular_grid_MysqlVO vo, HashMap param);
}
