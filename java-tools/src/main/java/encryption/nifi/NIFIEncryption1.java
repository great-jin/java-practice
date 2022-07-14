package encryption.nifi;


import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class NIFIEncryption1 {

    private static final String DEFAULT_FLOW_ALGORITHM = "PBEWITHMD5AND256BITAES-CBC-OPENSSL";
    private static final String DEFAULT_PROVIDER = BouncyCastleProvider.PROVIDER_NAME;

    static {
        try {
            Security.addProvider(new BouncyCastleProvider());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // 随机生成 16 位的盐
        byte[] encryptionSalt = new byte[16];
        new SecureRandom().nextBytes(encryptionSalt);
        // nififtw! 为 nifi 定义的口令, 可以自己修改
        Cipher cipher = getCipher("nififtw!", encryptionSalt);
        // test 为需要加密的密码
        String pass = encryptFlowElement("123456", encryptionSalt, cipher);
        System.out.println(pass);
    }

    private static String encryptFlowElement(String plaintext, byte[] saltBytes, Cipher encryptCipher) throws Exception {
        byte[] plainBytes = plaintext.getBytes(StandardCharsets.UTF_8);
        byte[] cipherBytes = encryptCipher.doFinal(plainBytes);
        byte[] saltAndCipherBytes = conByteArray(saltBytes, cipherBytes);
        return Hex.encodeHexString(saltAndCipherBytes);
    }

    // 这个 password 是口令
    private static Cipher getCipher(String password, byte[] saltBytes) throws Exception {
        Cipher encryptCipher = Cipher.getInstance(DEFAULT_FLOW_ALGORITHM, DEFAULT_PROVIDER);
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DEFAULT_FLOW_ALGORITHM, DEFAULT_PROVIDER);
        SecretKey pbeKey = keyFactory.generateSecret(keySpec);
        PBEParameterSpec parameterSpec = new PBEParameterSpec(saltBytes, 1000);
        encryptCipher.init(Cipher.ENCRYPT_MODE, pbeKey, parameterSpec);
        return encryptCipher;
    }

    public static byte[] conByteArray(byte[] arr1, byte[] arr2) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(arr1);
        outputStream.write(arr2);
        return outputStream.toByteArray();
    }
}