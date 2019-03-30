package utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import utils.DBUtil.DBTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月12日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月12日 {填写修改说明}
 */
public class FreekmarkerUtil {


    /**
     * 获取模板
     * @param name
     * @return
     */
    public Template getTemplate(String name){
        try {
            //通过 freemarker configuration 读取flt
            Configuration configuration = new Configuration();
            //设置读取路径
            configuration.setClassForTemplateLoading(this.getClass(),"/ftl");
            //在模板文件目录中找到名称为name的文件
            Template template = configuration.getTemplate(name);
            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 打印到控制台
     * @param name
     * @param root
     */
    public void printConsole(String name, Map<String,Object> root){
        try {
            Template template = this.getTemplate(name);
            template.process(root,new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 打印到文件
     * @param name
     * @param root
     * @param outFile
     */
    public void printFile(String name, Map<String,Object> root,String outFile){
        FileWriter out = null;
        try {
            File file = new File("E:/Temp/outfile/"+outFile);
            if (!file.exists()){
                file.createNewFile();
            }
            out = new FileWriter(file);
            Template template = this.getTemplate(name);
            template.process(root,out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if (null != out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * ForTest
     */
    @Test
    public void test(){
        Map<String,Object> vars = new HashMap<>();
        vars.put("username","---------------- > ---------------- > ");
        printFile("01.ftl",vars,"test01.html");
    }

    @Test
    public void printClass(){
        try {
            Map<String,Object> vars = new HashMap<>();
            String s = DBTool.tableToClass("SYS_USER");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
