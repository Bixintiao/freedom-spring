package entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月27日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月27日 {填写修改说明}
 */
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Date birth;
    private BigDecimal price;


    public User() {
    }

    public User(Integer id, String name, Integer age, Date birth, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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
                ", birth=" + birth +
                ", price=" + price +
                '}';
    }

}
