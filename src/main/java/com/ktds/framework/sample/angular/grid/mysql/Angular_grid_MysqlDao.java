package com.ktds.framework.sample.angular.grid.mysql;

import java.util.HashMap;
import java.util.List;

public interface Angular_grid_MysqlDao {

    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo, HashMap param);
    
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo);

    // insert
    public Integer insert(Angular_grid_MysqlVO vo);
    
    // insert
    public Integer insert(Angular_grid_MysqlVO vo, HashMap param);
}