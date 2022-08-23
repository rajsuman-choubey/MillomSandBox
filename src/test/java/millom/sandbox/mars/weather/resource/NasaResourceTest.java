package millom.sandbox.mars.weather.resource;

import static millom.sandbox.mars.weather.Utility.WeatherDataUtility.SOL1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.core.Response;
import java.util.Optional;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;

import millom.sandbox.mars.weather.Utility.WeatherDataUtility;
import millom.sandbox.mars.weather.service.NasaWeatherService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import millom.sandbox.mars.weather.pojos.Weather;

class NasaResourceTest {

  @Mock
  private NasaWeatherService nasaWeatherServiceMock;
  @InjectMocks
  private NasaResource nasaResource;

  @BeforeEach
  private void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @DisplayName("GET ALL MARS WEATHER")
  void getMarsWeather() throws InvalidWeatherException {
    when(nasaWeatherServiceMock.getWeatherMapping("weather", "json", 1.0f, "msl"))
        .thenReturn(WeatherDataUtility.WEATHER_DATA);
    Response response = nasaResource.getMarsWeather("weather", "json", 1.0f, "msl");
    verify(nasaWeatherServiceMock).getWeatherMapping("weather", "json", 1.0f, "msl");
    assertThat(response.getStatus()).isEqualTo(200);
    assertThat(response.getEntity()).isEqualTo(WeatherDataUtility.WEATHER_DATA);
    assertThat(((Weather) response.getEntity()).getSoles()).hasSize(2);
  }

  @Test
  @DisplayName("GET ALL MARS WEATHER THROWS INVALID JSON DATA EXCEPTION")
  void getMarsWeatherThrowsException() throws InvalidWeatherException {
    when(nasaWeatherServiceMock.getWeatherMapping("weather", null, 1.0f, "msl"))
        .thenThrow(new InvalidWeatherException("invalid json data"));
    Response response = nasaResource.getMarsWeather("weather", null, 1.0f, "msl");
    assertThat(response.getStatus()).isEqualTo(400);
    assertThat(response.getEntity()).isNotNull();
  }


  @Test
  @DisplayName("GET MARS WEATHER FOR A GIVEN DATE AND FEED MISMATCH")
  void getMarsWeatherForEarthDateInvalidFeed() {
    Response response = nasaResource.getMarsWeatherForEarthDate("weathr", "json", 1.0f, "msl",
        "2022-02-01");
    assertThat(response.getStatus()).isEqualTo(400);
    assertThat(response.getEntity()).isEqualTo("The input values are not valid for feed.");
  }

  @Test
  @DisplayName("GET MARS WEATHER FOR A GIVEN DATE AND INVALID DATE FORMAT")
  void getMarsWeatherForInvalidDateFormat() {
    Response response = nasaResource.getMarsWeatherForEarthDate("weathEr", "json", 1.0f, "msl",
        "2022-02-1");
    assertThat(response.getStatus()).isEqualTo(400);
    assertThat(response.getEntity()).isEqualTo("The input values are not valid for feed.");
  }

}
