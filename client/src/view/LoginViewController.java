package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.User;
import viewmodel.LoginViewModel;

public class LoginViewController
{
  private @FXML TextField userName;
  private @FXML Label errorMessage;
  private Region root;
  private LoginViewModel viewModel;
  private ViewHandler viewHandler;

  @FXML public void logIn() throws InterruptedException
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

  @FXML private void onEnter(ActionEvent actionEvent)
      throws InterruptedException
  {
    viewHandler.openView("Chat");
    viewModel.login();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
  }
}
