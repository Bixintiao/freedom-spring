package utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年10月13日
 * @project
 * @description
 * @Modification Date:2018年10月13日 {填写修改说明}
 */
public class DateUtil {

        /*
         * 字母    日期或时间元素        表示        示例
         * G         Era标志符          Text         Ad
         * y         年                 Year         1996 96
         * M         年中的月份         Month        July，Jul，07
         * w         年中的周数         Number       27
         * W         月中的周数         Number       2
         * D         年中的天数         Number       365
         * d         月中的天数         Number       10
         * F         月中的星期         Text         2
         * E         星期中的天数       Text         Tuesday，Tue
         * a         Am/pm 标记         Text         PM
         * H         小时数(0-23)       Number       0
         * h         am/pm 小时(1-12)   Number       12
         * k         小时(1-24)         Number       24
         * K         am/pm 小时(0-11)   Number       0
         * m         分钟数             Number       30
         * s         秒                 Number         55
         * S         毫秒               Number         978
         * z         时区               General time zone
         * Z         时区               RFC 822 time zone   -0800
         * */

        private final static List<String> DEFAULT_PATTERNS = Arrays.asList("EEE MMM dd HH:mm:ss Z yyyy","dd MMM yyyy HH:mm:ss zzz","dd MMM yyyy HH:mm:ss ZZZ");


        public static Date parseString(String dateStr) throws Exception {
            return parseString(dateStr,null,null);
        }

        public static Date parseString(String dateStr, String dateFmt) throws Exception {
            return parseString(dateStr,dateFmt,null);
        }


        public static Date parseString(String dateStr, String dateFmt, Locale locale) throws Exception {
            SimpleDateFormat simpleDateFormat = null;
            if(null == dateStr || dateStr.trim().equals("")){
                return null;
            } else {
                if (null == dateFmt || dateStr.trim().equals("")) {
                    String format = matchDateFormat(dateStr);
                    if (null != format){
                        simpleDateFormat = new SimpleDateFormat(format);
                        return simpleDateFormat.parse(dateStr.replaceAll("[-/:\\.\\s]",""));
                    }
                    if(matcherFind("[a-zA-Z]+",dateStr))
                    {
                        simpleDateFormat = new SimpleDateFormat(dateFmt,Locale.US);
                        for(String fmt : DEFAULT_PATTERNS)
                        {
                            if (null == simpleDateFormat)
                                simpleDateFormat = new SimpleDateFormat(fmt);
                            else
                                simpleDateFormat.applyPattern(fmt);
                            try {
                                return simpleDateFormat.parse(dateStr);
                            } catch (Exception e){
                            }
                        }
                    }

                }
                simpleDateFormat = null == locale ? new SimpleDateFormat(dateFmt) : new SimpleDateFormat(dateFmt,locale);
                return simpleDateFormat.parse(dateStr);
            }
        }


        /**
         * 格式化日期
         * @param date
         * @param fmt
         * @return
         */
        public static String formatDate(Date date, String fmt){
            return formatDate(date,fmt,null);
        }


        /**
         * 格式化日期
         * @param date
         * @param fmt
         * @return
         */
        public static String formatDate(Date date, String fmt,Locale locale){
            SimpleDateFormat dateFormat = null;
            if(null == locale)
                dateFormat = new SimpleDateFormat(fmt);
            else
                dateFormat = new SimpleDateFormat(fmt,locale);
            return dateFormat.format(date);
        }


        /**
         * 匹配存在性
         * @param reg
         * @param input
         * @return
         */
        public static Boolean matcherFind(String reg, String input){
            return Pattern.compile(reg).matcher(input).find();
        }


    static Map<String, String> datePattern = new HashMap<>();
    static {
        //[-/:\\.]
        datePattern.put("^\\d{4}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{2}$","yyyyMMdd");
        datePattern.put("^\\d{4}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{2}\\s*\\d{2}[-/:\\.]{1}\\d{2}$","yyyyMMddHHmm");
        datePattern.put("^\\d{4}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{2}\\s*\\d{2}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{2}$","yyyyMMddHHmmss");
        datePattern.put("^\\d{4}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{2}\\s*\\d{2}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{2}[-/:\\.]{1}\\d{3}$","yyyyMMddHHmmssSSS");
    }

        /**
         * 获取日期格式
         * @param source
         * @return
         * @throws Exception
         */
        public static String matchDateFormat(String source) throws Exception {
            for (String pattern : datePattern.keySet()){
                if (Pattern.matches(pattern, source))
                    return datePattern.get(pattern);
            }
            return null;
        }


}
