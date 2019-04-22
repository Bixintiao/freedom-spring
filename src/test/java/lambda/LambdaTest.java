package lambda;

import entity.User;
import org.junit.Test;
import utils.DateUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Filter;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年12月21日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年12月21日 {填写修改说明}
 */
public class LambdaTest {


    /**
     * 获取最大值，最小值
     */
    @Test
    public void getMaxMinTest(){
        try {
            Date d1 = DateUtil.parseString("2018-12-12","yyyy-MM-dd");
            Date d2 = DateUtil.parseString("2018-12-15","yyyy-MM-dd");
            Date d3 = DateUtil.parseString("2018-12-01","yyyy-MM-dd");

            List<Date> dates = Arrays.asList(d1,d2,d3);

            Date max = dates.stream().max((o1,o2)->o1.compareTo(o2)).get();
            Date min = dates.stream().min((o1,o2)->o1.compareTo(o2)).get();

            System.out.println("************  maxDate  ************");
            System.out.println(DateUtil.formatDate(max,"yyyy-MM-dd"));
            System.out.println("************  minDate  ************");
            System.out.println(DateUtil.formatDate(min,"yyyy-MM-dd"));
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *
     */
    @Test
    public void sum(){
    }


    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 4, 7, 23, 65, 33, 56, 9));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        list.forEach(x->{
            System.out.println(x);
        });
    }




    @Test
    public void predicateTest(){
        PredicateDemo predicateDemo = new PredicateDemo();
        List<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(1, 4, 7, 23, 65, 33, 56, 9));
        integers = predicateDemo.filter(integers, (x)->x % 2==0);
        integers.forEach(System.out::println);
    }




}
