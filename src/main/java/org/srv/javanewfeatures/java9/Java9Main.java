package org.srv.javanewfeatures.java9;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Java9Main {

  public static void main(String[] args) {

    //Quick GET Request
    //The API uses the Builder pattern, which makes it really easy for quick use:

    try {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("https://postman-echo.com/get"))
          .GET()
          .build();
      CompletableFuture<Void> voidCompletableFuture = HttpClient.newHttpClient()
          .sendAsync(request, HttpResponse.BodyHandlers.ofFile(
              Paths.get("/Users/ramkishoremadheshwaran/Local/httplog.rtf")))
          .thenApply(HttpResponse::body).thenAccept(System.out::println);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    //java.util.Set.of() – creates an immutable set of a given elements
    //It is immutable – if we try to add or remove elements,
    //an UnsupportedOperationException will be thrown.

    Set<String> stringKeySet = Set.of("Ram", "Sugan", "Vihaan");

    //Optional to Stream
    //java.util.Optional.stream()
    //gives us an easy way to you use the power of Streams on Optional elements:

    Optional<List<String>> listOfOptionals = Optional.of(List.of("Ram", "Sugan", "Vihaan"));
    List<String> filteredList = listOfOptionals.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
    System.out.println(filteredList);
  }


}
