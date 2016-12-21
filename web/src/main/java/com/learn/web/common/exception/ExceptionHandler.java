package com.learn.web.common.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;
import org.apache.commons.lang.exception.ExceptionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.common.net.InetAddresses;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linkage on 2016-12-20.
 */
@Component
public class ExceptionHandler extends HandlerExceptionResolverComposite {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception exception) {
        ModelMap model=new ModelMap();
        model.put("ex", exception);
        model.put("info",ExceptionUtils.getFullStackTrace(exception));
        if (exception instanceof BusinessException) {
            return new ModelAndView("404.ftl", model);
        } else if (exception instanceof ParameterException) {
            return new ModelAndView("404.ftl", model);
        } else {
            return new ModelAndView("404.ftl", model);
        }
    }
}
