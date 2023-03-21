package model.FactoryModel;

public class MessagePackageCreator extends PackageCreator
{
  @Override protected InputPackage createPackage(String type, String text) throws IllegalArgumentException
  {
    return new MessagePackage(type, text);
  }

}
