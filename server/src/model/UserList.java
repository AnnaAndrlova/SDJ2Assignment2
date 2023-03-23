package model;

import java.util.ArrayList;
import java.util.Objects;

public class UserList
{
  private ArrayList<User> users;

  public UserList(){
    users =new ArrayList<>();
  }

  public void addUser(User user){
    users.add(user);
  }

  public ArrayList<User> getAllUsers(){
    return users;
  }

  public void removeUserByUsername(String username){
    for (User user: users){
      if (Objects.equals(user.getUserName(), username)){
        users.remove(user);
        break;
      }
    }
  }
  public int size(){
    return users.size();
  }
}
