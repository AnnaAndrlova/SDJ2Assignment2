package mediator;


import com.google.gson.Gson;
import model.FactoryModel.*;
import model.Model;
import model.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class ChatClientHandler implements Runnable, PropertyChangeListener
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Model model;
  private boolean running;
  private Gson gson;
  private User user;

  public ChatClientHandler(Socket socket, Model model) throws IOException
  {
    this.model = model;
    this.socket = socket;
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
    gson = new Gson();
    model.addListener(this);
    running = true;
  }

  @Override public void run()
  {

    while (running)
    {
      try
      {
        String message = in.readLine();
        System.out.println(message);
        InputPackage inputPackage = gson.fromJson(message, InputPackage.class);
        if (Objects.equals(inputPackage.getType(), "message"))
        {
          {
            MessagePackage messagePackage = gson.fromJson(message,
                MessagePackage.class);
            model.sendMessage(messagePackage);

          }
        }
        else if (inputPackage.getType().equals("command")){
          CommandPackage commandPackage = gson.fromJson(message, CommandPackage.class);
          if (commandPackage.getCommand().equals("number")){
            NumberPackage numberPackage = new NumberPackage("number", model.getAmountOfLoggedUsers());
            out.println(gson.toJson(numberPackage));

          }
          else if (commandPackage.getCommand().equals("list")){
            ListOfUsersPackage usersPackage = new ListOfUsersPackage("list", model.getAllUsers());
            //System.out.println(model.getAllUsers());
            //System.out.println(usersPackage);
            out.println(gson.toJson(usersPackage));
          }
        }
        else if (inputPackage.getType().equals("login")){
          UserPackage userPackage = gson.fromJson(message, UserPackage.class);
          String address = socket.getRemoteSocketAddress().toString();

          User user = new User(userPackage.getUserName(), address);
          this.user = user;
          model.addLoggedUser(user);
        }
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
      //aa

    }
  }

  public void close()
  {
    running = false;
    try
    {
      model.removeLoggedUserByUsername(user.getUserName());
      in.close();
      out.close();
      socket.close();
    }
    catch (IOException e)
    {
      //
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    switch (evt.getPropertyName()){
      case "message":
        MessagePackage messagePackage = (MessagePackage) evt.getNewValue();
        out.println(gson.toJson(messagePackage));
    }
  }
}
