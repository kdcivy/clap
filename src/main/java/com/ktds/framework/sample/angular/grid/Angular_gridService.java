package com.ktds.framework.sample.angular.grid;

import java.util.HashMap;
import java.util.List;

import com.ktdsframework.core.mvc.BaseService;

public interface Angular_gridService extends BaseService<Angular_gridVO> {

    @Override
    public List<Angular_gridVO> select(Angular_gridVO vo);

    @Override
    public List<Angular_gridVO> select(Angular_gridVO vo, HashMap param);
		
    @Override
    public Integer insert(Angular_gridVO vo);
    
    @Override
    public Integer insert(Angular_gridVO vo, HashMap param);
    
    @Override
    public Integer update(Angular_gridVO vo);
    
    @Override
    public Integer update(Angular_gridVO vo, HashMap param);
    
    @Override
    public Integer delete(Angular_gridVO vo);
    
}
