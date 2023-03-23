package model;

public class User
{
  private String userName;
  private String IPAddress;

  public User(String userName){
    this.userName = userName;
    this.IPAddress = null;
  }

  public User(String userName, String IPAddress)
  {
    this.userName = userName;
    this.IPAddress = IPAddress;
  }

  public String getUserName()
  {
    return userName;
  }

  public String getIPAddress()
  {
    return IPAddress;
  }

  public void setIPAddress(String IPAddress)
  {
    this.IPAddress = IPAddress;
  }

  @Override public String toString()
  {
    return "UserPackage{" + "userName='" + userName + '\'' + ", IPAddress='" + IPAddress + '\'' + '}';
  }
}
