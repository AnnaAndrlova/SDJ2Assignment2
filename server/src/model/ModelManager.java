package model;

import mediator.ChatClientConnector;
import model.FactoryModel.MessagePackage;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model, PropertyChangeSubject
{
  private UserList loggedUsers;

  private PropertyChangeSupport propertyChangeSupport;

  public ModelManager() throws IOException
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
    loggedUsers = new UserList();
    ChatClientConnector chatClientConnector = new ChatClientConnector(this);
    Thread thread = new Thread(chatClientConnector);
    thread.start();
  }

  public void sendMessage(MessagePackage messagePackage){
    propertyChangeSupport.firePropertyChange("message", null, messagePackage);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public ArrayList<User> getAllUsers()
  {
    return loggedUsers.getAllUsers();
  }

  @Override public int getAmountOfLoggedUsers()
  {
    return loggedUsers.size();
  }

  @Override public void addLoggedUser(User user)
  {
    loggedUsers.addUser(user);
  }

  @Override public void removeLoggedUserByUsername(String username)
  {
    loggedUsers.removeUserByUsername(username);
  }
}
