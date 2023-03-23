package model.FactoryModel;

import model.FactoryModel.Packages.InputPackage;
import model.FactoryModel.Packages.MessagePackage;

public class MessagePackageCreator extends PackageCreator
{
  @Override protected InputPackage createPackage(String type, String text) throws IllegalArgumentException
  {
    return new MessagePackage(type, text);
  }

}
