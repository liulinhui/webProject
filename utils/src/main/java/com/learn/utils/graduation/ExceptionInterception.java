package com.learn.utils.graduation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;

/**
 * 统一异常处理类.
 */
@Component
public class ExceptionInterception implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionInterception.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        logger.error("Exception:" + e.getMessage(), e);
        e.printStackTrace();
        String stackTrace="";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            e.printStackTrace(pw);
            stackTrace = sw.toString();
        } finally {
            pw.close();
        }
        ModelMap model = new ModelMap();
        model.put("errorTrace",stackTrace.split("(Native Method)")[0]);

        String errorMsg = e.getMessage();

        if (e instanceof Exception || e instanceof NoSuchElementException) {
            return new ModelAndView("error.ftl",model);
        }
        
        return new ModelAndView("error.ftl",model);
    }
}
