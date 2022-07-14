package encryption.nifi;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class NIFIEncryption {

    public static final String DEFAULT_FLOW_ALGORITHM = "PBEWITHMD5AND256BITAES-CBC-OPENSSL";
    public static final String DEFAULT_PROVIDER = BouncyCastleProvider.PROVIDER_NAME;
    // nififtw! 是 nifi 默认的密钥
    public static final String DEFAULT_KEYS = "nififtw!";

    static {
        try {
            Security.addProvider(new BouncyCastleProvider());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Encryption() throws Exception {
        String plaintext = "123456";
        byte[] saltBytes = DEFAULT_KEYS.getBytes();
        // 生成密钥实例
        Cipher encryptCipher = generateFlowEncryptionCipher(plaintext);
        // 加密内容
        String encryptResult = encryptFlowElement(plaintext, saltBytes, encryptCipher);
        System.out.println(encryptResult);

        String decryptedElement = NIFIDecryption.decryptFlowElement(encryptResult, DEFAULT_KEYS);
        System.out.println(decryptedElement);
    }

    /**
     * 生成加密实例
     *
     * @param password 新的加密密码
     */
    public static Cipher generateFlowEncryptionCipher(String password) throws Exception {
        Cipher encryptCipher = Cipher.getInstance(DEFAULT_FLOW_ALGORITHM, DEFAULT_PROVIDER);
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DEFAULT_FLOW_ALGORITHM, DEFAULT_PROVIDER);
        SecretKey pbeKey = keyFactory.generateSecret(keySpec);
        byte[] saltBytes = DEFAULT_KEYS.getBytes();
        PBEParameterSpec parameterSpec = new PBEParameterSpec(saltBytes, 1000);
        encryptCipher.init(Cipher.ENCRYPT_MODE, pbeKey, parameterSpec);
        return encryptCipher;
    }

    /**
     * 加密
     *
     * @param plaintext     明文
     * @param saltBytes
     * @param encryptCipher 加密实例
     */
    public static String encryptFlowElement(String plaintext, byte[] saltBytes, Cipher encryptCipher) throws Exception {
        byte[] plainBytes = plaintext.isEmpty() ? plaintext.getBytes(StandardCharsets.UTF_8) : new byte[0];
        byte[] cipherBytes = encryptCipher.doFinal(plainBytes);
        byte[] saltAndCipherBytes = concatByteArrays(saltBytes, cipherBytes);
        return Hex.encodeHexString(saltAndCipherBytes);
    }

    public static byte[] concatByteArrays(byte[]... arrays) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (byte[] bytes : arrays) {
            outputStream.write(bytes);
        }
        return outputStream.toByteArray();
    }
}
