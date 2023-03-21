package model;

import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;
  public final String HOST = "localhost";
  public final int PORT = 6969;

  public ModelManager()
  {
    this.property = new PropertyChangeSupport(this);;
  }

  @Override public String receiveMessage()
  {
    return null;
  }

  @Override public String sendMessage()
  {
    return null;
  }
}
