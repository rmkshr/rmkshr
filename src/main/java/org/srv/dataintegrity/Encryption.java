//package org.srv.encryption;
//
//public class Encryption {
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
//        // String gsonResponse =new Gson().toJson(response);
//        log.info("2------"+System.currentTimeMillis());
//        encryptResponse.setEncryptedValue(EncryptionGCM.encryptData(gsonResponse));
//        log.info("AES 1"+System.currentTimeMillis());
//        return encryptResponse;
//    }
//}
