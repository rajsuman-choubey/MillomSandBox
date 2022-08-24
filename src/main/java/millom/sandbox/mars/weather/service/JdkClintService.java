package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;
import millom.sandbox.mars.weather.CustomException.JdkException;

public class JdkClintService {

  private static final String REST_BASE_URI
      = "https://api.adoptopenjdk.net/v3/info/release_names";

  private static final String API_QUERY_PARAMS =
      "?architecture=%s&heap_size=normal&image_type=jdk&page=%d&page_size=10&project=jdk&release_type=ga&sort_method=DEFAULT&sort_order=DESC&vendor=adoptopenjdk";

  @Inject
  private Client client;

  public String getJdkJsonReleaseNames(String architecture, int page)
      throws JdkException {
    try {
      return client
          .target(getFullURI(architecture, page))
          .request(MediaType.APPLICATION_JSON)
          .get(String.class);
    } catch (NotFoundException e) {
      return null;
    } catch (ProcessingException e) {
      throw new JdkException(
          String.format("The requested %s is not available", REST_BASE_URI));
    }
  }

  public String getApiQueryParams(String architecture, int page) {
    return String.format(API_QUERY_PARAMS, architecture, page);
  }

  public String getFullURI(String architecture, int page) {
    return String.format("%s%s", REST_BASE_URI,
        getApiQueryParams(architecture, page));
  }
}

