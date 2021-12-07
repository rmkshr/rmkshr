package org.srv.dataintegrity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class EncryptionTest {

    @Test
    void givenString_whenEncrypt_thenSuccess()
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeySpecException {

        String input = "S.R.V";
        SecretKey key = AESUtils.generateSecretKey("vihaan","ram");
        IvParameterSpec ivParameterSpec = AESUtils.generateIvParameterSpec();
        String cipherText = EncryptData.encrypt(input, key, ivParameterSpec);
        System.out.println(cipherText);
        String plainText = DecryptData.decrypt(cipherText, key, ivParameterSpec);
        System.out.println(plainText);
        Assertions.assertEquals(input, plainText);
    }

    @Test
    void testAESGCM() throws Exception {
        String input = AESGCM.encryptData("SRV");
        String output = AESGCM.decryptData(input);
        Assertions.assertEquals("SRV",output);
    }
}
