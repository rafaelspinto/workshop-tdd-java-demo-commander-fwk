package com.celfocus.workshops;

public interface CommandInterface {

  int getResult();
  void execute() throws ZeroNumberException;
}
