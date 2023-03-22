package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.LoginViewModel;

public class LoginViewController
{
  private @FXML TextField userName;
  private @FXML Label errorMessage;
  private Region root;
  private LoginViewModel viewModel;
  private ViewHandler viewHandler;

  @FXML public void logIn()
  {
    viewHandler.openView("Chat");
    viewModel.login();
  }

  public void init(ViewHandler viewHandler, LoginViewModel viewModel,
      Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    userName.textProperty().bindBidirectional(viewModel.getUserNameProperty());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
  }
}
