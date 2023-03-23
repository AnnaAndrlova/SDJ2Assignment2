package model.FactoryModel;

public class CommandPackageCreator extends PackageCreator
{
  @Override protected InputPackage createPackage(String type, String command)
  {
    return new CommandPackage(type, command);
  }
}
