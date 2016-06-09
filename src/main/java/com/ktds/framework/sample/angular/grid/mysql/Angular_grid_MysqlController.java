package com.ktds.framework.sample.angular.grid.mysql;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktdsframework.foundation.exception.BizException;

@Controller
public class Angular_grid_MysqlController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("angular_grid_mysqlService")
    private Angular_grid_MysqlService angular_grid_mysqlService;
        
    // list form
    @RequestMapping(value = "/angular_grid_mysql/list", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView listForm(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		Angular_grid_MysqlVO angular_grid_mysqlVO) {

    	logger.info("/angular_grid_mysql/list listForm Call");
    	logger.debug("angular_grid_mysqlVO={}", angular_grid_mysqlVO);

        return new ModelAndView("/angular_grid_mysql/list");
    }
    
    // select list
    @RequestMapping(value = "/angular_grid_mysql/selectList", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody void selectList(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute Angular_grid_MysqlVO angular_grid_mysqlVO) throws BizException {

    	logger.info("/angular_grid_mysql/selectList selectList Call");
    	logger.debug("angular_grid_mysqlVO={}", angular_grid_mysqlVO);

    
        List<Angular_grid_MysqlVO> list = angular_grid_mysqlService.select(angular_grid_mysqlVO);
        
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

    // insert
    @RequestMapping(value = "/angular_grid_mysql/insert", method = { RequestMethod.POST })
    public @ResponseBody void insert(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute Angular_grid_MysqlVO angular_grid_mysqlVO) throws BizException {

    	logger.info("/angular_grid_mysql/insert insert Call");
    	logger.debug("oper={}, angular_grid_mysqlVO={}", angular_grid_mysqlVO);
		try {
	        int flag = angular_grid_mysqlService.insert(angular_grid_mysqlVO);
	
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
