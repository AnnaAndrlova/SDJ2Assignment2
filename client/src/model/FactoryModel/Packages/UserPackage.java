package model.FactoryModel.Packages;

public class UserPackage extends InputPackage
{
  private String userName;

  public UserPackage(String type, String username)
  {
    super(type);
    userName = username;
  }

  public String getUserName()
  {
    return userName;
  }
}
