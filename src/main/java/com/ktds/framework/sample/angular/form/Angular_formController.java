package com.ktds.framework.sample.angular.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hornetq.utils.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktdsframework.foundation.exception.BizException;

@Controller
public class Angular_formController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("angular_formService")
    private Angular_formService angular_formService;
    
    // select list
    @RequestMapping(value = "/angular_form/selectList", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody void selectList(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute Angular_formVO angular_formVO) throws BizException {

    	logger.info("/angular_form/selectList selectList Call");
    	logger.debug("angular_formVO={}", angular_formVO);


        
        List<Angular_formVO> list = angular_formService.select(angular_formVO);
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
     
        modelMap.put("rows", list);						// rows = list data
     
        
        response.setContentType("application/json;charset=utf-8");

		try {
			mapper.writeValue(response.getWriter(), modelMap);
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
        
        logger.debug("After response");
    }

    // update/insert/delete
    @RequestMapping(value = "/angular_form/update", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody void update(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute Angular_formVO angular_formVO,
    		@RequestParam String oper) throws BizException {

    	logger.info("/angular_form/selectList selectList Call");
    	logger.debug("oper={}, angular_formVO={}", oper, angular_formVO);
		try {
	        int flag = 0;
	        if (oper.equals("add")) {
	 
	            flag = angular_formService.insert(angular_formVO);
	        } else if (oper.equals("edit")) {
	        	flag = angular_formService.update(angular_formVO);
	        } else if (oper.equals("del")) {
	        	flag = angular_formService.delete(angular_formVO);      
	        } else {
	        	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        	response.setContentType("application/json;charset=utf-8");
	        	response.getWriter().print("oper not found");
	        	return;
	        }
	
	        logger.debug("flag = {}", flag);
	        response.setContentType("application/json;charset=utf-8");
	        
	        
		    JSONObject json = new JSONObject();
		    
		    json.put("flag", flag);
		    

		    response.getWriter().print(json.toString());
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
    }
}
