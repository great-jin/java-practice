package utils.sm4;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encryption {

    private static final Logger logger = LoggerFactory.getLogger(Encryption.class);

    private static SM4 sm4;
    private static String encryptData = "";
    private static String decryptData = "";

    private final static String key = "default-sm4-keys";

    /**
     * SM3 加密
     * SM4 默认 Key 加密
     */
    public static String encode(String type, String data) {
        switch (type) {
            case "":
            case "sm3":
                encryptData = SmUtil.sm3(data);
                break;
            case "sm4":
                // 默认 Key 加密
                encryptData = sm4Encode(key, data);
                break;
            default:
                logger.info("加密类型错误");
                throw new IllegalArgumentException("加密类型错误");
        }

        return encryptData;
    }

    /**
     * SM3 加密
     * SM4 非对称加密
     */
    public static String encode(String type, String key, String data) {
        switch (type) {
            case "":
            case "sm3":
                encryptData = SmUtil.sm3(data);
                break;
            case "sm4":
                if (key.length() != 16) {
                    logger.info("密钥长度不为16位");
                    throw new IllegalArgumentException("密钥长度必须为16位");
                }
                encryptData = sm4Encode(key, data);
                break;
            default:
                logger.info("加密类型错误");
                throw new IllegalArgumentException("加密类型错误");
        }

        return encryptData;
    }

    /**
     * SM4 默认 Key 解密
     */
    public static String decode(String type, String data) {
        if (type.equals("sm4")) {
            decryptData = sm4Decode(key, data);
        } else {
            logger.info("解密类型错误");
            throw new IllegalArgumentException("解密类型错误");
        }

        return decryptData;
    }

    /**
     * SM4 非对称解密
     */
    public static String decode(String type, String key, String data) {
        if (type.equals("sm4")) {
            if (key.length() != 16) {
                logger.info("密钥长度不为16位");
                throw new IllegalArgumentException("密钥长度必须为16位");
            }
            decryptData = sm4Decode(key, data);
        } else {
            logger.info("解密类型错误");
            throw new IllegalArgumentException("解密类型错误");
        }

        return decryptData;
    }

    public static String sm4Encode(String key, String data) {
        sm4 = SmUtil.sm4(key.getBytes());
        return sm4.encryptHex(data);
    }

    public static String sm4Decode(String key, String data) {
        sm4 = SmUtil.sm4(key.getBytes());
        return sm4.decryptStr(data, CharsetUtil.CHARSET_UTF_8);
    }
}
