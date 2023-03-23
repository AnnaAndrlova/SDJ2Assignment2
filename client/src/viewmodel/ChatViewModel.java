package viewmodel;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.User;

public class ChatViewModel
{
  private StringProperty sentMessage;

  private ListProperty receivedMessage;
  private ObservableList<String> messages;
  private StringProperty error;
  private ArrayList<User> listOfUsers;


  private Model model;

  public ChatViewModel(Model model)
  {
    this.sentMessage = new SimpleStringProperty();
    this.receivedMessage = new SimpleListProperty<>();
    this.model = model;
  }

  public String getSentMessage()
  {
    return sentMessage.get();
  }


  public ObservableList<String> getMessages() {
    return messages;
  }



  public StringProperty sentMessage()
  {
    return sentMessage;
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
