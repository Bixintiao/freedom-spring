package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年12月22日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年12月22日 {填写修改说明}
 */
public class RegexUtil {


    /**
     * 匹配存在性
     * @param reg
     * @param input
     * @return
     */
    public static Boolean matcherFind(String reg, String input){
        return Pattern.compile(reg).matcher(input).find();
    }


    public static List<String> matchFindAll(String pattern, String line){
        List<String> allMatches = new ArrayList<String>();
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        while (matcher.find()){
            allMatches.add(matcher.group(0));
        }
        return allMatches;
    }


}
