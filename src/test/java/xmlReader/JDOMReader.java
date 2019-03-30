package xmlReader;

import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import utils.StringUtil;

import java.util.*;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/12 9:52
 * @Description version 1.0
 * 特征：
 *  1、仅使用具体类，而不使用接口。
 *  2、API大量使用了Collections类。
 *  需要 jar 包 org.jdom.jdom2
 */
public class JDOMReader {

    private static ArrayList<Book> booksList = new ArrayList<Book>();

    @Test
    public void test1(){
        SAXBuilder saxBuilder = new SAXBuilder();

    }


    @Test
    public void test2(){
        String line = "T_IMEX_HANDBOOK_RM";
        System.out.println(StringUtil.toCamel(line, true));
    }



    @Test
    public void test3(){
        List<String> list = new ArrayList<String>();
        String s = "1-1,1-3,2-1,1-4,1-2,2-4";
        String[] imgs = s.split(",");
        Arrays.stream(imgs).forEach(x-> list.add(x));
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        list.forEach(x->{
            System.out.println(x);
        });
    }



}
