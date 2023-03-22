package viewmodel;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class LoginViewModel
{
  private Model model;
  private StringProperty userName;
  private StringProperty error;
  private PropertyChangeSupport property;
  private ArrayList<String> connectedClients;


  public LoginViewModel(Model model)
  {
    this.model = model;
    this.userName = new SimpleStringProperty();
    this.error = new SimpleStringProperty();
    this.property = new PropertyChangeSupport(this);
    //model.addListenerToClient(this);
    connectedClients = new ArrayList<>();
  }

  public void clearName()
  {
    userName.set("");
  }

  public StringProperty getUserNameProperty()
  {
    return userName;
  }

  public void clear()
  {
    error.set("");
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

}
