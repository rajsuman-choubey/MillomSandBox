package millom.sandbox.mars.weather.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.core.Response;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import millom.sandbox.mars.weather.Utility.WeatherDataUtility;
import millom.sandbox.mars.weather.record.NasaWeather;
import millom.sandbox.mars.weather.service.NasaWeatherService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
  void getMarsWeather() throws InvalidWeatherException {
    when(nasaWeatherServiceMock.getWeatherMapping("weather", "json", 1.0f, "msl"))
        .thenReturn(WeatherDataUtility.WEATHER_DATA);
    Response response = nasaResource.getMarsWeather("weather", "json", 1.0f, "msl");
    verify(nasaWeatherServiceMock).getWeatherMapping("weather", "json", 1.0f, "msl");
    assertThat(response.getStatus()).isEqualTo(200);
    assertThat(response.getEntity()).isEqualTo(WeatherDataUtility.WEATHER_DATA);
    Assertions.assertThat(((NasaWeather) response.getEntity()).soles()).hasSize(2);
  }

  @Test
  void getMarsWeatherThrowsException() throws InvalidWeatherException {
    when(nasaWeatherServiceMock.getWeatherMapping("weather", null, 1.0f, "msl"))
        .thenThrow(new InvalidWeatherException("invalid json data"));
    Response response = nasaResource.getMarsWeather("weather", null, 1.0f, "msl");
    assertThat(response.getStatus()).isEqualTo(500);
    assertThat(response.getEntity()).isNotNull();
  }
}
