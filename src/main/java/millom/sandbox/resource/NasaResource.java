package millom.sandbox.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import millom.sandbox.CustomException.InvalidWeatherException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import millom.sandbox.service.NasaWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/nasaapi")
public class NasaResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(NasaResource.class);

  @Inject
  private NasaWeatherService nasaWeatherService;

  @Path("/mars/weather/")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getMarsWeather(@QueryParam("feed") String feed,
      @QueryParam("feedtype") String feedType,
      @QueryParam("version") float version, @QueryParam("category") String category) {

    if (feed == null || feed.length() == 0 || !feed.equals("weather")) {
      return getErrorResponse("feed");
    }
    if (feedType == null || feedType.length() == 0 || !feedType.equals("json")) {
      return getErrorResponse("feedType");
    }
    String versionToString = String.valueOf(version);

    if (!versionToString.matches("^(\\d)*(?:\\.\\d)?$")) {
      return getErrorResponse("version");
    }
    if (category == null || category.length() < 2 || category.length() > 5) {
      return getErrorResponse("category");
    }

    try {
      LOGGER.info(
          String.format("Task-3: Success message from Nasa API -- %s class and  get method: %s()",
              Thread.currentThread().getStackTrace()[1].getClassName(),
              Thread.currentThread().getStackTrace()[1].getMethodName()));
      return Response.
          status(Status.OK)
          .entity(nasaWeatherService.getWeatherMapping(feed, feedType, version, category))
          .build();
    } catch (InvalidWeatherException e) {
      LOGGER.info(String.format("Task-3: Exception occurred in -- %s class and  get method: %s()",
          Thread.currentThread().getStackTrace()[1].getClassName(),
          Thread.currentThread().getStackTrace()[1].getMethodName()));
      return Response.
          status(Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage())
          .build();
    }
  }

  private Response getErrorResponse(String inputField) {
    return Response.
        status(Status.INTERNAL_SERVER_ERROR)
        .entity(String.format("The input values are not valid for %s.", inputField))
        .build();
  }
}