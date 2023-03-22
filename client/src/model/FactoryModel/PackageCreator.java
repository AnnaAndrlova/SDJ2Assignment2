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
        inputPackage = new CommandPackage(type, input);
      default:
        return null;
    }
  }
}
