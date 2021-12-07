package org.srv.dataintegrity;

public class EncryptedResponse {

    public String getEncryptedValue() {
        return encryptedValue;
    }

    public void setEncryptedValue(String encryptedValue) {
        this.encryptedValue = encryptedValue;
    }

    private String encryptedValue;

    @Override
    public String toString() {
        return "EncryptedResponse{" +
                "encryptedValue='" + encryptedValue + '\'' +
                '}';
    }
}
