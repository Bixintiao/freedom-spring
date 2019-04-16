package entity;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/11 14:34
 * @Description version 1.0
 */
public class ReceiveBelnrItem {

    //公司代码
    private String bukrs;
    //会计年度
    private String gjahr;
    //会计凭证编号
    private String belnr;
    //行项目编号
    private String buzei;
    //记账码
    private String bschl;
    //总账科目
    private String hkont;
    //金额
    private String wrbtr;
    //标识: 反记帐
    private String xnegp;
    //供应商或债权人的帐号
    private String lifnr;
    //客户编号
    private String kunnr;
    //利润中心
    private String prctr;
    //成本中心
    private String kostl;
    //分配编号
    private String zuonr;
    //行项目文本
    private String sgtxt;
    //付款原因代码
    private String rstgr;
    //借方/贷方标识
    private String shkzg;

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

    public String getBelnr() {
        return belnr;
    }

    public void setBelnr(String belnr) {
        this.belnr = belnr;
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

    public String getWrbtr() {
        return wrbtr;
    }

    public void setWrbtr(String wrbtr) {
        this.wrbtr = wrbtr;
    }

    public String getXnegp() {
        return xnegp;
    }

    public void setXnegp(String xnegp) {
        this.xnegp = xnegp;
    }

    public String getLifnr() {
        return lifnr;
    }

    public void setLifnr(String lifnr) {
        this.lifnr = lifnr;
    }

    public String getKunnr() {
        return kunnr;
    }

    public void setKunnr(String kunnr) {
        this.kunnr = kunnr;
    }

    public String getPrctr() {
        return prctr;
    }

    public void setPrctr(String prctr) {
        this.prctr = prctr;
    }

    public String getKostl() {
        return kostl;
    }

    public void setKostl(String kostl) {
        this.kostl = kostl;
    }

    public String getZuonr() {
        return zuonr;
    }

    public void setZuonr(String zuonr) {
        this.zuonr = zuonr;
    }

    public String getSgtxt() {
        return sgtxt;
    }

    public void setSgtxt(String sgtxt) {
        this.sgtxt = sgtxt;
    }

    public String getRstgr() {
        return rstgr;
    }

    public void setRstgr(String rstgr) {
        this.rstgr = rstgr;
    }

    public String getShkzg() {
        return shkzg;
    }

    public void setShkzg(String shkzg) {
        this.shkzg = shkzg;
    }

    @Override
    public String toString() {
        return "ReceiveBelnrItem{" +
                "bukrs='" + bukrs + '\'' +
                ", gjahr='" + gjahr + '\'' +
                ", belnr='" + belnr + '\'' +
                ", buzei='" + buzei + '\'' +
                ", bschl='" + bschl + '\'' +
                ", hkont='" + hkont + '\'' +
                ", wrbtr='" + wrbtr + '\'' +
                ", xnegp='" + xnegp + '\'' +
                ", lifnr='" + lifnr + '\'' +
                ", kunnr='" + kunnr + '\'' +
                ", prctr='" + prctr + '\'' +
                ", kostl='" + kostl + '\'' +
                ", zuonr='" + zuonr + '\'' +
                ", sgtxt='" + sgtxt + '\'' +
                ", rstgr='" + rstgr + '\'' +
                ", shkzg='" + shkzg + '\'' +
                '}';
    }
}
