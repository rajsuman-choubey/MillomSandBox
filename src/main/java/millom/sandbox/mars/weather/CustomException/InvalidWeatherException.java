package millom.sandbox.mars.weather.CustomException;

public class InvalidWeatherException extends Exception {

  public InvalidWeatherException(String errorMessage) {
    super(errorMessage);
  }

}
