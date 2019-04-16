package com.hzy.modules.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.hzy.modules.Constants;
import com.hzy.modules.user.service.UserService;
import com.hzy.modules.user.vo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月18日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月18日 {填写修改说明}
 */
//@RestController
@Controller
@RequestMapping("user")
public class UserController {


    //@Autowired
    private UserService userService;


    static JSONObject success = null;
    static {
        success  = new JSONObject();
        success.put("success",true);
        success.put("message","success");
    }

    /**
     * get user list
     * @return
     */
    @ResponseBody
    @RequestMapping("users")
    public Object getAllUser(){
        try {
            return userService.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * add user
     * @param user
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Object addUser(SysUser user){
        System.out.println(user.toString());
        success.put(Constants.RESULT.DATA,user.toString());
        return success;
    }




}
