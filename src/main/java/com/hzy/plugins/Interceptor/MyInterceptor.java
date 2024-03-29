package com.hzy.plugins.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/4/15 20:42
 * @Description version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {

    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug(" -> -> -> preHandle ");
        String loginUser = (String) request.getSession().getAttribute("loginUser");
        System.out.println("loginUser:"+loginUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug(" -> -> ->postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug(" -> -> ->afterCompletion");
    }


}
