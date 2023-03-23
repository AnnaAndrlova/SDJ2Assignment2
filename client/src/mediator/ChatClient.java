package mediator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import model.FactoryModel.*;
import model.FactoryModel.Packages.InputPackage;
import model.Model;
import model.FactoryModel.Packages.ListOfUsersPackage;
import model.FactoryModel.Packages.MessagePackage;
import model.FactoryModel.Packages.NumberPackage;
import model.User;

public class ChatClient implements ClientModel
{
  //TODO: Check if user is registered
  //TODO: Store the chats (aka the logs) in a file
  //TODO: Remove the server GUI
  //TODO:
  private Model model;

  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;
  private PropertyChangeSupport property;
  private ArrayList<User> allUsers;
  private ArrayList<MessagePackage> receivedMessage;

  public ChatClient(Model model, String host, int port) throws IOException
  {
    this.model = model;
    this.gson = new Gson();
    this.property = new PropertyChangeSupport(this);
    this.socket = new Socket(host, port);
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);

    ChatClientReceiver chatClientReceiver = new ChatClientReceiver(this, in);

    Thread readerThread = new Thread(chatClientReceiver);
    readerThread.setDaemon(true);
    readerThread.start();

    allUsers = null;
    this.receivedMessage = new ArrayList<>();
  }

  public void disconnect() throws IOException
  {
    in.close();
    out.close();
    socket.close();
  }

  public synchronized void received(String line)
  {

    if (gson.fromJson(line, Map.class).get("type").equals("list"))
    {

      ListOfUsersPackage reply = gson.fromJson(line, ListOfUsersPackage.class);
      allUsers = reply.getUserPackageArrayList();
      String users = "Users: ";
      for(int i = 0; i<allUsers.size(); i++){
        users = users + "\n user "+ i + ": " +allUsers.get(i).getUserName();
      }
      property.firePropertyChange("list", false, users);
    }
    /*
    else if(gson.fromJson(line, Map.class).get("type").equals("list")){
      ListOfUsersPackage reply = gson.fromJson(line, ListOfUsersPackage.class);
      allUsers = reply.getUserPackageArrayList();
      property.firePropertyChange("arraylist", false, allUsers);
    }*/
    else if (gson.fromJson(line, Map.class).get("type").equals("number"))
    {
      int reply = gson.fromJson(line, NumberPackage.class).getValue();
      property.firePropertyChange("number", false, reply + "");
    }
    else
    {
      MessagePackage messagePackage = gson.fromJson(line, MessagePackage.class);
      receivedMessage.add(messagePackage);
      property.firePropertyChange("newMessage", false, messagePackage.getMessage());
    }

  }

  @Override public void sendMessage(String message)
  {
    InputPackage inputPackage = PackageCreator.getPackage("message", message);
    out.println(gson.toJson(inputPackage));
  }

  @Override public void getAllUsers()
  {
    InputPackage inputPackage = PackageCreator.getPackage("command", "list");
    out.println(gson.toJson(inputPackage));
  }

  @Override public void getNumberOfConnectedUsers()
  {
    InputPackage inputPackage = PackageCreator.getPackage("command", "number");
    out.println(gson.toJson(inputPackage));
  }

  public void sendUserName()
  {
    InputPackage inputPackage = PackageCreator.getPackage("login", model.getUser().getUserName());
    out.println(gson.toJson(inputPackage));

  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}
