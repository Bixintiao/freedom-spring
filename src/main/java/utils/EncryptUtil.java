package utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/4/25 10:59
 * @Description version 1.0
 *
 * https://www.cnblogs.com/lz2017/p/6917049.html
 * 摘要算法#
 * 摘要算法主要分为MD，SHA和Hmac算法，摘要算法其实是用于效验数据完整性的，我们在下载某些文件时，会有MD5和SHA1值提供我们效验下载的文件是否完整，
 * 可以用于根据数据生成其唯一的摘要值，无法根据摘要值知道原数据，属于不可逆的
 */
public class EncryptUtil {


    /**
     * base64 可逆算法
     * @param str
     * @return
     */
    public static String base64Encode(String str){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    public static String base64Decoder(String str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(str);
        return new String(bytes);
    }

    /**
     * MD5,MD2,SHA
     * @param str
     * @param encryptMethod
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String messageDigest(String str, String encryptMethod) throws NoSuchAlgorithmException {
        Objects.requireNonNull(encryptMethod,"encryptMethod must not null ...");
        MessageDigest md5 = MessageDigest.getInstance(encryptMethod);
        byte[] bytes = md5.digest(str.getBytes());
        return StringUtil.bytesToHexString(bytes);
    }


    public class EncryptMethod{
        public static final String MD5 = "MD5";
        public static final String MD2 = "MD2";
        public static final String SHA = "SHA";
        public static final String SHA_1 = "SHA-1";
        public static final String SHA_256 = "SHA-256";
        public static final String SHA_384 = "SHA-384";
        public static final String SHA_512 = "SHA-512";
    }

}
