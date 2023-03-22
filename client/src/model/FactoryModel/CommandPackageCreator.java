package model.FactoryModel;

import model.FactoryModel.Packages.CommandPackage;
import model.FactoryModel.Packages.InputPackage;

public class CommandPackageCreator extends PackageCreator
{
  @Override protected InputPackage createPackage(String type, String command)
  {
    return new CommandPackage(type, command);
  }
}
