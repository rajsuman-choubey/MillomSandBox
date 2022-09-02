package millom.sandbox.jdk.CustomException;

public class DateFormatIncorrectException extends Exception {

  public DateFormatIncorrectException(String errorMessage) {
    super(errorMessage);
  }
}
