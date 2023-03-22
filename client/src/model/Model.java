package model;

import util.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;

public interface Model
{
  public void sendUserName();
  public void sendMessage(String message);
  public void getAllUsers() throws InterruptedException;
  public void getNumberOfConnectedUsers();
  public User getUser();
  public void addListenerToClient(PropertyChangeListener listener);
  public void removeListenerFromClient(PropertyChangeListener listener);
  public void setUser(User user);

}
