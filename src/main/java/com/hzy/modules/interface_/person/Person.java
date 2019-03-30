package com.hzy.modules.interface_.person;

import java.io.Serializable;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/8 19:08
 * @Description version 1.0
 */
public abstract class Person implements Serializable {

    private String name;
    private int age;
    private float high;
    private double weight;

    public abstract void eat();

    public abstract void drink();

    public abstract void sleep();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CastorModeTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", high=" + high +
                ", weight=" + weight +
                '}';
    }
}
