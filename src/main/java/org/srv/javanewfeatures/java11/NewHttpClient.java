package org.srv.javanewfeatures.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class NewHttpClient {

  //The new HTTP client from the java.net.http package was introduced in Java 9. It has now become a standard feature in Java 11.
  //The new HTTP API improves overall performance and provides support for both HTTP/1.1 and HTTP/2:

  HttpClient httpClient = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .connectTimeout(Duration.ofSeconds(20))
      .build();
  HttpRequest httpRequest = HttpRequest.newBuilder()
      .GET()
      .uri(URI.create("http://localhost:" + "8080"))
      .build();
  HttpResponse httpResponse;

  {
    try {
      httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
