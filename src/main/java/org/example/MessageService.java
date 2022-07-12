package org.example;

import jakarta.ws.rs.core.Response;

public interface MessageService {
  public String getHello() ;
 public long curiosityDateConversion(String date);
   public String getTodayDate();
}
