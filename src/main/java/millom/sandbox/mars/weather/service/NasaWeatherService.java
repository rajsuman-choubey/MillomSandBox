package millom.sandbox.mars.weather.service;
import jakarta.inject.Inject;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import java.util.Optional;
import millom.sandbox.mars.weather.mapper.NasaMapper;
import pojos.Weather;
import pojos.Sol;

public class NasaWeatherService {

  @Inject
  private NasaClientService nasaClientService;
  @Inject
  private NasaMapper nasaMapper;


  public Weather getWeatherMapping(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    String marsWeatherAsString = nasaClientService.getJsonWeather(feed, feedType, version,
        category);
    return nasaMapper.deserializeWeather(marsWeatherAsString);
  }

  public Sol getMarsWeatherForDate(String feed, String feedType, float version, String category,
      String date)
      throws InvalidWeatherException {

    Weather fullMarsWeather = getWeatherMapping(feed, feedType, version, category);

    Optional<Sol> sol = fullMarsWeather.getSoles().stream()
        .filter((s) -> s.getTerrestrialDate().equals(date))
        .findFirst();
    return sol.orElse(null);
  }

}
