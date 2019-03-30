package com.hzy.modules.interface_.person;


import com.hzy.modules.interface_.Skill.Hunting;
import com.hzy.modules.interface_.animal.Animal;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/8 19:05
 * @Description version 1.0
 * 猎人
 */
public class Hunter extends Person implements Hunting {

    @Override
    public void eat() {
        System.out.println("Hunter eat something, nothing difference to other !");
    }

    @Override
    public void drink() {
        System.out.println("Hunter drink some water, nothing difference to other !");
    }

    @Override
    public void sleep() {
        System.out.println("Hunter drink go to sleep !");
    }


    @Override
    public void hunting(Animal animal) {
        System.out.println("Hunter use skill Hunting ... hunt the " + animal.getName());
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
