package com.hzy.modules.cxfWebService.service.impl;

import com.hzy.modules.cxfWebService.service.HelloService;
import org.springframework.stereotype.Component;
import javax.jws.WebService;
import java.util.Calendar;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/7 9:50
 * @Description version 1.0
 */

@WebService(serviceName = "HelloService",
        endpointInterface = "com.hzy.modules.cxfWebService.service.HelloService",
        targetNamespace = "http://service.cxfWebService.modules.hzy.com")
@Component("helloServiceImpl")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        return "[connect success, now time is " + Calendar.getInstance().getTime() +"] "+ userName;
    }


}
