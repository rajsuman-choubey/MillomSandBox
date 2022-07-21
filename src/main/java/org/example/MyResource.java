package org.example;

import static jakarta.ws.rs.core.Response.status;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api")
public class MyResource {

  private static final Logger logger
      = (Logger) LoggerFactory.getLogger(MyResource.class);
  @Inject
  private MessageService msgService;

  @Path("/healthz")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getHelloHk2() {
    //Logs request with SLF4J.
   logger.info(String.format("Example log from %s class, get method :gethelloHk2()%s", MyResource.class.getSimpleName()));
    return msgService.getHello();
  }

  //Earth date to Curiosity sol conversion endpoint
  @GET
  @Path("/sol")
  @Produces(MediaType.TEXT_PLAIN)
  public Response curiosityDateConversion(@QueryParam("date") String date) {
    if (date == null) {
      // assign current date
      date = msgService.getTodayDate();
    }
    try {

      logger.info(String.format("request is successfull %s class,get method : curiosityDateConversion() %s",
          Status.OK, MyResource.class.getSimpleName()));
      return Response.status(Status.OK)
          .entity("request is successfull " + msgService.curiosityDateConversion(date))
          .build();

    } catch (Exception e) {
      logger.info(String.format("request is fail %s class,get method : curiosityDateConversion() %s" ,
         Status.BAD_REQUEST, MyResource.class.getSimpleName()));


      return Response.status(Status.BAD_REQUEST)
          .entity("incorrectly formatted date").build();
    }
  }
}