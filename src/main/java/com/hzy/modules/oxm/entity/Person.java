package com.hzy.modules.oxm.entity;


import java.util.Date;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/26 19:22
 * @Description version 1.0
 */
public class Person implements java.io.Serializable {

    private String name = null;

    private Date dob = null;

    public Person() {
        super();
    }

    public Person(String name) { this.name = name; }

    public Date getDateOfBirth() { return dob; }

    public String getName() { return name; }

    public void setDateOfBirth(Date dob) { this.dob = dob; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
