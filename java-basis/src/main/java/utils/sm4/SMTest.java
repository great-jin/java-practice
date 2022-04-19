package utils.sm4;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;

public class SMTest {

    private final String data = "original information";

    /**
     * SM3
     * 默认 SM3
     */
    @Test
    public void demo1() {
        String encrypt = Encryption.encode("", data);

        System.out.println("origin: " + data);
        System.out.println("encrypt: " + encrypt);
    }

    /**
     * SM3 加密
     */
    @Test
    public void demo2() {
        String encrypt = Encryption.encode("sm3", data);

        System.out.println("origin: " + data);
        System.out.println("encrypt: " + encrypt);
    }


    /**
     * SM4 默认密钥加密
     */
    @Test
    public void demo4() {
        String encrypt = Encryption.encode("sm4", data);
        String decrypt = Encryption.decode("sm4", encrypt);

        System.out.println("origin: " + data);
        System.out.println("encrypt: " + encrypt);
        System.out.println("decrypt: " + decrypt);
    }

    /**
     * SM4 非对称加密
     * Key 必须为 16 位字符
     */
    @Test
    public void demo5() {
        String key = "1234567891234567";
        String encrypt = Encryption.encode("sm4", key, data);
        String decrypt = Encryption.decode("sm4", key, encrypt);

        System.out.println("origin: " + data);
        System.out.println("encrypt: " + encrypt);
        System.out.println("decrypt: " + decrypt);
    }

    @Test
    public void error1() {
        String key = "1234567891234567";
        String encrypt = Encryption.encode("sm4", key, data);
        String decrypt = Encryption.decode("sm5", key, encrypt);

        System.out.println("origin: " + data);
        System.out.println("encrypt: " + encrypt);
        System.out.println("decrypt: " + decrypt);
    }

    /**
     * SM4 对称加密
     */
    @Test
    public void test() {
        SymmetricCrypto sm4_sym = SmUtil.sm4();
        String encryptData = sm4_sym.encryptHex(data);
        String decryptData = sm4_sym.decryptStr(encryptData, CharsetUtil.CHARSET_UTF_8);

        System.out.println("origin: " + data);
        System.out.println("encrypt: " + encryptData);
        System.out.println("decrypt: " + decryptData);
    }
}
