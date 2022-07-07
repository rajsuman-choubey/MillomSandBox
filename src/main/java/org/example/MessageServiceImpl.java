package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MessageServiceImpl implements MessageService{

  private static final LocalDate baselineDate = LocalDate.parse("2012-08-06",
      DateTimeFormatter.ofPattern("yyyy-MM-dd"));

  @Override
  public String getHello() {
    return "Hello World Jersey and HK2 ";
  }

  @Override
  public int curiosityDateDateConversion(String processingDate) {
    float diff_In_Days ;
    LocalDate earthDate;
    // format for ISO 8601
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    if(processingDate == null){
      // assign current date
      processingDate = format.format(LocalDateTime.now());
    }

    //validating Processing date w.r.t baselineDate considering processingDate is passed from input
//    if (processingDate == baselineDate){
//      logger.info("Example log from "+  MyService.class.getSimpleName() +" class, get method : convertCuriositySol()");
//    }
    //Calculating no of days between Input(processingDate) and baseline date

    earthDate = LocalDate.parse(processingDate, format);
    diff_In_Days = ChronoUnit.DAYS.between(baselineDate , earthDate);

    return (int) Math.round(diff_In_Days * 86400 / 88775.245);
  }

}
