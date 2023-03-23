package viewmodel;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.FactoryModel.Packages.ListOfUsersPackage;
import model.Model;
import model.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

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

  public void login() throws InterruptedException
  {
    //System.out.println("Hahahahaha " + getConnectedClients());


      // check if username is already taken
    //System.out.println();

      model.setUser(new User(userName.getValue()));
      model.sendUserName();
  }/*
  public void setConnectedClients(ArrayList<String> connectedClients) {
    this.connectedClients = connectedClients;
  }
  public ArrayList<String> getConnectedClients() {
    return connectedClients;
  }*/

  /*@Override public void propertyChange(PropertyChangeEvent evt)
  {
    String name = evt.getPropertyName();
    if( "arraylist".equals(name)){
      //setConnectedClients((ArrayList<String>) evt.getNewValue());
    }


  }*/
}
