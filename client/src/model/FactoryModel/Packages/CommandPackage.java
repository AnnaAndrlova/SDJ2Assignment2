package model.FactoryModel.Packages;

public class CommandPackage extends InputPackage
{
  private String command;

  public CommandPackage(String type, String command){
    super(type);
    this.command = command;
  }

  public String getCommand(){
    return command;
  }
}
