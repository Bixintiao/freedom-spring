package lambda;

import java.util.Iterator;
import java.util.List;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/25 19:54
 * @Description version 1.0
 */
public class PredicateDemo {

    public <T> List<T> filter(List<T> numbers, Predicate<T> predicate){
        Iterator<T> iterator = numbers.iterator();
        while (iterator.hasNext()){
            if (!predicate.test(iterator.next())){
                iterator.remove();
            }
            iterator.next();
        }
        return numbers;
    }

}
