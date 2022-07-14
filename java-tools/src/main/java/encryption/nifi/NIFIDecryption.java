package encryption.nifi;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;

public class NIFIDecryption {

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
    public void Decryption() throws Exception {
        String encryptText = "aeb1696aa1f1cb70db947104136ec4929a25731320badd3101d066de2610e93a";
        System.out.println(encryptText);
        System.out.println(decryptFlowElement(encryptText, DEFAULT_KEYS));
    }

    /**
     * 生成解密实例
     *
     * @param password  用于解密的密文
     * @param saltBytes
     */
    public static Cipher generateFlowDecryptionCipher(String password, byte[] saltBytes) throws Exception {
        Cipher decryptCipher = Cipher.getInstance(DEFAULT_FLOW_ALGORITHM, DEFAULT_PROVIDER);
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DEFAULT_FLOW_ALGORITHM, DEFAULT_PROVIDER);
        SecretKey pbeKey = keyFactory.generateSecret(keySpec);
        PBEParameterSpec parameterSpec = new PBEParameterSpec(saltBytes, 1000);
        decryptCipher.init(Cipher.DECRYPT_MODE, pbeKey, parameterSpec);
        return decryptCipher;
    }

    /**
     * 解密
     *
     * @param wrappedCipherText 加密后的十六进制密文
     * @param password          用于解密的密文
     */
    public static String decryptFlowElement(String wrappedCipherText, String password) throws Exception {
        byte[] cipherBytes = Hex.decodeHex(wrappedCipherText.toCharArray());
        byte[] keySpec = Arrays.copyOfRange(cipherBytes, 0, 16);
        byte[] newCipherBytes = Arrays.copyOfRange(cipherBytes, 16, cipherBytes.length);
        Cipher decryptionCipher = generateFlowDecryptionCipher(password, keySpec);
        byte[] plainBytes = decryptionCipher.doFinal(newCipherBytes);
        return new String(plainBytes, StandardCharsets.UTF_8);
    }
}
