package org.srv.dataintegrity;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class AESUtils {
    public static final String algorithm = "AES/CBC/PKCS5Padding";
//    public static final String algorithm = "AES/GCM/NoPadding";

    /**
     * This method is used to generate a secret key for encryption based on the provided password and salt value.
     * @param password
     * @param salt
     * @return SecretKey
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static SecretKey generateSecretKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey secretKey = new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), "AES");
        return secretKey;
    }

    /**
     * Initializing vector for data encryption.
     * @return IvParameterSpec
     */
    public static IvParameterSpec generateIvParameterSpec() {
        byte[] iv = new byte[16];
        (new SecureRandom()).nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
