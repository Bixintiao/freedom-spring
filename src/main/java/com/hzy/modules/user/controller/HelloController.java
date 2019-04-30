package com.hzy.modules.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzy.modules.Constants;
import com.hzy.modules.user.service.UserService;
import com.hzy.plugins.springContext.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import utils.Spring.SpringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年11月23日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年11月23日 {填写修改说明}
 */

@Controller
public class HelloController {

    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    /**
     * @return
     * http://localhost:9099/hello.d
     */
    @RequestMapping("hello")
    public String theDoor(){
        log.info(" info msg");
        System.out.println("***************  theDoor  ***************");
        return "index";
    }


    /**
     * @return
     */
    @RequestMapping("getResponse")
    @ResponseBody
    public Object getResponse(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constants.RESULT.MESSAGE,"response message");
        jsonObject.put(Constants.RESULT.SUCCESS,true);
        return jsonObject;
    }


    /**
     * 定时任务 demo
     */
    @Scheduled(cron = "0 0/9 * * * ? ")
    public void scheduledDemo(){
        System.out.println("********************   begin scheduledDemo  ********************");
        System.out.println("scheduledDemo: I'm start di di di . . .");
        System.out.println("********************   end scheduledDemo  ********************");
    }



    /**
     * get beans
     * @return
     */
    @RequestMapping("beans")
    @ResponseBody
    public Object getAllBeans(@RequestParam(required = false) String name){
        System.out.println("getAllBeans -> -> -> -> name:"+name);
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        StringBuilder sb = new StringBuilder();
        System.out.println("all bean names: ->");
        Arrays.stream(wac.getBeanDefinitionNames()).forEach(x->{
            System.out.println(x);
            sb.append(x+"<br/>");
        });
        return sb;
    }


    /**
     * http://localhost:9099/beans.d
     * @param name
     * @return
     */
    @RequestMapping("beans/{name}")
    @ResponseBody
    public Object getBean(@PathVariable(required = false) String name){
        System.out.println(SpringContextUtil.getBean(name));
        System.out.println(SpringUtil.getBean(name));
        return true;
    }


    @ResponseBody
    @RequestMapping("/exec")
    public String goException(){
        int a = 1/0;
        return "success";
    }


}
