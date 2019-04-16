package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/11 14:34
 * @Description version 1.0
 */
public class ReceiveBelnrHeader {

    //公司代码
    private String bukrs;
    //会计年度
    private String gjahr;
    //会计凭证编号
    private String belnr;
    //会计期间
    private String monat;
    //发票的页数
    private String numpg;
    //制证人
    private String usnam;
    //凭证中的凭证日期
    private String bldat;
    //凭证中的过帐日期
    private String budat;
    //凭证类型
    private String blart;
    //冲销凭证号
    private String stblg;

    private List<ReceiveBelnrItem> items;

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

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public String getNumpg() {
        return numpg;
    }

    public void setNumpg(String numpg) {
        this.numpg = numpg;
    }

    public String getUsnam() {
        return usnam;
    }

    public void setUsnam(String usnam) {
        this.usnam = usnam;
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

    public String getBlart() {
        return blart;
    }

    public void setBlart(String blart) {
        this.blart = blart;
    }

    public String getStblg() {
        return stblg;
    }

    public void setStblg(String stblg) {
        this.stblg = stblg;
    }

    public List<ReceiveBelnrItem> getItems() {
        if (items == null){
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<ReceiveBelnrItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ReceiveBelnrHeader{" +
                "bukrs='" + bukrs + '\'' +
                ", gjahr='" + gjahr + '\'' +
                ", belnr='" + belnr + '\'' +
                ", monat='" + monat + '\'' +
                ", numpg='" + numpg + '\'' +
                ", usnam='" + usnam + '\'' +
                ", bldat='" + bldat + '\'' +
                ", budat='" + budat + '\'' +
                ", blart='" + blart + '\'' +
                ", stblg='" + stblg + '\'' +
                '}';
    }
}
