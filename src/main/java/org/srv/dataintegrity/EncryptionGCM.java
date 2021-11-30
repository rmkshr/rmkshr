//package org.srv.dataintegrity;
//
//public class EncryptionGCM {
//
//
//    public static EncryptResponse encryptAESGCM(Object response) throws Exception {
//
//        log.info("Original Response"+response);
//
//        EncryptResponse encryptResponse = new EncryptResponse();
//        log.info("AES"+System.currentTimeMillis());
//        ObjectMapper mapper=new ObjectMapper();
//        String gsonResponse=mapper.writeValueAsString(response);
//        log.info("Mapper Response"+gsonResponse);
//
//
//        //
//        // String gsonResponse =new Gson().toJson(response);
//        log.info("2------"+System.currentTimeMillis());
//        encryptResponse.setEncryptedValue(encryptData(gsonResponse));
//        log.info("AES 1"+System.currentTimeMillis());
//        return encryptResponse;
//    }
//
//    public static String encryptData(String data) throws Exception {
//
//        Configuration configuration = ofy().load().type(Configuration.class).filter("name", "GCM_Enc_Dec_Key").first().now();
//        String key = configuration.getValue();
//
//        byte[] iv = new byte[GCM_IV_LENGTH];
//        (new SecureRandom()).nextBytes(iv);
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        byte[] key2 = md.digest(key.getBytes(StandardCharsets.UTF_8));
//
//        // Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key2, "AES");
//
//        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
//        GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
//
//        byte[] ciphertext = cipher.doFinal(data.getBytes("UTF8"));
//        byte[] encrypted = new byte[iv.length + ciphertext.length];
//
//        System.arraycopy(iv, 0, encrypted, 0, iv.length);
//        System.arraycopy(ciphertext, 0, encrypted, iv.length, ciphertext.length);
//
//        String encoded = Base64.getEncoder().encodeToString(encrypted);
//
//        return encoded;
//    }
//
//    public static String decryptData(String data) throws Exception
//    {
//        Configuration configuration = ofy().load().type(Configuration.class).filter("name", "GCM_Enc_Dec_Key").first().now();
//        String key = configuration.getValue();
//
//        byte[] iv2 = Base64.getDecoder().decode(data.substring(0, 16));
//        byte[] cipherByte = Base64.getDecoder().decode(data.substring(16));
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        byte[] key2 = md.digest(key.getBytes(StandardCharsets.UTF_8));
//        // Get Cipher Instance
//        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
//
//        // Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key2, "AES");
//        // Create GCMParameterSpec
//        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv2);
//
//        // Initialize Cipher for DECRYPT_MODE
//        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
//
//        // Perform Decryption
//        byte[] decryptedText = cipher.doFinal(cipherByte);
//
//        return new String(decryptedText);
//    }
//
//}
