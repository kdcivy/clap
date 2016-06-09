package com.ktds.framework.sample.angular.form;

import java.util.HashMap;
import java.util.List;

public interface Angular_formDao {

    public List<Angular_formVO> select(Angular_formVO vo, HashMap param);
    

    public List<Angular_formVO> select(Angular_formVO vo);

    // insert
    public Integer insert(Angular_formVO vo);
    
    // insert
    public Integer insert(Angular_formVO vo, HashMap param);
    
    // update
    public Integer update(Angular_formVO vo);
    
    // update
    public Integer update(Angular_formVO vo, HashMap param);
    
    // delete
    public Integer delete(Angular_formVO vo);
    
}