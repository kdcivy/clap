package com.ktds.framework.sample.angular.form;

import java.util.HashMap;
import java.util.List;

import com.ktdsframework.core.mvc.BaseService;

public interface Angular_formService extends BaseService<Angular_formVO> {

    @Override
    public List<Angular_formVO> select(Angular_formVO vo);

    @Override
    public List<Angular_formVO> select(Angular_formVO vo, HashMap param);
		
    @Override
    public Integer insert(Angular_formVO vo);
    
    @Override
    public Integer insert(Angular_formVO vo, HashMap param);
    
    @Override
    public Integer update(Angular_formVO vo);
    
    @Override
    public Integer update(Angular_formVO vo, HashMap param);
    
    @Override
    public Integer delete(Angular_formVO vo);
    
}
