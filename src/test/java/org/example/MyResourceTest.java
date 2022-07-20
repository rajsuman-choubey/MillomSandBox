package org.example;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class MyResourceTest {

  @Mock
  private MessageService messageServiceMock;
  private MessageService msgServiceImpl;

  @InjectMocks
  MyResource myResource = new MyResource();

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    msgServiceImpl = new MessageServiceImpl();
  }

  @Test
  @DisplayName("CONVERT EARTH DATE TO CURIOSITY SOL DATE")
  void testCuriosityDateConversion() {
    when(messageServiceMock.curiosityDateConversion("2022-06-15")).thenReturn(3504L);
    Response response = myResource.curiosityDateConversion("2022-06-15");
    assertEquals(response.getStatus(), Status.OK.getStatusCode());
    assertEquals(response.getEntity(), "request is successfull 3504");
  }

  @Test
  void CuriosityDateConversionIfDateNull() {
    String date = msgServiceImpl.getTodayDate();
    long days = msgServiceImpl.curiosityDateConversion(date);
    String actual = "request is successfull "+ days;
    when(messageServiceMock.getTodayDate()).thenReturn(date);
    when(messageServiceMock.curiosityDateConversion(date)).thenReturn(days);

    Response response = myResource.curiosityDateConversion(null);
    assertEquals(response.getStatus(), Status.OK.getStatusCode());
    assertEquals(response.getEntity(), actual);
  }

  @Test
  void TestCuriosityDateConversionThrowsException() {
    String date = "2022-";
    when(messageServiceMock.curiosityDateConversion(date)).thenThrow(new RuntimeException());
    Response response = myResource.curiosityDateConversion(date);
    assertEquals(response.getStatus(), Status.BAD_REQUEST.getStatusCode());
    assertEquals(response.getEntity(), "incorrectly formatted date");
  }
  private static URI getBaseURI(String path) {
    return UriBuilder.fromUri("http://localhost:8080/" + path).build();
  }
}

