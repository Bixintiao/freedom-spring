package justTest;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import utils.StringUtil;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月27日
 * @project freedom-spring
 * @description 加密
 * @Modification Date:2019年02月27日 {填写修改说明}
 */
public class EncryptTest {


    /**
     * Base64 可逆算法
     * @throws IOException
     */
    @Test
    public void jdkBase64() throws IOException {
        String str = "hello jdk64 encoder !";
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(str.getBytes());
        System.out.println("encode:" + encode);


        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(encode);
        System.out.println("decode:" + new String(bytes));
    }


    /**
     * 摘要算法
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void jdkMD5() throws NoSuchAlgorithmException {
        String str = "hello md5";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(str.getBytes());
        System.out.println(StringUtil.bytesToHexString(bytes));



        MessageDigest md2 = MessageDigest.getInstance("MD2");
        byte[] bytes2 = md2.digest(str.getBytes());
        System.out.println(StringUtil.bytesToHexString(bytes2));

        
        MessageDigest sha = MessageDigest.getInstance("SHA");
        byte[] bytesSha = sha.digest(str.getBytes());
        System.out.println(StringUtil.bytesToHexString(bytesSha));

    }






}
