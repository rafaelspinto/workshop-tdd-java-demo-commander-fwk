package com.celfocus.workshops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandDisplayTest {

  private CommandInterface cmd;

  @Before
  public void setUp() {
    cmd = mock(CommandInterface.class);
    when(cmd.isAvailable()).thenReturn(true);
  }

  @Test
  public void testShow_ResultIsEmpty_ShouldDisplayErrorString() throws ZeroNumberException, CommandNotAvailableException {
    when(cmd.getResult()).thenReturn(0);

    DisplayCommand display = new DisplayCommand(cmd);

    String result = display.show();

    Assert.assertEquals("ERROR", result);
  }

  @Test
  public void testShow_ResultIsNotEmpty_ShouldDisplayValue() throws ZeroNumberException, CommandNotAvailableException {
    when(cmd.getResult()).thenReturn(12345);
    DisplayCommand display = new DisplayCommand(cmd);

    String result = display.show();

    Assert.assertEquals("12345", result);
  }

  @Test
  public void testShow_RealResultIsNotEmpty_ShouldDisplayValue() throws ZeroNumberException, CommandNotAvailableException {
    SumCommand cmd = new SumCommand(1, 12344);
    DisplayCommand display = new DisplayCommand(cmd);

    String result = display.show();

    Assert.assertEquals("12345", result);
  }

  @Test(expected = CommandNotAvailableException.class)
  public void testShow_CommandIsNotAvailable_ShouldThrowCommandNotAvailableException() throws ZeroNumberException, CommandNotAvailableException {
    when(cmd.isAvailable()).thenReturn(false);
    DisplayCommand display = new DisplayCommand(cmd);
    display.show();
  }
}
