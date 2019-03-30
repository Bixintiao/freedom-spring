package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月25日
 * @project ubmp
 * @description
 * @Modification Date:2019年01月25日 {填写修改说明}
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD,ElementType.FIELD })
public @interface Val {

    String value() default "default value";

    boolean toCamel() default false;

    boolean toUnderline() default false;

    int maxVal() default Integer.MAX_VALUE;

    int minVal() default Integer.MIN_VALUE;

}
