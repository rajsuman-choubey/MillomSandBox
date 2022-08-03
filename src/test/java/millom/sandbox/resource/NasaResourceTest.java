package millom.sandbox.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.core.Response;
import millom.sandbox.CustomException.InvalidWeatherException;
import millom.sandbox.Utility.WeatherDataUtility;
import millom.sandbox.pojo.NasaWeather;
import millom.sandbox.service.NasaWeatherService;
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
    when(nasaWeatherServiceMock.getWeatherMapping("weather","json",1.0f,"msl"))
        .thenReturn(WeatherDataUtility.WEATHER_DATA);
    Response response = nasaResource.getMarsWeather("weather","json",1.0f,"msl");
    verify(nasaWeatherServiceMock).getWeatherMapping("weather","json",1.0f,"msl");
    assertThat(response.getStatus()).isEqualTo(200);
    assertThat(response.getEntity()).isEqualTo(WeatherDataUtility.WEATHER_DATA);
    assertThat(((NasaWeather)response.getEntity()).getSoles()).hasSize(2);
  }

  @Test
  void getMarsWeatherThrowsException() throws InvalidWeatherException {
    when(nasaWeatherServiceMock.getWeatherMapping("weather",null,1.0f,"msl"))
        .thenThrow(new InvalidWeatherException("invalid json data"));
    Response response = nasaResource.getMarsWeather("weather",null,1.0f,"msl");
    assertThat(response.getStatus()).isEqualTo(500);
    assertThat(response.getEntity()).isNotNull();
  }
}
