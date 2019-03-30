package otherTest;

import org.junit.Test;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/28 16:27
 * @Description version 1.0
 */
public class System_out {


    @Test
    public void test(){
        System.out.println("\033[1;4;2;34;9m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[31;4m" + "我滴个颜什" + "\033[0m");
    }

    /**
     * 格式
     *    "\033[*;*;*m"  //比如 "\033[1;2;3m"
     *     前缀"\033["，后缀"m"
     *     颜色、背景颜色、样式都是用数字表示
     *     所以只需要把对应的字码用";"隔开就好了
     * 范围
     *     转义符之后的字符都会变成转义符所表示的样式
     * 示例
     *     //使用idea做测试，很多显示不出来
     *     样式：
     *     0  空样式
     *     1  粗体
     *     4  下划线
     *     7  反色
     *     颜色1：
     *     30  白色
     *     31  红色
     *     32  绿色
     *     33  黄色
     *     34  蓝色
     *     35  紫色
     *     36  浅蓝
     *     37  灰色
     *     背景颜色：
     *     40-47 和颜色顺序相同
     *     颜色2：
     *     90-97  比颜色1更鲜艳一些，我也不太清楚为什么又两种
     * */
}
