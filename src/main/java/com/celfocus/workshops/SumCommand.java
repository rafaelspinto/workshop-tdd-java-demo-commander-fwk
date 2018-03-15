package com.celfocus.workshops;

public class SumCommand implements CommandInterface {
  private int result;
  private int a;
  private int b;

  public SumCommand(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public void execute() throws ZeroNumberException {

    if(a == 0 || b == 0) {
      throw new ZeroNumberException();
    }
    result = a + b;
  }

  public boolean isAvailable() {
    return true;
  }

  public int getResult() {
    return result;
  }
}
