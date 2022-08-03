package millom.sandbox;

import jakarta.ws.rs.core.Response;

public interface MessageService {

  String getHello();

  long curiosityDateConversion(String date);

  public String getTodayDate();
}
