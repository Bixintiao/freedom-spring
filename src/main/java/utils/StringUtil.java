package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月07日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月07日 {填写修改说明}
 */
public class StringUtil {

    static final char UNDERLINE = '_';

    /**
     * 驼峰转下划线
     * camel -> underline
     * @param line
     * @return
     */
    public static String toUnderline(String line){
        if (null == line || "".equals(line.trim())){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<line.length(); i++){
            char c = line.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }



    /**
     * 下划线转驼峰
     * @param line
     * @return
     */
    public static String toCamel(String line) {
        return toCamel(line,true);
    }

    /**
     * underline -> camel
     * @param line
     * @param var1  bigger first
     * @return
     */
    public static String toCamel(String line, boolean var1){
        if (null == line || "".equals(line.trim())){
            return "";
        }
        int len = line.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<len; i++){
            char c = line.charAt(i);
            if (c == UNDERLINE){
                if (++i < len){
                    sb.append(Character.toUpperCase(line.charAt(i)));
                }
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        if (var1){
            String var2 = sb.toString();
            if (var2.length() > 0)
                return Character.toUpperCase(var2.charAt(0)) + var2.substring(1,var2.length());
            else
                return Character.toUpperCase(var2.charAt(0))+"";
        }
        return sb.toString();
    }


    /**
     * 判断空
     * @param s
     * @return
     */
    public static boolean isBlank(String s){
        if (null == s || s.trim().equals("")){
            return true;
        }
        return false;
    }


    public static boolean isNotBlank(String s){
        return !isBlank(s);
    }


    /**
     * 反转 string
     * @param str
     * @return
     */
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 包名反转
     * @param pkName
     * @return
     */
    public static String reversePackage(String pkName){
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(pkName, ".");
        while (st.hasMoreElements()){
            list.add((String) st.nextElement());
        }
        for (int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
            if (i>0) sb.append(".");
        }
        return sb.toString();
    }


    public static String firstCharBigger(String str) throws Exception{
        if (isBlank(str))
            throw new Exception("not found one char");
        if (str.length() > 0)
            return Character.toUpperCase(str.charAt(0)) + str.substring(1,str.length());
        else
            return Character.toUpperCase(str.charAt(0))+"";
    }


    /**
     * 16 进制转字节数组
     * @param hex
     * @return
     */
    public static final byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
            byte[] result = new byte[len];
            char[] achar = hex.toCharArray();
            for (int i = 0; i < len; i++) {
                int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static int toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }


    /**
     * 字节数组转 16 进制
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


}
