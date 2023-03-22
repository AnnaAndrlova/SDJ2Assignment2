package model;

import model.FactoryModel.MessagePackage;
import util.PropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{




  public void sendMessage(MessagePackage messagePackage);

  public void addLoggedUser(User user);

  public void removeLoggedUserByUsername(String username);

  public ArrayList<User> getAllUsers();

  public int getAmountOfLoggedUsers();
}
