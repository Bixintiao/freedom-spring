package annotation;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月25日
 * @project ubmp
 * @description
 * @Modification Date:2019年01月25日 {填写修改说明}
 */
public class ANN {

    @Val(minVal = -127, maxVal = 128)
    public Integer var1 = 129;


    @Val(value = "ANN", toCamel = true)
    public String var2;

    public String a;

    public String getA() {
        return a;
    }

    @Val(value = "NANO_SIMPLE",toCamel = true)
    public void setA(String a) {
        this.a = a;
    }


    public ANN() { }


    public ANN(Integer var1, String var2, String a) {
        this.var1 = var1;
        this.var2 = var2;
        this.a = a;
    }

    @Override
    public String toString() {
        return "ANN{" +
                "var1=" + var1 +
                ", var2='" + var2 + '\'' +
                ", a='" + a + '\'' +
                '}';
    }


}
