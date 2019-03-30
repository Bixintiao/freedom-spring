package com.hzy.modules.oxm.entity;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/6 15:54
 * @Description version 1.0
 * 简单bean
 */
public class SimpleBean {

    private int age;
    private boolean executive;
    private String jobDescription;
    private String name;

    public SimpleBean() {
    }

    public SimpleBean(int age, boolean executive, String jobDescription, String name) {
        this.age = age;
        this.executive = executive;
        this.jobDescription = jobDescription;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isExecutive() {
        return executive;
    }

    public void setExecutive(boolean executive) {
        this.executive = executive;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "age=" + age +
                ", executive=" + executive +
                ", jobDescription='" + jobDescription + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
