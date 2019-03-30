package com.hzy.modules.user.service;

import com.hzy.modules.user.vo.SysUser;

import java.util.List;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年12月01日
 * @project sinochem-ubmp
 * @description
 * @Modification Date:2018年12月01日 {填写修改说明}
 */
public interface UserService  {


    /**
     * @return
     * @throws Exception
     */
    List<SysUser> findAllUser() throws Exception;



}
