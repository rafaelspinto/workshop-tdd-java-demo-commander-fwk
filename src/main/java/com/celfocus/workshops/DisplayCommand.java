package com.celfocus.workshops;

public class DisplayCommand {
  private CommandInterface cmd;

  public DisplayCommand(CommandInterface cmd) {

    this.cmd = cmd;
  }

  public String show() throws ZeroNumberException {
    cmd.execute();
    if(cmd.getResult() == 0) {
      return "ERROR";
    }

    return cmd.getResult() + "";
  }
}
