package millom.sandbox.mars.weather.CustomException;

public class DateFormatIncorrectException extends Exception {

  public DateFormatIncorrectException(String errorMessage) {
    super(errorMessage);
  }
}
