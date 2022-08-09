package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.ProcessingException;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;

public class NasaClientService {

  private static final String REST_BASE_URI
      = "https://mars.nasa.gov/rss/api/";
  private static final String API_QUERY_PARAMS = "?feed=%s&feedtype=%s&ver=%.1f&category=%s";
  @Inject
  private Client client;

  public String getApiQueryParams(String feed, String feedType, float version, String category) {
    return String.format(API_QUERY_PARAMS, feed, feedType, version, category);
  }

  public String getJsonWeather(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    try {
      return client
          .target(getFullURI(feed, feedType, version, category))
          .request(MediaType.APPLICATION_JSON)
          .get(String.class);
    } catch (NotFoundException e) {
      throw new InvalidWeatherException("The requested URI is not valid.");
    } catch (ProcessingException e) {
      throw new InvalidWeatherException(
          String.format("The requested %s is not available", REST_BASE_URI));
    }
  }

  public String getFullURI(String feed, String feedType, float version, String category) {
    return String.format("%s%s", REST_BASE_URI,
        getApiQueryParams(feed, feedType, version, category));
  }
}