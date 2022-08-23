package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  public Weather getWeatherMapping(String feed, String feedType, float version, String category)
      throws InvalidWeatherException {
    String marsWeatherAsString = nasaClientService.getJsonWeather(feed, feedType, version,
        category);
    return nasaMapper.deserializeWeather(marsWeatherAsString);
  }


  public boolean validateJavaDate(String strDate) {
    /* Check if date is 'null' */
    if (strDate.trim().equals("")) {
      return true;
    }
    /* Date is not 'null' */
    else {

      SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
      sdfrmt.setLenient(false);

      try {
        Date javaDate = sdfrmt.parse(strDate);
        System.out.println(strDate + " is valid date format");
      } catch (ParseException e) {
        System.out.println(strDate + " is Invalid Date format");
        return false;
      }

      return true;
    }
  }

  public Optional<Sol> getMarsWeatherForDate(String feed, String feedType, float version, String category,
      String date) throws InvalidWeatherException {

    Weather fullMarsWeather = getWeatherMapping(feed, feedType, version, category);

    Optional<Sol> sol = fullMarsWeather.getSoles().stream()
        .filter((s) -> s.getTerrestrialDate().equals(date)).findFirst();
    return sol;
  }

}