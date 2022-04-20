package utils.sm;

import cn.hutool.crypto.SmUtil;

public class SM3Encryption {

    /**
     * SM3 加密
     *
     * 效果类似 MD5 码
     */
    public static byte[] encode(String data) {
        return SmUtil.sm3(data).getBytes();
    }
}
