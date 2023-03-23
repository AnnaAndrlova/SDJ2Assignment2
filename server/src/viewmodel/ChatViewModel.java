package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class ChatViewModel
{
  private StringProperty sentMessage;

  private StringProperty receivedMessage;
  private StringProperty error;

  private Model model;

  public ChatViewModel(Model model)
  {
    this.sentMessage = new SimpleStringProperty();
    this.receivedMessage = new SimpleStringProperty();
    this.model = model;
  }

  public String getSentMessage()
  {
    return sentMessage.get();
  }

  public String getReceivedMessage()
  {
    return receivedMessage.get();
  }

  public StringProperty sentMessage()
  {
    return sentMessage;
  }

  public StringProperty receivedMessage()
  {
    return receivedMessage;
  }

  public void sendMessage()
  {
    //
  }

  public StringProperty getError()
  {
    return error;
  }
}
