package model;

import java.beans.PropertyChangeListener;

public interface Model
{
  public void sendUserName();
  public void sendMessage(String message);
  public Object getAllUsers() throws InterruptedException;
  public void getNumberOfConnectedUsers();
  public User getUser();
  public void addListenerToClient(PropertyChangeListener listener);
  public void removeListenerFromClient(PropertyChangeListener listener);
  public void setUser(User user);
  public void receive();

}
