package millom.sandbox.mars.weather.service;

import static millom.sandbox.mars.weather.Utility.WeatherDataUtility.SOL1;
import static millom.sandbox.mars.weather.Utility.WeatherDataUtility.SOL2;
import static net.bytebuddy.implementation.MethodDelegation.to;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.stream.Stream;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;               //InvalidWeatherException;
import millom.sandbox.mars.weather.Utility.JsonUtility;
import millom.sandbox.mars.weather.Utility.WeatherDataUtility;
import millom.sandbox.mars.weather.mapper.NasaMapper;
import millom.sandbox.mars.weather.record.NasaWeather;
import millom.sandbox.mars.weather.record.Sol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class NasaWeatherServiceTest {
  @Mock
  private NasaWeatherService nasaWeatherServiceMock;
  @Mock
  private NasaClientService nasaClientService;
  @Mock
  private NasaMapper nasaMapper;
  @InjectMocks
  private NasaWeatherService nasaWeatherService;

  @BeforeEach
  private void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getWeatherMapping() throws InvalidWeatherException, IOException {
    String responseString = JsonUtility.getSampleResponse("response.json");
    when(nasaClientService.getJsonWeather("weather", "json", 1.0f, "msl")).
        thenReturn(responseString);
    when(nasaMapper.deserializeWeather(responseString)).
        thenReturn(WeatherDataUtility.WEATHER_DATA);
    NasaWeather response = nasaWeatherService.getWeatherMapping("weather", "json", 1.0f, "msl");
    assertThat(response).isNotNull();
    assertThat(response.soles().hashCode());
    assertThat(response.descriptions().lsDescEn()). isEqualTo("\n\t\t\t\tA Martian year lasts about two Earth's year, which is the time\n\t\t\t\tMars takes to orbit the Sun. Solar longitude is an angle that\n\t\t\t\tgives the position of Mars on its orbit.\t\t\t\t  \n\t\t\t");
  }
  @ParameterizedTest
  @MethodSource("dateToSol")
  @DisplayName("GET MARS WEATHER FOR A GIVEN DATE WITH 2 PARAMETERS")
  void getMarsWeatherForDate(String date, Sol expected) throws InvalidWeatherException {
    doReturn(WeatherDataUtility.WEATHER_DATA).when(nasaWeatherServiceMock)
        .getWeatherMapping(anyString(), anyString(), anyFloat(), anyString());
    Sol actual = nasaWeatherServiceMock.getMarsWeatherForDate("weather", "json", 1.0f, "msl", date);
    assertThat(actual).isEqualTo(expected);
    verify(nasaWeatherServiceMock).getWeatherMapping("weather", "json", 1.0f, "msl");
  }

  @Test
  @DisplayName("GET MARS WEATHER FOR A GIVEN DATE AND INVALID DATE FORMAT")
  void getMarsWeatherForInvalidDate() throws InvalidWeatherException {
    doReturn(WeatherDataUtility.WEATHER_DATA).when(nasaWeatherServiceMock)
        .getWeatherMapping(anyString(), anyString(), anyFloat(), anyString());
    Sol actual = nasaWeatherServiceMock.getMarsWeatherForDate("weather", "json", 1.0f, "msl",
        "2022-07-03");
    assertThat(actual).isNull();
    verify(nasaWeatherServiceMock).getWeatherMapping("weather", "json", 1.0f, "msl");
  }

  @Test
  @DisplayName("GET MARS WEATHER FOR A GIVEN DATE AND DATE NOT PRESENT IN THE LIST")
  void getMarsWeatherForDateNotPresent() throws InvalidWeatherException {
    doReturn(WeatherDataUtility.WEATHER_DATA).when(nasaWeatherServiceMock)
        .getWeatherMapping(anyString(), anyString(), anyFloat(), anyString());
    Sol actual = nasaWeatherServiceMock.getMarsWeatherForDate("weather", "json", 1.0f, "msl",
        "2011-07-03");
    assertThat(actual).isNull();
    verify(nasaWeatherServiceMock).getWeatherMapping("weather", "json", 1.0f, "msl");
  }

  private static Stream<Arguments> dateToSol() {
    return Stream.of(
        Arguments.of("2022-07-01", SOL1),
        Arguments.of("2022-07-02", SOL2)
    );
  }
}
