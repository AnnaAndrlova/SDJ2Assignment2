package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private ChatViewController chatWindowController;
  private LoginViewController loginWindowController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("Chat");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "Chat":
        root = loadChatView("ChatView.fxml");
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadLoginView(String fxmlFile)
  {
    Region root = null;
    if (loginWindowController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        loginWindowController = loader.getController();
        loginWindowController.init(this, viewModelFactory.getLoginViewModel(),
            root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      loginWindowController.reset();
    }
    return loginWindowController.getRoot();
  }
  private Region loadChatView(String fxmlFile)
  {
    Region root = null;
    if (chatWindowController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        chatWindowController = loader.getController();
        chatWindowController.init(this,  viewModelFactory.getChatViewModel(),
            root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      chatWindowController.reset();
    }
    return chatWindowController.getRoot();
  }
}
