package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class LoginViewModel
{
  private Model model;
  private StringProperty userName;
  private StringProperty error;

  public LoginViewModel(Model model)
  {
    this.model = model;
    this.userName = new SimpleStringProperty();
    this.error = new SimpleStringProperty();
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
