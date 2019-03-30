package entity;

import java.math.BigDecimal;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月27日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月27日 {填写修改说明}
 */
public class User {

    private int id;
    private String name;
    private int age;
    private BigDecimal price;


    public User() {
    }

    public User(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
