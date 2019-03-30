package lambda;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/25 19:55
 * @Description version 1.0
 */

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

}
