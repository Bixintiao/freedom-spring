package com.hzy.modules.oxm.entity;

import java.math.BigDecimal;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/23 10:30
 * @Description version 1.0
 * 发送凭证行项目
 */
public class VoucherItem {

    /**
     * 公司代码  必填 X
     * */
    private String bukrs;
    /**
     * 业务凭证ID  必填 X
     * */
    private String yw_id;
    /**
     * 会计年度  必填 X
     * */
    private String gjahr;
    /**
     * 行项目编号  必填 X
     * */
    private String buzei;
    /**
     * 记账码  必填 X
     * */
    private String bschl;
    /**
     * 科目  必填 X
     * */
    private String hkont;
    /**
     * 行项目文本  必填 X
     * */
    private String sgtxt;
    /**
     * 分配编号  必填 X
     * */
    private String zuonr;
    /**
     * 特殊总帐标识 (SGL标识)
     * */
    private String umskz;
    /**
     * 付款原因代码 (若为银行货币类科目，该字段为必输字段)
     * */
    private String rstgr;
    /**
     * 贸易伙伴
     * */
    private String vbund;
    /**
     * 数量
     * */
    private BigDecimal menge;
    /**
     * 单位
     * */
    private String meins;
    /**
     * 税码
     * */
    private String mwskz;
    /**
     * 本位币金额 必填 X
     * */
    private BigDecimal dmbtr;
    /**
     * 金额 必填 X
     * */
    private BigDecimal wrbtr;

    /**
     * 成本中心
     * */
    private String kostl;
    /**
     * 利润中心  BSEG，场景测试后进行完善
     * */
    private String prctr;
    /**
     * 基本金额 宝信逻辑传递：不含税金额=含税总额-税额
     * */
    private String fwbas;
    /**
     * 付款基准日  (到期日) yyyyMMdd
     * BSEG，付款业务必输
     * */
    private String zfbdt;

    /**
     * 供应商代码
     * */
    private String lifnr;
    /**
     * 客户编号
     * */
    private String kunnr;
    /**
     * 参考1
     * */
    private String xref1;
    /**
     * 参考2
     * */
    private String xref2;
    /**
     * 参考3
     * */
    private String xref3;
    /**
     * 标识: 反记帐 当非空且是“x”时代表负数
     * */
    private String xnegp;
    /**
     * SAP一次性客户供应商是通过固定编码判断的，宝信需要初始化固定编码进行逻辑判断，
     * 进入用户填写屏幕字段SAP一次性客户供应商是通过固定编码判断的，
     * 宝信需要初始化一次性固定编码进行逻辑判断，进入用户填写屏幕字段。
     * 该字段一性客户、供应商，宝信传递，必输
     * */
    private String name1;

    /**
     * 邮政编码 一性客户、供应商
     * */
    private String pstlz;
    /**
     * 城市  一性客户、供应商，宝信传递，必输
     * */
    private String ort01;
    /**
     * 国家代码 一性客户、供应商
     * */
    private String land1;

    /**
     * 住宅号及街道
     * */
    private String stras;
    /**
     * 银行账户号码
     * */
    private String bankn;
    /**
     * 税号1
     * */
    private String stcd1;
    /**
     * 税号4
     * */
    private String stcd4;
    /**
     * 标题
     * */
    private String anred;
    /**
     * 汇票签发日 length 8 (yyyyMMdd)
     * */
    private String wdate;
    /**
     * 获利能力段编号(CO-PA)
     * */
    private String paobjnr;
    /**
     * 汇票出票人的名字  一性客户、供应商
     * */
    private String wname;
    /**
     * 汇票出票人的城市
     * 汇票，宝信传递
     * */
    private String wort1;
    /**
     * 汇票受票人城市
     * */
    private String wort2;
    /**
     * 汇票受票人
     * 汇票，宝信传递
     * */
    private String wbzog;
    /**
     * 地区
     * */
    private String regio;

    /**
     * 预留字段1 char(50)
     * */
    private String zadditional1;
    /**
     * 预留字段2 char(50)
     * */
    private String zadditional2;
    /**
     * 预留字段3 char(50)
     * */
    private String zadditional3;
    /**
     * 预留字段4 char(50)
     * */
    private String zadditional4;
    /**
     * 预留字段5 char(50)
     * */
    private String zadditional5;
    /**
     * 预留字段6 char(50)
     * */
    private String zadditional6;

    //报文中存在   接口文档中不存在的
    /**
     * 订单号
     * */
    private String aufnr;
    /**
     * 物料编号
     * */
    private String matnr;
    /**
     * 业务范围
     * */
    private String gsber;
    /**
     * 付款条件代码
     * */
    private String pmnttrms;
    /**
     * 起息日
     * */
    private String valut;
    /**
     * 通用字段
     * */
    private String zzist;
    /**
     * 可以支付汇票的银行地址(国内)
     * */
    private String wbank;





    public String getWbank() {
        return wbank;
    }

    public void setWbank(String wbank) {
        this.wbank = wbank;
    }

    public String getZzist() {
        return zzist;
    }

    public void setZzist(String zzist) {
        this.zzist = zzist;
    }

    public String getValut() {
        return valut;
    }

    public void setValut(String valut) {
        this.valut = valut;
    }

    public String getPmnttrms() {
        return pmnttrms;
    }

    public void setPmnttrms(String pmnttrms) {
        this.pmnttrms = pmnttrms;
    }

    public String getGsber() {
        return gsber;
    }

    public void setGsber(String gsber) {
        this.gsber = gsber;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }

    public String getBukrs() {
        return bukrs;
    }

    public void setBukrs(String bukrs) {
        this.bukrs = bukrs;
    }

    public String getYw_id() {
        return yw_id;
    }

    public void setYw_id(String yw_id) {
        this.yw_id = yw_id;
    }

    public String getGjahr() {
        return gjahr;
    }

    public void setGjahr(String gjahr) {
        this.gjahr = gjahr;
    }

    public String getBuzei() {
        return buzei;
    }

    public void setBuzei(String buzei) {
        this.buzei = buzei;
    }

    public String getBschl() {
        return bschl;
    }

    public void setBschl(String bschl) {
        this.bschl = bschl;
    }

    public String getHkont() {
        return hkont;
    }

    public void setHkont(String hkont) {
        this.hkont = hkont;
    }

    public String getSgtxt() {
        return sgtxt;
    }

    public void setSgtxt(String sgtxt) {
        this.sgtxt = sgtxt;
    }

    public String getZuonr() {
        return zuonr;
    }

    public void setZuonr(String zuonr) {
        this.zuonr = zuonr;
    }

    public String getUmskz() {
        return umskz;
    }

    public void setUmskz(String umskz) {
        this.umskz = umskz;
    }

    public String getRstgr() {
        return rstgr;
    }

    public void setRstgr(String rstgr) {
        this.rstgr = rstgr;
    }

    public BigDecimal getMenge() {
        return menge;
    }

    public void setMenge(BigDecimal menge) {
        this.menge = menge;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public String getVbund() {
        return vbund;
    }

    public void setVbund(String vbund) {
        this.vbund = vbund;
    }

    public String getMwskz() {
        return mwskz;
    }

    public void setMwskz(String mwskz) {
        this.mwskz = mwskz;
    }

    public BigDecimal getDmbtr() {
        return dmbtr;
    }
    public void setDmbtr(BigDecimal dmbtr) {
        this.dmbtr = dmbtr;
    }
    public BigDecimal getWrbtr() {
        return wrbtr;
    }
    public void setWrbtr(BigDecimal wrbtr) {
        this.wrbtr = wrbtr;
    }
    public String getKostl() {
        return kostl;
    }

    public void setKostl(String kostl) {
        this.kostl = kostl;
    }

    public String getPrctr() {
        return prctr;
    }

    public void setPrctr(String prctr) {
        this.prctr = prctr;
    }

    public String getFwbas() {
        return fwbas;
    }

    public void setFwbas(String fwbas) {
        this.fwbas = fwbas;
    }

    public String getKunnr() {
        return kunnr;
    }

    public void setKunnr(String kunnr) {
        this.kunnr = kunnr;
    }

    public String getXref1() {
        return xref1;
    }

    public void setXref1(String xref1) {
        this.xref1 = xref1;
    }

    public String getXref2() {
        return xref2;
    }

    public void setXref2(String xref2) {
        this.xref2 = xref2;
    }

    public String getXref3() {
        return xref3;
    }

    public void setXref3(String xref3) {
        this.xref3 = xref3;
    }

    public String getZfbdt() {
        return zfbdt;
    }

    public void setZfbdt(String zfbdt) {
        this.zfbdt = zfbdt;
    }

    public String getLifnr() {
        return lifnr;
    }

    public void setLifnr(String lifnr) {
        this.lifnr = lifnr;
    }


    public String getPaobjnr() {
        return paobjnr;
    }

    public void setPaobjnr(String paobjnr) {
        this.paobjnr = paobjnr;
    }

    public String getXnegp() {
        return xnegp;
    }

    public void setXnegp(String xnegp) {
        this.xnegp = xnegp;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPstlz() {
        return pstlz;
    }

    public void setPstlz(String pstlz) {
        this.pstlz = pstlz;
    }

    public String getOrt01() {
        return ort01;
    }

    public void setOrt01(String ort01) {
        this.ort01 = ort01;
    }

    public String getLand1() {
        return land1;
    }

    public void setLand1(String land1) {
        this.land1 = land1;
    }

    public String getStras() {
        return stras;
    }

    public void setStras(String stras) {
        this.stras = stras;
    }

    public String getBankn() {
        return bankn;
    }

    public void setBankn(String bankn) {
        this.bankn = bankn;
    }

    public String getStcd1() {
        return stcd1;
    }

    public void setStcd1(String stcd1) {
        this.stcd1 = stcd1;
    }

    public String getStcd4() {
        return stcd4;
    }

    public void setStcd4(String stcd4) {
        this.stcd4 = stcd4;
    }

    public String getAnred() {
        return anred;
    }

    public void setAnred(String anred) {
        this.anred = anred;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWort1() {
        return wort1;
    }

    public void setWort1(String wort1) {
        this.wort1 = wort1;
    }

    public String getWbzog() {
        return wbzog;
    }

    public void setWbzog(String wbzog) {
        this.wbzog = wbzog;
    }

    public String getWort2() {
        return wort2;
    }

    public void setWort2(String wort2) {
        this.wort2 = wort2;
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
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

    public String getZadditional5() {
        return zadditional5;
    }

    public void setZadditional5(String zadditional5) {
        this.zadditional5 = zadditional5;
    }

    public String getZadditional6() {
        return zadditional6;
    }

    public void setZadditional6(String zadditional6) {
        this.zadditional6 = zadditional6;
    }

    @Override
    public String toString() {
        return "VoucherItem{" +
                "bukrs='" + bukrs + '\'' +
                ", yw_id='" + yw_id + '\'' +
                ", gjahr='" + gjahr + '\'' +
                ", buzei='" + buzei + '\'' +
                ", bschl='" + bschl + '\'' +
                ", hkont='" + hkont + '\'' +
                ", sgtxt='" + sgtxt + '\'' +
                ", zuonr='" + zuonr + '\'' +
                ", umskz='" + umskz + '\'' +
                ", rstgr='" + rstgr + '\'' +
                ", vbund='" + vbund + '\'' +
                ", menge=" + menge +
                ", meins='" + meins + '\'' +
                ", mwskz='" + mwskz + '\'' +
                ", dmbtr=" + dmbtr +
                ", wrbtr=" + wrbtr +
                ", kostl='" + kostl + '\'' +
                ", prctr='" + prctr + '\'' +
                ", fwbas='" + fwbas + '\'' +
                ", zfbdt='" + zfbdt + '\'' +
                ", lifnr='" + lifnr + '\'' +
                ", kunnr='" + kunnr + '\'' +
                ", xref1='" + xref1 + '\'' +
                ", xref2='" + xref2 + '\'' +
                ", xref3='" + xref3 + '\'' +
                ", xnegp='" + xnegp + '\'' +
                ", name1='" + name1 + '\'' +
                ", pstlz='" + pstlz + '\'' +
                ", ort01='" + ort01 + '\'' +
                ", land1='" + land1 + '\'' +
                ", stras='" + stras + '\'' +
                ", bankn='" + bankn + '\'' +
                ", stcd1='" + stcd1 + '\'' +
                ", stcd4='" + stcd4 + '\'' +
                ", anred='" + anred + '\'' +
                ", wdate='" + wdate + '\'' +
                ", paobjnr='" + paobjnr + '\'' +
                ", wname='" + wname + '\'' +
                ", wort1='" + wort1 + '\'' +
                ", wort2='" + wort2 + '\'' +
                ", wbzog='" + wbzog + '\'' +
                ", regio='" + regio + '\'' +
                ", zadditional1='" + zadditional1 + '\'' +
                ", zadditional2='" + zadditional2 + '\'' +
                ", zadditional3='" + zadditional3 + '\'' +
                ", zadditional4='" + zadditional4 + '\'' +
                ", zadditional5='" + zadditional5 + '\'' +
                ", zadditional6='" + zadditional6 + '\'' +
                ", aufnr='" + aufnr + '\'' +
                ", matnr='" + matnr + '\'' +
                ", gsber='" + gsber + '\'' +
                ", pmnttrms='" + pmnttrms + '\'' +
                ", valut='" + valut + '\'' +
                ", zzist='" + zzist + '\'' +
                ", wbank='" + wbank + '\'' +
                '}';
    }
}