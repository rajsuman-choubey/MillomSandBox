package millom.sandbox.mars.weather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class MessageServiceImplTest {

  MessageServiceImpl messageServiceImpl = new MessageServiceImpl();

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCuriosityDateConversion() {
    assertEquals(3504, messageServiceImpl.curiosityDateConversion("2022-06-15"));
  }

  @Test
  void curiosityDateConversionThrowsExceptionIfDateInvalidFormat() {
    String date = "20-06-15";
    assertThrows(RuntimeException.class, () -> messageServiceImpl.curiosityDateConversion(date));
  }
}
