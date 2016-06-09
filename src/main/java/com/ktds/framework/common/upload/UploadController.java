package com.ktds.framework.common.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.hornetq.utils.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsframework.foundation.exception.BizException;
@Controller
public class UploadController {
	protected final Logger logger =  LoggerFactory.getLogger(UploadController.class);
	
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/upload_file")
    public void upload(@RequestParam("file") MultipartFile file, @RequestParam("username") String username,HttpServletResponse response ) throws IOException, BizException {

        
		logger.info("File receive  : {} username :  {}", file.getOriginalFilename(), username);
        file.transferTo(new File("/"+file.getOriginalFilename()));

        response.setContentType("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
		try {
			 
			json.put("flag", 1);
			response.getWriter().print(json.toString());   
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
        
        //System.out.println(String.format("receive %s from %s", file.getOriginalFilename(), username));
    }


	
}
