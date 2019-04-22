package otherTest;

import com.alibaba.fastjson.JSON;
import com.hzy.modules.interface_.person.Hunter;
import entity.User;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.BeanUtil;
import utils.DateUtil;
import utils.RegexUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/5 11:50
 * @Description version 1.0
 */
public class OtherTest {


    @Test
    public void test() throws Exception {
        Short s = 1;
        System.out.println("1".equals(String.valueOf(s)));
    }



    @Test
    public void test1() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String corn = "0 0 8-20 * * ?";
        String regEx = "(((^([0-9]|[0-5][0-9])(\\,|\\-|\\/){1}([0-9]|[0-5][0-9]) )|^([0-9]|[0-5][0-9]) |^(\\* ))((([0-9]|[0-5][0-9])(\\,|\\-|\\/){1}([0-9]|[0-5][0-9]) )|([0-9]|[0-5][0-9]) |(\\* ))((([0-9]|[01][0-9]|2[0-3])(\\,|\\-|\\/){1}([0-9]|[01][0-9]|2[0-3]) )|([0-9]|[01][0-9]|2[0-3]) |(\\* ))((([0-9]|[0-2][0-9]|3[01])(\\,|\\-|\\/){1}([0-9]|[0-2][0-9]|3[01]) )|(([0-9]|[0-2][0-9]|3[01]) )|(\\? )|(\\* )|(([1-9]|[0-2][0-9]|3[01])L )|([1-7]W )|(LW )|([1-7]\\#[1-4] ))((([1-9]|0[1-9]|1[0-2])(\\,|\\-|\\/){1}([1-9]|0[1-9]|1[0-2]) )|([1-9]|0[1-9]|1[0-2]) |(\\* ))(([1-7](\\,|\\-|\\/){1}[1-7])|([1-7])|(\\?)|(\\*)|(([1-7]L)|([1-7]\\#[1-4]))))|(((^([0-9]|[0-5][0-9])(\\,|\\-|\\/){1}([0-9]|[0-5][0-9]) )|^([0-9]|[0-5][0-9]) |^(\\* ))((([0-9]|[0-5][0-9])(\\,|\\-|\\/){1}([0-9]|[0-5][0-9]) )|([0-9]|[0-5][0-9]) |(\\* ))((([0-9]|[01][0-9]|2[0-3])(\\,|\\-|\\/){1}([0-9]|[01][0-9]|2[0-3]) )|([0-9]|[01][0-9]|2[0-3]) |(\\* ))((([0-9]|[0-2][0-9]|3[01])(\\,|\\-|\\/){1}([0-9]|[0-2][0-9]|3[01]) )|(([0-9]|[0-2][0-9]|3[01]) )|(\\? )|(\\* )|(([1-9]|[0-2][0-9]|3[01])L )|([1-7]W )|(LW )|([1-7]\\#[1-4] ))((([1-9]|0[1-9]|1[0-2])(\\,|\\-|\\/){1}([1-9]|0[1-9]|1[0-2]) )|([1-9]|0[1-9]|1[0-2]) |(\\* ))(([1-7](\\,|\\-|\\/){1}[1-7] )|([1-7] )|(\\? )|(\\* )|(([1-7]L )|([1-7]\\#[1-4]) ))((19[789][0-9]|20[0-9][0-9])\\-(19[789][0-9]|20[0-9][0-9])))";
        Pattern pattern = Pattern.compile(regEx);
        System.out.println(pattern.matcher(corn).find());
    }





    @Test
    public void testInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hunter hanter = new Hunter();
        hanter.getClass().getMethod("eat").invoke(hanter);
    }


    @Test
    public void testA() throws Exception {
        Date time = Calendar.getInstance().getTime();
        User user = new User(1001,"uu", 18, new Date(), new BigDecimal(12345));

        Field age = User.class.getDeclaredField("age");
        System.out.println("type:"+age.getType()+"      getAnnotatedType:"+age.getAnnotatedType());

        System.out.println();

        Map<String, Object> map = new HashMap<>();
        map.put("id", "1201");
        map.put("name", "18");
        map.put("birth", new Date());

        User uu = BeanUtil.transMap2Bean(map, User.class);
        System.out.println(uu.toString());
    }


    @Test
    public void testC(){
        int i = 3;
        if (i % 3 ==0)
            System.out.println(true);
        else
            System.out.println(false);
        List<Integer> integers = Arrays.asList(12, 312, 3, 23, 423, 34, 32, 23);
    }


    @Test
    public void testss(){
        int num = 992;
        int split = 100;
        BigDecimal r1 = new BigDecimal(num).divide(new BigDecimal(split), 0, BigDecimal.ROUND_CEILING);
        BigDecimal r2 = new BigDecimal(num).add(r1).divide(new BigDecimal(split), 0, BigDecimal.ROUND_CEILING);

        for (int i=1; i<r2.intValue(); i++) {
            System.out.println("---------");
        }

    }


    @Test
    public void testX(){
        int splitSize = 3;
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        BigDecimal p1 = new BigDecimal(integers.size()).divide(new BigDecimal(splitSize), 0, BigDecimal.ROUND_CEILING);
        int pageNo = p1.add(new BigDecimal(integers.size())).divide(new BigDecimal(splitSize), 0, BigDecimal.ROUND_CEILING).intValue();

        for(int i=0; i<pageNo; i++){
            int min = splitSize*i;
            int max =  splitSize*(i+1);
            System.out.println("min:"+min +"    max:" +max);
            int sub = splitSize*(i);
            if(i==0){
                sub=0;
            }
            System.out.println("sub:"+sub);
            for (int j=min; j<max; j++){
                if (j >= integers.size())
                    break;
                System.out.println(j+"    "+(integers.get(j)-sub));
                integers.set(j, (integers.get(j)-sub));
            }
        }
        System.out.println(integers);
    }


    public int getCnLength(String s){
        int cn = 0;
        String temp = null;
        String reg_ = "[\\u4e00-\\u9fa5]";
        Pattern pattern = Pattern.compile(reg_);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            for (int i=0; i<=matcher.groupCount(); i++){
                temp = matcher.group(i);
                cn += temp.length();
            }
        }
        return cn;
    }



}
