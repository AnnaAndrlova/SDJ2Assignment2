package model.FactoryModel.Packages;

import model.User;

import java.util.ArrayList;

public class ListOfUsersPackage
{
  private int numberOfUsers;
  private ArrayList<User> usersArrayList;
  private String type;

  public ListOfUsersPackage(String type,
      ArrayList<User> userPackageArrayList)
  {
    this.numberOfUsers = 0;
    this.usersArrayList = new ArrayList<>();
    this.type = type;
  }

  public int getNumberOfUsers()
  {
    return numberOfUsers;
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
    return "ListOfUsersPackage{" + "numberOfUsers=" + numberOfUsers
        + ", userPackageArrayList=" + usersArrayList + ", type='" + type
        + '\'' + '}';
  }
}
