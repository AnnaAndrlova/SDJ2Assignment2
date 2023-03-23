package model;

import mediator.ChatClient;
import model.FactoryModel.PackageCreator;
import model.FactoryModel.Packages.InputPackage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ModelManager implements Model, PropertyChangeListener

{
  private PropertyChangeSupport property;
  public final String HOST = "localhost";
  public final int PORT = 6969;
  private ChatClient chatClient;
  private User user;

  public ModelManager () throws IOException
  {
    this.property = new PropertyChangeSupport(this);
    this.chatClient = new ChatClient(this, HOST, PORT);
  }


  @Override public void sendMessage(String message)
  {
   chatClient.sendMessage(message);
  }


  @Override public void sendUserName()
  {
   chatClient.sendUserName();
  }
  @Override public Object getAllUsers()
  {
   chatClient.getAllUsers();
   return null;
  }

  @Override public void getNumberOfConnectedUsers()
  {
    chatClient.getNumberOfConnectedUsers();
  }


  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    property.firePropertyChange(evt);
  }

  public User getUser(){
    return user;
  }


  @Override public void addListenerToClient(PropertyChangeListener listener)
  {
    chatClient.addListener(listener);
  }

  @Override public void removeListenerFromClient(
      PropertyChangeListener listener)
  {
    chatClient.removeListener(listener);
  }

  public void setUser(User user){
    this.user = user;
  }

  @Override public void receive()
  {
    chatClient.addListener(this);
  }
}
