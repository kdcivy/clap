package com.ktds.framework.common.errorMgmt;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class BootErrorController implements ErrorController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private final ErrorAttributes errorAttributes;

	@Autowired
	public BootErrorController(ErrorAttributes errorAttributes){
		this.errorAttributes = errorAttributes;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	@RequestMapping(produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("====================== BootErrorController errorHtml Start ======================");
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request,false);
		
		for(Entry<String, Object> entry : model.entrySet()){
			logger.debug("key=" + entry.getKey() + ",value=" + entry.getValue().toString());
		}
		logger.debug("====================== BootErrorController errorHtml End ======================");
		
		return new ModelAndView("error", model);
	}
	
	@RequestMapping(produces = "application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		logger.debug("====================== BootErrorController error Start ======================");
		Map<String, Object> body = getErrorAttributes(request,false);
		HttpStatus status = getStatus(request);
		
		for(Entry<String, Object> entry : body.entrySet()){
			logger.debug("key=" + entry.getKey() + ",value=" + entry.getValue().toString());
		}
		logger.debug("====================== BootErrorController error End ======================");
		
		return new ResponseEntity<Map<String, Object>>(body, status);
	}
	
/*	@RequestMapping(value="/error",method = RequestMethod.GET, produces = { "application/json", "text/html" })
	public Map<String, Object> error(HttpServletRequest aRequest){
		logger.debug("====================== BootErrorController error Start ======================");
		//Map<String, Object> body = getErrorAttributes(aRequest,getTraceParameter(aRequest));
		Map<String, Object> body = getErrorAttributes(aRequest,false);
		
		// delete Stack Trace print
		//logger.debug(body.remove(body.get("trace")).toString() );
		for(Entry<String, Object> entry : body.entrySet()){
			logger.debug("key=" + entry.getKey() + ",value=" + entry.getValue().toString());
		}
		logger.debug("====================== BootErrorController error End ======================");
		
		return body;
	}
*/
/*	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}*/

	private Map<String, Object> getErrorAttributes(HttpServletRequest aRequest, boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);
		return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
	}
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}
		catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
