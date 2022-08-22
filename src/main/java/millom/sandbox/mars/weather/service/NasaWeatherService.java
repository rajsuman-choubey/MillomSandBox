package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
  private String date;

  public boolean isValid(String date) {
    LocalDate earthDate;
    // format for ISO 8601
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    if(date == null){
      // assign current date
      date = format.format(LocalDateTime.now());
    }
    try {
      earthDate = LocalDate.parse(date, format);


    } catch (DateTimeParseException e) {
      throw new RuntimeException(e);
    }

    return true;
  }

  public Weather getWeatherMapping(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    String marsWeatherAsString = nasaClientService.getJsonWeather(feed, feedType, version,
        category);
    return nasaMapper.deserializeWeather(marsWeatherAsString);
  }

  public Optional<Sol> getMarsWeatherForDate(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {

    Weather fullMarsWeather = getWeatherMapping(feed, feedType, version, category);

    Optional<Sol> sol = fullMarsWeather.getSoles().stream()
        .filter((s) -> s.getTerrestrialDate().equals())
        .findFirst();
    return sol;
  }}