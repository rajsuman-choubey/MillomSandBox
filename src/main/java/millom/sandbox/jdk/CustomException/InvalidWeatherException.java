package millom.sandbox.jdk.CustomException;

public class InvalidWeatherException extends Exception {

  public InvalidWeatherException(String errorMessage) {
    super(errorMessage);
  }

}
