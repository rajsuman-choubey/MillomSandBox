package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class MessageServiceImpl implements MessageService {

  // format for ISO 8601
  private static final DateTimeFormatter ISO_FORMATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final LocalDate CURIOSITY_LANDING_DATE = LocalDate.parse("2012-08-06",
      ISO_FORMATE);

  @Override
  public String getHello() {
    return "Hello World Jersey and HK2 ";
  }

  @Override
  public long curiosityDateConversion(String date) {
    try {
      LocalDate earthDate = LocalDate.parse(date, ISO_FORMATE);
      float diff_In_Days = ChronoUnit.DAYS.between(CURIOSITY_LANDING_DATE, earthDate);
      return Math.round(diff_In_Days * 86400 / 88775.245);
    } catch (DateTimeParseException e) {

      throw new RuntimeException("Date is not in ISO 8601 format", e);
    }
  }

  public String getTodayDate() {
    return ISO_FORMATE.format(LocalDateTime.now());
  }
}