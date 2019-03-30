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

    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();


}
