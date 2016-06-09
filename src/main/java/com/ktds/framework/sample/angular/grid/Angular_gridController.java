package com.ktds.framework.sample.angular.grid;

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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktdsframework.foundation.exception.BizException;

@Controller
public class Angular_gridController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("angular_gridService")
    private Angular_gridService angular_gridService;
        
    // list form
    @RequestMapping(value = "/angular_grid/list", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView listForm(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		Angular_gridVO angular_gridVO) {

    	logger.info("/angular_grid/list listForm Call");
    	logger.debug("angular_gridVO={}", angular_gridVO);

        return new ModelAndView("/angular_grid/list");
    }
    
    // select list
    @RequestMapping(value = "/angular_grid/selectList", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody void selectList(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute Angular_gridVO angular_gridVO) throws BizException {

    	logger.info("/angular_grid/selectList selectList Call");
    	logger.debug("angular_gridVO={}", angular_gridVO);

    
        List<Angular_gridVO> list = angular_gridService.select(angular_gridVO);
        
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
    @RequestMapping(value = "/angular_grid/update", method = { RequestMethod.POST })
    public @ResponseBody void update(
    		HttpSession session,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute Angular_gridVO angular_gridVO,
    		@RequestParam String oper) throws BizException {

    	logger.info("/angular_grid/update update Call");
    	logger.debug("oper={}, angular_gridVO={}", oper, angular_gridVO);
		try {
	        int flag = 0;
	        if (oper.equals("add")) {
	            flag = angular_gridService.insert(angular_gridVO);
	        } else if (oper.equals("edit")) {
	        	flag = angular_gridService.update(angular_gridVO);
	        } else if (oper.equals("del")) {
				flag = angular_gridService.delete(angular_gridVO);
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
