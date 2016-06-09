package com.ktds.framework.common.errorMgmt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	//public static final String DEFAULT_ERROR_VIEW = "/error";
	private final ErrorAttributes errorAttributes;
	
//	@Autowired
//    private GlobalErrorMgmtService globalErrorMgmtService;
    
	@Autowired
	public GlobalDefaultExceptionHandler(ErrorAttributes errorAttributes){
		this.errorAttributes = errorAttributes;
	}
	
    @ExceptionHandler(value = {Exception.class, RuntimeException.class, SQLException.class, IOException.class})
    @ResponseStatus(value = HttpStatus.OK, reason="Security")
    public Map<String, Object> defaultErrorHandler(HttpServletRequest req, Exception ex) {
    	logger.info("====================== GlobalDefaultExceptionHandler Start ======================");

        if (ex != null) {
        	//logger.error(ex.getMessage());
        	logger.error("defaultErrorHandler error",ex);
        	
            // 에러 로깅
/*            StackTraceElement[] ste = ex.getStackTrace();
            String occur = ste[0].toString();

            occur = occur.replace(occur.substring(occur.indexOf("("), occur.indexOf(")") + 1), "");
            
            StringTokenizer st = new StringTokenizer(occur, ".");
            
            StringBuffer occurClass = new StringBuffer();
            for (int i = 0; i <= st.countTokens(); i++)
                occurClass.append(st.nextElement()).append(".");
            
            String occurMethod = "";
            if (st.hasMoreElements()) {
            	occurMethod = st.nextElement().toString();
            }
            
            ErrorMgmtVO errorLog = new ErrorMgmtVO();
            
            String errorName = ex.getClass().getSimpleName();
            String errorType = "Servlet";
            String errorMessage = "";
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(out);
            ex.printStackTrace(printStream);
            errorMessage = out.toString();
            
            errorLog.setErrorCode("500");
            errorLog.setErrorName(errorName);
            errorLog.setErrorType(errorType);
            errorLog.setOccurClass(occurClass.toString());
            errorLog.setOccurMethod(occurMethod);
            errorLog.setErrorMessage(errorMessage);
            
            globalErrorMgmtService.insert(errorLog);*/
        }
    
    	RequestAttributes requestAttributes = new ServletRequestAttributes(req);
    	logger.info("====================== GlobalDefaultExceptionHandler End ======================");
    	
    	return errorAttributes.getErrorAttributes(requestAttributes, false);
    }
}
