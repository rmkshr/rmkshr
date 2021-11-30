//package org.srv.encryption;
//
//public class KMSEncryption {
//
//    public static long longCrc32c(ByteString plaintextByteString) {
//        return Hashing.crc32c().hashBytes(plaintextByteString.toByteArray()).padToLong();
//    }
//
//
//    //Encryption  with  KMS
//    public static String encryptWithKMS(String plainString){
//        if(plainString !=null && !plainString.isEmpty()){
//            try(KeyManagementServiceClient client = KeyManagementServiceClient.create()){
//                ByteString plaintextByteString = ByteString.copyFrom(plainString.getBytes());
//                long crc32c =longCrc32c(plaintextByteString);
//                CryptoKeyName cryptoKeyName=getCryptoKeyName();
//                EncryptRequest encryptRequest = EncryptRequest.newBuilder()
//                        .setName(cryptoKeyName.toString())
//                        .setPlaintext(plaintextByteString)
//                        .setPlaintextCrc32C(
//                                Int64Value.newBuilder().setValue(crc32c).build())
//                        .build();
//                EncryptResponse encryptResponse = client.encrypt(encryptRequest);
//                byte[] bytes = encryptResponse.getCiphertext().toByteArray();
//                byte[] encoded = Base64.getEncoder().encode(bytes);
//                return new String(encoded);
//            }catch (Exception e){
//                log.info("Exception Raised while encryption"+e.getMessage());
//            }
//        }
//        return null;
//    }
//    //Decryption  with  KMS
//    public static String decryptWithKMS(String encryptedString){
//        if(encryptedString !=null && !encryptedString.isEmpty()){
//            try( KeyManagementServiceClient client = KeyManagementServiceClient.create()){
//                byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString.getBytes());
//                ByteString encryptedByteString = ByteString.copyFrom(encryptedBytes);
//                long crc32c =longCrc32c(encryptedByteString);
//                CryptoKeyName cryptoKeyName=getCryptoKeyName();
//                DecryptRequest decryptRequest =
//                        DecryptRequest.newBuilder()
//                                .setName(cryptoKeyName.toString())
//                                .setCiphertext(encryptedByteString)
//                                .setCiphertextCrc32C(
//                                        Int64Value.newBuilder().setValue(crc32c).build())
//                                .build();
//                DecryptResponse decryptResponse= client.decrypt(decryptRequest);
//                return new String(decryptResponse.getPlaintext().toByteArray());
//            }catch (Exception e){
//                log.info("Exception Raised while decryption");
//            }
//        }
//        return null;
//    }
//}
