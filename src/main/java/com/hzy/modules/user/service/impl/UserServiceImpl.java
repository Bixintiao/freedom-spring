package com.hzy.modules.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hzy.modules.user.mapper.SysUserMapper;
import com.hzy.modules.user.service.UserService;
import com.hzy.modules.user.vo.SysUser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年12月01日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年12月01日 {填写修改说明}
 */
//@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements UserService {

    org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    //@Autowired
    SysUserMapper userMapper;


    @Override
    public List<SysUser> findAllUser() throws Exception {
        try {
            EntityWrapper<SysUser> userWrapper = new EntityWrapper<SysUser>();
            return userMapper.selectList(userWrapper);
        } catch (Exception e){
            e.printStackTrace();
            logger.error(" 异常信息:【{}】",e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}