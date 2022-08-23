package millom.sandbox.mars.weather.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.Optional;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import millom.sandbox.mars.weather.service.NasaWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import millom.sandbox.mars.weather.pojos.Sol;

@Path("/nasaapi")
public class NasaResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(NasaResource.class);

  @Inject
  private NasaWeatherService nasaWeatherService;

  @Path("/mars/weather/")
  @GET
  @Produces(MediaType.APPLICATION_JSON)

  public Response getMarsWeather(
      @QueryParam("feed") String feed,
      @QueryParam("feedtype") String feedType,
      @QueryParam("version") float version,
      @QueryParam("category") String category) {

    Optional<Response> errorResponse = validate(feed, feedType, version, category);
    if (errorResponse.isPresent()) {
      return errorResponse.get();
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

  @Path("/earthdate/marsweather/")
  @GET
  @Produces(MediaType.APPLICATION_JSON)

  public Response getMarsWeatherForEarthDate(
      @QueryParam("feed") String feed,
      @QueryParam("feedtype") String feedType,
      @QueryParam("version") float version,
      @QueryParam("category") String category,
      @QueryParam("date") String date) {

    Optional<Response> errorResponse = validate(feed, feedType, version, category);
    if (errorResponse.isPresent()) {
      return errorResponse.get();
    }
    Boolean isValidDate = nasaWeatherService.validateJavaDate(date);
    /*if (date || date.length() == 0 || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
      return getErrorResponse("date").get();
  }*/
    if (!nasaWeatherService.validateJavaDate(date)) {
      return getErrorResponse("date").get();
    }

    try {
      LOGGER.info(
          String.format("Task-4: Success message from Nasa API -- %s class and  get method: %s()",
              Thread.currentThread().getStackTrace()[1].getClassName(),
              Thread.currentThread().getStackTrace()[1].getMethodName()));
      Optional<Sol> sol = nasaWeatherService.getMarsWeatherForDate(feed, feedType, version,
          category, date);
      if (sol.isEmpty()) {
        return Response.
            status(Status.NOT_FOUND)
            .entity("The given date doesn't have any information in the mars weather report.")
            .build();
      }
      return Response.
          status(Response.Status.OK)
          .entity(sol)
          .build();
    } catch (InvalidWeatherException e) {
      LOGGER.info(String.format("Task-4: Exception occurred in -- %s class and  get method: %s()",
          Thread.currentThread().getStackTrace()[1].getClassName(),
          Thread.currentThread().getStackTrace()[1].getMethodName()));
      return Response.
          status(Status.BAD_REQUEST)
          .entity(e.getMessage())
          .build();
    }
  }

  private Optional<Response> validate(String feed, String feedType, float version,
      String category) {

    if (feed == null || !feed.equals("weather")) {
      return getErrorResponse("feed");
    }
    if (feedType == null || !feedType.equals("json")) {
      return getErrorResponse("feedType");
    }
    String versionToString = String.valueOf(version);

    if (category == null || category.length() < 2 || category.length() > 5) {
      return getErrorResponse("category");
    }
    return Optional.empty();
  }

  private Optional<Response> getErrorResponse(String inputField) {
    return Optional.ofNullable(Response.
        status(Status.BAD_REQUEST)
        .entity(String.format("The input values are not valid for %s.", inputField))
        .build());
  }
}