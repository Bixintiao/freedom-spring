package com.hzy.plugins.springContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月01日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月01日 {填写修改说明}
 * 需要spring 注入获取 applicationContext
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringContextUtil.applicationContext == null) {
            SpringContextUtil.applicationContext = applicationContext;
        }
    }

    public static Object getBean(String s){
        return applicationContext.getBean(s);
    }

    public static Object getBean(String s, Object... obj){
        return applicationContext.getBean(s, obj);
    }

    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String s, Class<T> clazz){
        return applicationContext.getBean(s, clazz);
    }

}
