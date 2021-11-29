//package org.srv.encryption;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Base64;
//
//public class TwoFish {
//
//    public static String encrypt(String toEncrypt)  {
//        try {
//            String key = "S2V5IHNpemUgbGVzcyB0aGFuIDY0IGJpdHM=";
//
//            // create a binary key from the argument key (seed)
//            byte[] keyData = key.getBytes();
//            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
//
//
//            // create an instance of cipher
//            Cipher cipher = Cipher.getInstance("Blowfish");
//
//            // initialize the cipher with the key
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//
//            // enctypt!
//            byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
//
//            return new String(Base64.getEncoder().encode(encrypted));
//        } catch (Exception e){
//            log.info("Encryption"+e);
//            return null;
//        }
//    }
//
//    public static String decrypt(String toDecrypt) {
//        try {
//            //log.info("Values"+toDecrypt);
//            if(toDecrypt!=null){
//                String key = "S2V5IHNpemUgbGaVzcyB0aGFuIDY0IGJpdHM=";
//                // create a binary key from the argument key (seed)
//                byte[] keyData = key.getBytes();
//                SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
//
//                // do the decryption with that key
//                Cipher cipher = Cipher.getInstance("Blowfish");
//                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//                byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(toDecrypt));
//
//                return new String(decrypted);}
//            else
//                return "";
//        } catch (Exception e) {
//            log.info("Decryption"+e);
//            return null;
//        }
//    }
//}
