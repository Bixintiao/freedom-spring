package com.hzy.modules.user.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.util.Date;


@TableName("SYS_USER")
public class SysUser {


    @TableField("USER_ID")
    private String userId;


    @TableField("PASSWORD")
    private String password;


    @TableField("AGE")
    private BigDecimal age;

    @TableField("SEX")
    private String sex;


    @TableField("CREATE_BY")
    private String createBy;


    @TableField("CREATE_TIME")
    private Date createTime;


    @TableField("UPDATE_BY")
    private String updateBy;


    @TableField("UPDATE_TIME")
    private Date updateTime;


    @TableField("NAME")
    private String name;

    
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    
    public BigDecimal getAge() {
        return age;
    }

    
    public void setAge(BigDecimal age) {
        this.age = age;
    }

    
    public String getSex() {
        return sex;
    }

    
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    
    public String getCreateBy() {
        return createBy;
    }

    
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    
    public Date getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    public String getUpdateBy() {
        return updateBy;
    }

    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    
    public Date getUpdateTime() {
        return updateTime;
    }

    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                '}';
    }
}