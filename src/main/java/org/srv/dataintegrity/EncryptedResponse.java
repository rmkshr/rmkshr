package org.srv.dataintegrity;

public class EncryptedResponse {

  private String encryptedValue;

  public String getEncryptedValue() {
    return encryptedValue;
  }

  public void setEncryptedValue(String encryptedValue) {
    this.encryptedValue = encryptedValue;
  }

  @Override
  public String toString() {
    return "EncryptedResponse{" +
        "encryptedValue='" + encryptedValue + '\'' +
        '}';
  }
}
