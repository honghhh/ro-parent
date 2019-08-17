package com.project.utils.pwd;

import com.project.exception.ThrowJsonException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * DES 对称加密解密
 */
public class DESEncode {

    private static Logger logger = Logger.getLogger(DESEncode.class);
    private final static String DES = "DES";

    private final static String des_key = "oWtPBKd1ZBk=";

    /**
     * 生成秘钥
     * @return
     * @throws Exception
     */
    public static String genKeyDES() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        SecretKey key = keyGen.generateKey();
        String base64Str = byte2base64(key.getEncoded());
        return base64Str;
    }

    @SuppressWarnings("static-access")
    private static String byte2base64(byte[] bytes) {
        Base64 base64 = new Base64();
        return base64.encode(bytes);
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data) {
        String strs = "";
        try {
            byte[] bt = encrypt(data.getBytes(), des_key.getBytes());
            strs = new Base64().encode(bt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data) {
        if (data == null) {
            return null;
        }
        String str = "";
        try {
            Base64 decoder = new Base64();
            byte[] buf = decoder.decode(data);
            byte[] bt = decrypt(buf, des_key.getBytes());
            str = new String(bt);
        } catch (Exception e) {
            throw new ThrowJsonException("解密失败");
        }
        return str;
    }

    public static Map<String, String> decryptParam(String param) {
        if (StringUtils.isEmpty(param)) {
            return null;
        }
        // 解析param参数
        String paramStr = decrypt(param);
        String[] paramArr = paramStr.split("&");
        Map<String, String> paramMap = new HashMap<>();
        for (String p : paramArr) {
            String[] pArr = p.split("=");
            paramMap.put(pArr[0], pArr[1]);
        }
        return paramMap;
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        String r = encrypt("888888");
        System.out.println(r);
        String a = decrypt(r);
        System.out.println(a);
    }
}
