package com.ktds.framework.sample.angular.grid;

import java.util.HashMap;
import java.util.List;

public interface Angular_gridDao {

    public List<Angular_gridVO> select(Angular_gridVO vo, HashMap param);
    
    public List<Angular_gridVO> select(Angular_gridVO vo);

    // insert
    public Integer insert(Angular_gridVO vo);
    
    // insert
    public Integer insert(Angular_gridVO vo, HashMap param);
    
    // update
    public Integer update(Angular_gridVO vo);
    
    // update
    public Integer update(Angular_gridVO vo, HashMap param);
    
    // delete
    public Integer delete(Angular_gridVO vo);
    
}