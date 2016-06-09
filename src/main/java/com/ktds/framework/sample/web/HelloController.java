package com.ktds.framework.sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
    	logger.debug("HelloController.index() is called.");
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/show",method = {RequestMethod.GET })
    public String show(Model model) {
    	logger.debug("HelloController.show() is called.");
    	model.addAttribute("message", "Greetings from Spring Boot!");
    	
        return "showMessage";
    }
}
