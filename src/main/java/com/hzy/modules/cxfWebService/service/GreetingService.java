package com.hzy.modules.cxfWebService.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/6 18:29
 * @Description version 1.0
 */

@WebService(targetNamespace = "http://service.cxfWebService.modules.hzy.com")
public interface GreetingService {

    @WebMethod
    String greeting(@WebParam(name="username")String userName);


}
