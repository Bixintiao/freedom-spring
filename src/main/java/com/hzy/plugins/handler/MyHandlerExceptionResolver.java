package com.hzy.plugins.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常统一处理
 * @Author hzy
 * @Date 2019/4/30 9:59
 * @Description
 */
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.info("catch one exception 【{}】 ...", e.getMessage());
        httpServletRequest.getSession().setAttribute("errMsg", e.getMessage());
        ModelAndView model = new ModelAndView();
        model.setViewName("error/error");
        return model;
    }

}
