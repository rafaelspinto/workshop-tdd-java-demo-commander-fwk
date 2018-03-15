package com.celfocus.workshops;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class SumCommandTest {

  @DataProvider
  public static Object[][] myProvider() {
    return new Object[][] {
        {0, 0},
        {100, 0},
        {0, 300}
    };
  }


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

  @Test(expected = ZeroNumberException.class)
  @UseDataProvider("myProvider")
  public void testExecute_ArgumentAAndOrBAreZero_ShouldThrowNotANumberException(int a, int b) throws ZeroNumberException {
    SumCommand com = new SumCommand(a, b);

    // Act
    com.execute();

  }
}
