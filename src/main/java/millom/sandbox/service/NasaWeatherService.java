package millom.sandbox.service;

import jakarta.inject.Inject;
import millom.sandbox.CustomException.InvalidWeatherException;
import millom.sandbox.mapper.NasaMapper;
import millom.sandbox.pojo.NasaWeather;

public class NasaWeatherService {
  @Inject
  private NasaClientService nasaClientService;
  @Inject
  private NasaMapper nasaMapper ;

  public NasaWeather getWeatherMapping(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    String marsWeatherAsString = nasaClientService.getJsonWeather(feed, feedType, version, category);
    return nasaMapper.deserializeWeather(marsWeatherAsString);
  }
}