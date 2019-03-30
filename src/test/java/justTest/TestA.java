package justTest;

import com.hzy.modules.oxm.entity.SimpleBean;
import org.junit.Test;
import utils.DateUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月18日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月18日 {填写修改说明}
 */
public class TestA {


    @Test
    public void test1() throws Exception {
//        String format = DateUtil.matchDateFormat("2018-01-21 18:18:50");
//        System.out.println(format);
        System.out.println(DateUtil.parseString("2018-01-21 18:18:33.333"));
    }



    @Test
    public void test2(){
        //System.out.println(DateUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS"));

        System.out.println("2018/01/21 18:18".replaceAll("[-/:\\.\\s]",""));
    }



    @Test
    public void list1(){
        List list = new ArrayList();
        SimpleBean s1 = new SimpleBean();
        for (int j = 0; j<10; j++){
            for (int i = 0; i<10; i++){
                int a = new Random().nextInt(100);
                System.out.println(a);
                s1.setAge(a);
                list.add(s1);
            }

            System.out.println("--------------------------------------------");
            list.forEach(x->{
                System.out.println(x.toString());
            });
        }
    }










}
