package millom.sandbox.CustomException;

public class DateFormatIncorrectException extends Exception {
  public DateFormatIncorrectException(String errorMessage) {
    super(errorMessage);
}
}
