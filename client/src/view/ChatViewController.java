package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ChatViewModel;

public class ChatViewController
{
  @FXML private TextField message;
  @FXML private ListView<String> chat;
 // @FXML private Label errorLabel;


  private Region root;

  private ChatViewModel chatViewModel;
  private ViewHandler viewHandler;

  public ChatViewController()
  {
  }

  public void init(ViewHandler viewHandler,
      ChatViewModel chatViewModel, Region root)
  {
    this.chatViewModel = chatViewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    message.textProperty()
        .bindBidirectional(chatViewModel.sentMessage());
    //chat.cellFactoryProperty().bindBidirectional(chatViewModel.getReceivedMessage());

    message.textProperty()
        .bindBidirectional(chatViewModel.sentMessage());
    chat.setItems(chatViewModel.getMessages());



  }

  public void reset()
  {
    message.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void onEnter(ActionEvent actionEvent)
      throws InterruptedException
  {
    chatViewModel.sendMessage();
    reset();
  }

  @FXML private void send() throws InterruptedException
  {
    chatViewModel.sendMessage();
    reset();

  }

  @FXML private void onSubmit() throws InterruptedException
  {
    chatViewModel.sendMessage();
  }

}
