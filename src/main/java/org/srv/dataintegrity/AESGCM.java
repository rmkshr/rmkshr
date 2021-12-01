package org.srv.dataintegrity;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class AESGCM {


    /**
     * Used to encrypt the response object using AES GCM algorithm.
     * @param response
     * @return encryptResponse.
     * @throws Exception
     */
    public static EncryptedResponse encryptAESGCM(Object response) throws Exception {
        EncryptedResponse encryptResponse = new EncryptedResponse();
        ObjectMapper mapper=new ObjectMapper();
        String gsonResponse=mapper.writeValueAsString(response);
        encryptResponse.setEncryptedValue(encryptData(gsonResponse));
        return encryptResponse;
    }

    /**
     * Encrypt data with AES GCM algorithm.
     * @param data
     * @return encoded.
     * @throws Exception
     */
    public static String encryptData(String data) throws Exception {
        String key = "all hail srv";

        byte[] iv = new byte[12];
        (new SecureRandom()).nextBytes(iv);

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] key2 = messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));

        SecretKeySpec secretKeySpec = new SecretKeySpec(key2, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);

        byte[] ciphertext = cipher.doFinal(data.getBytes("UTF8"));
        byte[] encrypted = new byte[iv.length + ciphertext.length];

        System.arraycopy(iv, 0, encrypted, 0, iv.length);
        System.arraycopy(ciphertext, 0, encrypted, iv.length, ciphertext.length);

        String encoded = Base64.getEncoder().encodeToString(encrypted);

        return encoded;
    }

    /**
     * Method to decrypt data using AES GCM Algorithm.
     * @param data
     * @return decryptedText.
     * @throws Exception
     */
    public static String decryptData(String data) throws Exception
    {
        String key = "all hail srv";

        byte[] iv = Base64.getDecoder().decode(data.substring(0, 16));
        byte[] cipherByte = Base64.getDecoder().decode(data.substring(16));

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] key2 = md.digest(key.getBytes(StandardCharsets.UTF_8));

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        SecretKeySpec keySpec = new SecretKeySpec(key2, "AES");

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);

        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        byte[] decryptedText = cipher.doFinal(cipherByte);

        return new String(decryptedText);
    }

}
