package kraptis91.wiremock;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

/** @author Konstantinos Raptis [kraptis at unipi.gr] on 20/11/2020. */
public class GetTaskTest {

  @Rule
  public WireMockRule wireMockRule =
      new WireMockRule(options().port(9000).bindAddress("localhost"));

  InputStream inputStream =
      GetTaskTest.class.getResourceAsStream("/mock/json/cars.json");

  @Test
  public void testGetData() throws Exception {

    Gson gson = new Gson();
    Object jsonObject = gson.fromJson(new InputStreamReader(inputStream), Object.class);
    String jsonResponse = gson.toJson(jsonObject);

    // System.out.println(jsonResponse);

    stubFor(
        get(urlEqualTo("/all_cars"))
            .withHeader("Accept", equalTo("application/json"))
            .willReturn(
                aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(jsonResponse)));

    GetTask task = TaskFactory.createGetFromECertisTask();
    String stringResponse = task.getData("http://localhost:9000/all_cars");

    // System.out.println(stringResponse);
    Assert.assertEquals(jsonResponse, stringResponse);
  }
}
