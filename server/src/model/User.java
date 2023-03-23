package model;

public class User
{
  private String userName;
  private String IPAddress;

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

  @Override public String toString()
  {
    return "User{" + "userName='" + userName + '\'' + ", IPAddress='" + IPAddress + '\'' + '}';
  }
}
