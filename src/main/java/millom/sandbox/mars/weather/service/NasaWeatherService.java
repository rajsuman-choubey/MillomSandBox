package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import java.util.Optional;
import millom.sandbox.mars.weather.mapper.NasaMapper;
import millom.sandbox.mars.weather.pojos.Weather;
import millom.sandbox.mars.weather.pojos.Sol;

public class NasaWeatherService {

  @Inject
  private NasaClientService nasaClientService;
  @Inject
  private NasaMapper nasaMapper;
  private String dateFormat;


  public boolean isValid(String dateStr) {
    try {
      LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(this.dateFormat));
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

  public Weather getWeatherMapping(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    String marsWeatherAsString = nasaClientService.getJsonWeather(feed, feedType, version,
        category);
    return nasaMapper.deserializeWeather(marsWeatherAsString);
  }

  public Optional<Sol> getMarsWeatherForDate(String feed, String feedType, float version, String dateStr,
      String date)
      throws InvalidWeatherException {

    Weather fullMarsWeather = getWeatherMapping(feed, feedType, version, dateStr
    );

    Optional<Sol> sol = fullMarsWeather.getSoles().stream()
        .filter((s) -> s.getTerrestrialDate().equals(date))
        .findFirst();
    return sol;

  }


}
