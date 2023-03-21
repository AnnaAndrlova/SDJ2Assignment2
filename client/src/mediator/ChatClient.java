package mediator;

import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import model.Model;

public class ChatClient implements Model
{
  private Model model;

  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;

  private boolean waiting;
  private PropertyChangeSupport property;

  public ChatClient(Model model, String host, int port) throws IOException
  {
this.model = model;
this.gson = new Gson();
this.property = new PropertyChangeSupport(this);
this.socket = new Socket(host, port);
this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
this.out = new PrintWriter(socket.getOutputStream(), true);
ChatClientReceiver chatClientReceiver = new ChatClientReceiver(this, in);
Thread readerThread = new Thread(chatClientReceiver);
readerThread.setDaemon(true);
readerThread.start();
  }

  public void disconnect(){

  }

//  private PLACEHOLDER_Package waitingForReply(){
//
//  }


  public void received(String line)
  {

  }

  @Override public String receiveMessage()
  {
    return null;
  }

  @Override public String sendMessage()
  {
    return null;
  }
}
