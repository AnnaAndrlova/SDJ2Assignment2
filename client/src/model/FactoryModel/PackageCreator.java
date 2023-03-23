package model.FactoryModel;

import model.FactoryModel.Packages.CommandPackage;
import model.FactoryModel.Packages.InputPackage;
import model.FactoryModel.Packages.MessagePackage;
import model.FactoryModel.Packages.UserPackage;

public abstract class PackageCreator
{
  protected abstract InputPackage createPackage(String type, String input);
  public static InputPackage getPackage(String type, String input)
  {
    InputPackage inputPackage = null;
    switch (type){
      case "message":
        return inputPackage = new MessagePackage(type, input); //message
      case "command":
        return inputPackage = new CommandPackage(type, input); //command
      case "login":
        return inputPackage = new UserPackage(type, input); //username
      default:
        return null;
    }
  }
}
