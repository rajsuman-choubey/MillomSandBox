package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import java.util.Optional;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import millom.sandbox.mars.weather.mapper.NasaMapper;
import millom.sandbox.mars.weather.record.NasaWeather;
import millom.sandbox.mars.weather.record.Sol;

public class NasaWeatherService {

  @Inject
  private NasaClientService nasaClientService;
  @Inject
  private NasaMapper nasaMapper;

  public NasaWeather getWeatherMapping(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    String marsWeatherAsString = nasaClientService.getJsonWeather(feed, feedType, version,
        category);
    return nasaMapper.deserializeWeather(marsWeatherAsString);
  }

  public Sol getMarsWeatherForDate(String feed, String feedType, float version, String category,
      String date)
      throws InvalidWeatherException {

    NasaWeather fullMarsWeather = getWeatherMapping(feed, feedType, version, category);

    Optional<Sol> sol = fullMarsWeather.soles().stream()
        .filter((s) -> s.terrestrialDate().equals(date))
        .findFirst();
    return sol.orElse(null);
  }

}

