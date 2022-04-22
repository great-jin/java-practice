package utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SM4Encryption {

    private static final Logger logger = LoggerFactory.getLogger(SM4Encryption.class);

    private static SM4 sm4;

    public static byte[] encode(String key, String data) {
        if (key.length() != 16) {
            logger.info("密钥长度不为16位");
            throw new IllegalArgumentException("密钥长度必须为16位");
        }

        return sm4Encode(key, data).getBytes();
    }

    /**
     * SM4 非对称解密
     */
    public static String decode(String key, byte[] bytes) {
        if (key.length() != 16) {
            logger.info("密钥长度不为16位");
            throw new IllegalArgumentException("密钥长度必须为16位");
        }
        return sm4Decode(key, new String(bytes));
    }

    public static String sm4Encode(String key, String data) {
        sm4 = (SM4) SmUtil.sm4(key.getBytes());
        return sm4.encryptHex(data);
    }

    public static String sm4Decode(String key, String data) {
        sm4 = (SM4) SmUtil.sm4(key.getBytes());
        return sm4.decryptStr(data, CharsetUtil.CHARSET_UTF_8);
    }
}
