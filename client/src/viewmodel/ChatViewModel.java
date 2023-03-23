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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ChatViewModel implements PropertyChangeListener
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
    model.addListenerToClient(this);
    messages = FXCollections.observableArrayList();
    this.listOfUsers = new ArrayList<>();
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

  public void sendMessage() throws InterruptedException
  {

    if (sentMessage.getValue().startsWith("/number"))
    {
      model.getNumberOfConnectedUsers();
    }
    else if (sentMessage.getValue().startsWith("/list"))
    {
      model.getAllUsers();
    }
    else {
      model.sendMessage(sentMessage.getValue());
    }
  }



  public StringProperty getError()
  {
    return error;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    String name = evt.getPropertyName();
    String value = (String) evt.getNewValue();

    if( "newMessage".equals(name)){
      Platform.runLater(() -> {
        messages.add(value);
      });
    }

    else if( "number".equals(name)){
      Platform.runLater(() -> {
        messages.add(value);
      });
    }

    else if( "list".equals(name))

      Platform.runLater(() -> {
        messages.add(value);
      });

  }
}
