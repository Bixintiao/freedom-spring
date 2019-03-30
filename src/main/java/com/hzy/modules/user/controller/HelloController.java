package com.hzy.modules.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzy.modules.Constants;
import com.hzy.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

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


    /**
     * @return
     */
    @RequestMapping("hello")
    public String theDoor(){
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
    @Scheduled(cron = "0 0/2 * * * ? ")
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
    public Object getAllBeans(){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        List<String> beans = new ArrayList<>();
        Arrays.stream(wac.getBeanDefinitionNames()).forEach(x->beans.add(x));
        return beans;
    }



}
