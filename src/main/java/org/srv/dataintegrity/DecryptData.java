package org.srv.dataintegrity;


import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DecryptData {

  public static final Logger logger = Logger.getLogger(DecryptData.class.getName());

  /**
   * Function used to Decrypt Data.
   *
   * @param cipherText
   * @param secretKey
   * @param ivParameterSpec
   * @return decrypt
   * @throws NoSuchPaddingException
   * @throws NoSuchAlgorithmException
   * @throws InvalidAlgorithmParameterException
   * @throws InvalidKeyException
   * @throws BadPaddingException
   * @throws IllegalBlockSizeException
   */
  public static String decrypt(String cipherText,
      SecretKey secretKey,
      IvParameterSpec ivParameterSpec)
      throws NoSuchPaddingException,
      NoSuchAlgorithmException,
      InvalidAlgorithmParameterException,
      InvalidKeyException,
      BadPaddingException,
      IllegalBlockSizeException {

    Cipher cipher = Cipher.getInstance(AESUtils.algorithm);
    cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
    byte[] plainText = cipher.doFinal(Base64.getDecoder()
        .decode(cipherText));
    return new String(plainText);
  }

}
