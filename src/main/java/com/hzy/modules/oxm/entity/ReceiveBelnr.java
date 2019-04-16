package com.hzy.modules.oxm.entity;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/4/10 14:36
 * @Description version 1.0
 * 请求获取制造费用凭证信息vo
 */
public class ReceiveBelnr implements java.io.Serializable{

    //业务系统调取标识  默认：RZ人资凭证的加工人工成本部分
    private String ywbs;
    //业务系统
    private String ywxt;
    //公司代码
    private String bukrs;
    //会计年度
    private String gjahr;
    //过账期间
    private String monat;


    public ReceiveBelnr() {
    }

    public ReceiveBelnr(String bukrs, String gjahr, String monat) {
        this.bukrs = bukrs;
        this.gjahr = gjahr;
        this.monat = monat;
    }


    public String getYwxt() {
        return ywxt;
    }

    public void setYwxt(String ywxt) {
        this.ywxt = ywxt;
    }

    public String getBukrs() {
        return bukrs;
    }

    public void setBukrs(String bukrs) {
        this.bukrs = bukrs;
    }

    public String getGjahr() {
        return gjahr;
    }

    public void setGjahr(String gjahr) {
        this.gjahr = gjahr;
    }

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public String getYwbs() {
        return ywbs;
    }

    public void setYwbs(String ywbs) {
        this.ywbs = ywbs;
    }
}
