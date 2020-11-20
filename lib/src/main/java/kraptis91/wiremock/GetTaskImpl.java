package kraptis91.wiremock;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/** @author Konstantinos Raptis [kraptis at unipi.gr] on 20/11/2020. */
public class GetTaskImpl implements GetTask {

  @Override
  public String getData(String url) throws Exception {

    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest httpRequest =
        HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofSeconds(30))
            .header("Accept", "application/json")
            .GET()
            .build();

    HttpResponse<String> httpResponse =
        httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

    return httpResponse.body();
  }

}
