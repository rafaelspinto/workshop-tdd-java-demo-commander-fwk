package com.celfocus.workshops;

import org.junit.Assert;
import org.junit.Test;

public class SumCommandTest {


  @Test
  public void testExecute_NumbersArePositive_ResultShouldBePositive() throws ZeroNumberException {
    // Arrange
    int a = 10;
    int b = 10;
    SumCommand com = new SumCommand(a, b);

    // Act
    com.execute();


    // Assert
    Assert.assertTrue(com.getResult() > 0);
  }

  @Test
  public void testExecute_NumbersAreNegative_ResultShouldBeNegative() throws ZeroNumberException {
    // Arrange
    int a = -10;
    int b = -10;
    SumCommand com = new SumCommand(a, b);

    // Act
    com.execute();


    // Assert
    Assert.assertTrue(com.getResult() < 0);
  }

  @Test(expected = ZeroNumberException.class)
  public void testExecute_ArgumentsAreZero_ShouldThrowNotANumberException() throws ZeroNumberException {
    // Arrange
    int a = 0;
    int b = 10;
    SumCommand com = new SumCommand(a, b);

    // Act
    com.execute();

  }
}
