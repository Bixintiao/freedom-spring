package justTest;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hzy.modules.user.mapper.SysUserMapper;
import com.hzy.modules.user.vo.SysUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utils.DateUtil;
import utils.StringUtil;
import utils.taskScheduler.Task;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年12月01日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年12月01日 {填写修改说明}
 */

/*@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")*/
public class OtherTest {

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void queryTest(){

        System.out.println("********** 开始执行 **********");
        SysUser sysUser = new SysUser();
        List<SysUser> sysUsers = sysUserMapper.selectList(new EntityWrapper<SysUser>());
        System.out.println(sysUsers.size());
    }

    /**
     * java默认的分隔符是“空格”、“制表符(‘\t’)”、“换行符(‘\n’)”、“回车符(‘\r’)”。
     */
    @Test
    public void StringTokenizerTest(){
        StringTokenizer st = new StringTokenizer("varchar");
        int cnt = st.countTokens();
        System.out.println(cnt);
        System.out.println("****************** element ******************");
        while (st.hasMoreElements()){
            System.out.println(st.nextElement());
        }
        System.out.println("****************** token ******************");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }


    @Test
    public void testDate(){
        Date d = Calendar.getInstance().getTime();
        d.setDate(d.getDate()-1);
        System.out.println(d);
    }


    @Test
    public void testReverse(){
        System.out.println(
            StringUtil.reverse("com.hzy.modules.cxfWebService.service")
        );
    }


    @Test
    public void test3(){
        String str = "com.hzy.modules.cxfWebService.service";
        System.out.println(StringUtil.reversePackage(str));
    }

    @Test
    public void testNumberToString(){
        Date monthLastDay = DateUtil.getMonthLastDay(new Date());
        System.out.println(DateUtil.formatDate(monthLastDay, "yyyy-MM-dd"));
    }




}
