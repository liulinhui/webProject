package com.learn.web.common.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linkage on 2016-12-20.
 */
@Component
public class ExceptionHandler extends HandlerExceptionResolverComposite {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelMap model=new ModelMap();
        model.put("ex", ex);
        // 根据不同错误转向不同页面
        if (ex instanceof BusinessException) {
            return new ModelAndView("404.ftl", model);
        } else if (ex instanceof ParameterException) {
            return new ModelAndView("404.ftl", model);
        } else {
            return new ModelAndView("404.ftl", model);
        }
    }
}
