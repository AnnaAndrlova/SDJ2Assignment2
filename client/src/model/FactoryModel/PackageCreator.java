package model.FactoryModel;

public abstract class PackageCreator
{
  protected abstract InputPackage createPackage(String type, String text);
  public static InputPackage getPackage(String type, String input)
  {
    InputPackage inputPackage = null;
    switch (type){
      case "message":
        inputPackage = new MessagePackage(type, input);
      case "command":
        return inputPackage = new CommandPackage(type, input); //command
      case "login":
        return inputPackage = new UserPackage(type, input); //username
      default:
        return null;
    }
  }
}
