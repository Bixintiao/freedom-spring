package utils.Spring;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/4/25 20:02
 * @Description version 1.0
 * 不需要spring 注入获取 applicationContext
 */
public class SpringUtil {

    private static WebApplicationContext applicationContext = null;

    public static WebApplicationContext getApplicationContext(){
        if (applicationContext == null)
            applicationContext = ContextLoader.getCurrentWebApplicationContext();
        return applicationContext;
    }

    public static Object getBean(String s){
        return getApplicationContext().getBean(s);
    }

    public static Object getBean(String s, Object... obj){
        return getApplicationContext().getBean(s, obj);
    }

    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String s, Class<T> clazz){
        return getApplicationContext().getBean(s, clazz);
    }


}
