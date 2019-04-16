package utils.SpringContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月01日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月01日 {填写修改说明}
 */
public class SpringContextUtil {

    static WebApplicationContext wac = null;
    {
        wac = ContextLoader.getCurrentWebApplicationContext();
    }

    public static Object getBean(String s){
        return wac.getBean(s);
    }

    public static Object getBean(Class clazz){
        return wac.getBean(clazz);
    }


    public static Object getBean(String s, Object... o){
        return wac.getBean(s, o);
    }


}
