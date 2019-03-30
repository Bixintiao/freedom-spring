package annotation;

import org.junit.Test;
import utils.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月25日
 * @project ubmp
 * @description
 * @Modification Date:2019年01月25日 {填写修改说明}
 */
public class AnnoTest {


    @Test
    public void test(){
        ANN ann = new ANN();
        autoAnno(ann);
        System.out.println(ann.toString());
    }



    public void autoAnno(Object o){
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(f->{
            if (f.isAnnotationPresent(Val.class)){
                Val val = f.getAnnotation(Val.class);
                if (f.getType() == Integer.class){
                    try {
                        Integer fieldValue = f.get(o) == null ? 0 : (Integer) f.get(o);
                        if (fieldValue > val.maxVal()){
                            f.set(o,val.maxVal());
                            System.out.println("----------  change "+f.getName()+" "+ fieldValue +" to val.max " + val.maxVal());
                        }
                        if (fieldValue < val.minVal()){
                            f.set(o,val.minVal());
                            System.out.println("----------  change "+f.getName()+" "+ fieldValue +" to val.min " + val.minVal());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (f.getType() == String.class){
                    String s = val.value();
                    if (val.toCamel())
                        s = StringUtil.toCamel(s);
                    try {
                        f.set(o,s);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Arrays.stream(o.getClass().getMethods()).forEach(x->{
            if (x.isAnnotationPresent(Val.class)){
                try {
                    Val val = x.getAnnotation(Val.class);
                    String a = val.value();
                    if (val.toCamel()){
                        a = StringUtil.toCamel(val.value());
                    }
                    x.invoke(o,a);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
