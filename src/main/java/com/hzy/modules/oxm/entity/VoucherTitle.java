package com.hzy.modules.oxm.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/23 9:35
 * @Description version 1.0
 * 发送凭证抬头
 */
public class VoucherTitle {

    /**
     * 公司代码 必填 X
     * */
    private String bukrs;
    /**
     * 附件张数
     * */
    private String numpg;
    /**
     * 货币码 必填 X
     * */
    private String waers;
    /**
     * 汇率
     * */
    private BigDecimal kursf;
    /**
     * 凭证中的凭证日期 必填 X
     * */
    private String bldat;
    /**
     * 凭证中的过帐日期 必填 X
     * */
    private String budat;
    /**
     * 会计年度 必填 X
     * */
    private String gjahr;
    /**
     * 凭证摘要
     * */
    private String bktxt;
    /**
     * 会计期间 必填 X
     * */
    private String monat;
    /**
     * 参照
     * */
    private String xblnr;
    /**
     * 凭证类型 默认值“ZE”  必填 X
     * */
    private String blart;
    /**
     * 制证人  必填 X
     * */
    private String usnam;
    /**
     * 业务凭证ID 必填 X
     * */
    private String yw_id;
    /**
     * 来源的业务系统标识  必填 X
     * 默认值=B，B代表宝信系统
     * */
    private String ywxt;
    /**
     * 业务标识  必填 X
     * ZYW_TYPE = 1 正常记账
     * ZYW_TYPE = 2 冲销记账
     * */
    private String zyw_type;
    /**
     * 被冲销SAP凭证号
     * 当ZYW_TYPE = 2 冲销记账业务场景时，
     * R_BELNR 不等于空，且对应为被冲销的SAP凭证编号
     * */
    private String r_belnr;

    /**
     * 冲销原因
     * 当ZYW_TYPE=2冲销记账业务场景时，
     * STGRD冲销原因不等于空，
     * 枚举值为：
     * 01	原记账日期红冲
     * 02	可更改记账日期红冲
     * 03	原记账日期不红冲
     * 04	可更改记账日期不红冲
     * 业务校验：若为01
     * */
    private String stgrd;
    /**
     * 冲销过帐日期
     * 当ZYW_TYPE=2冲销记账业务场景时，STGRD冲销原因=”02”或”04”时，
     * STODT=非空；STGRD冲销原因=”01”或”03”时，STODT=空
     * */
    private String stodt;
    /**
     * 发送日期 时间戳 yyyyMMdd  必填 X
     * */
    private String send_date;
    /**
     * 发送时间 时间戳 HHmmss  必填 X
     * */
    private String send_time;
    /**
     * 预留字段1
     * */
    private String zadditional1;
    /**
     * 预留字段2
     * */
    private String zadditional2;
    /**
     * 预留字段3
     * */
    private String zadditional3;
    /**
     * 预留字段4
     * */
    private String zadditional4;

    /**
     * 行项目
     * */
    List<VoucherItem> items;

    //附加字段
    /**
     * 业务单元代码
     * */
    private String segNo;


    public String getSegNo() {
        return segNo;
    }

    public void setSegNo(String segNo) {
        this.segNo = segNo;
    }

    public String getBktxt() {
        return bktxt;
    }

    public void setBktxt(String bktxt) {
        this.bktxt = bktxt;
    }

    public String getBukrs() {
        return bukrs;
    }

    public void setBukrs(String bukrs) {
        this.bukrs = bukrs;
    }

    public String getNumpg() {
        return numpg;
    }

    public void setNumpg(String numpg) {
        this.numpg = numpg;
    }

    public String getWaers() {
        return waers;
    }

    public void setWaers(String waers) {
        this.waers = waers;
    }

    public BigDecimal getKursf() {
        return kursf;
    }

    public void setKursf(BigDecimal kursf) {
        this.kursf = kursf;
    }

    public String getBldat() {
        return bldat;
    }

    public void setBldat(String bldat) {
        this.bldat = bldat;
    }

    public String getBudat() {
        return budat;
    }

    public void setBudat(String budat) {
        this.budat = budat;
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

    public String getXblnr() {
        return xblnr;
    }

    public void setXblnr(String xblnr) {
        this.xblnr = xblnr;
    }

    public String getBlart() {
        return blart;
    }

    public void setBlart(String blart) {
        this.blart = blart;
    }

    public String getUsnam() {
        return usnam;
    }

    public void setUsnam(String usnam) {
        this.usnam = usnam;
    }

    public String getYw_id() {
        return yw_id;
    }

    public void setYw_id(String yw_id) {
        this.yw_id = yw_id;
    }

    public String getYwxt() {
        return ywxt;
    }

    public void setYwxt(String ywxt) {
        this.ywxt = ywxt;
    }

    public String getZyw_type() {
        return zyw_type;
    }

    public void setZyw_type(String zyw_type) {
        this.zyw_type = zyw_type;
    }

    public String getR_belnr() {
        return r_belnr;
    }

    public void setR_belnr(String r_belnr) {
        this.r_belnr = r_belnr;
    }

    public String getStgrd() {
        return stgrd;
    }

    public void setStgrd(String stgrd) {
        this.stgrd = stgrd;
    }

    public String getStodt() {
        return stodt;
    }

    public void setStodt(String stodt) {
        this.stodt = stodt;
    }

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getZadditional1() {
        return zadditional1;
    }

    public void setZadditional1(String zadditional1) {
        this.zadditional1 = zadditional1;
    }

    public String getZadditional2() {
        return zadditional2;
    }

    public void setZadditional2(String zadditional2) {
        this.zadditional2 = zadditional2;
    }

    public String getZadditional3() {
        return zadditional3;
    }

    public void setZadditional3(String zadditional3) {
        this.zadditional3 = zadditional3;
    }

    public String getZadditional4() {
        return zadditional4;
    }

    public void setZadditional4(String zadditional4) {
        this.zadditional4 = zadditional4;
    }

    public List<VoucherItem> getItems() {
        return items;
    }

    public void setItems(List<VoucherItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "VoucherTitle [bukrs=" + bukrs + ", numpg=" + numpg + ", waers=" + waers + ", kursf=" + kursf
                + ", bldat=" + bldat + ", budat=" + budat + ", gjahr=" + gjahr + ", bktxt=" + bktxt + ", monat=" + monat
                + ", xblnr=" + xblnr + ", blart=" + blart + ", usnam=" + usnam + ", yw_id=" + yw_id + ", ywxt=" + ywxt
                + ", zyw_type=" + zyw_type + ", r_belnr=" + r_belnr + ", stgrd=" + stgrd + ", stodt=" + stodt
                + ", send_date=" + send_date + ", send_time=" + send_time + ", zadditional1=" + zadditional1
                + ", zadditional2=" + zadditional2 + ", zadditional3=" + zadditional3 + ", zadditional4=" + zadditional4
                + ", items=" + items + "]";
    }


}