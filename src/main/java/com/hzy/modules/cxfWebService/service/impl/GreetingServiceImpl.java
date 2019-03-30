package com.hzy.modules.cxfWebService.service.impl;

import com.hzy.modules.cxfWebService.service.GreetingService;
import javax.jws.WebService;
import java.util.Calendar;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/6 18:31
 * @Description version 1.0
 */

@WebService(serviceName = "GreetingService",
        endpointInterface = "com.hzy.modules.cxfWebService.service.GreetingService",
        targetNamespace = "http://service.cxfWebService.modules.hzy.com")
public class GreetingServiceImpl implements GreetingService {

    /**
     * 配置 web.xml spring-cxf
     * 访问 http://localhost:9099/项目名/services/GreetingService?wsdl
     * http://localhost:9099/services/Greeting?wsdl
     * @param userName
     * @return
     */
    @Override
    public String greeting(String userName) {
        return "Hello " + userName + ", currentTime is " + Calendar.getInstance().getTime();
    }
}
