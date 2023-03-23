package model.FactoryModel;

import model.User;

import java.util.ArrayList;

public class ListOfUsersPackage
{
  private ArrayList<User> usersArrayList;
  private String type;

  public ListOfUsersPackage(String type,
      ArrayList<User> userPackageArrayList)
  {
    this.usersArrayList = userPackageArrayList;
    this.type = type;
  }


  public ArrayList<User> getUserPackageArrayList()
  {
    return usersArrayList;
  }

  public String getType()
  {
    return type;
  }

  @Override public String toString()
  {
    return "ListOfUsersPackage{"
        + ", userPackageArrayList=" + usersArrayList + ", type='" + type
        + '\'' + '}';

  }
}
