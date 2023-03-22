package mediator;

import model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClientConnector implements Runnable
{
  private int PORT = 6969;
  private Model model;
  private boolean running;

  private ServerSocket serverSocket;

  public ChatClientConnector(int PORT, Model model) throws IOException
  {
    this.PORT = PORT;
    this.model = model;
    serverSocket = new ServerSocket(PORT);
    running =  true;
  }


  public ChatClientConnector(Model model) throws IOException
  {
    this.model = model;
    serverSocket = new ServerSocket(PORT);
    running = true;
  }

  public void run(){
    while (running)
    {
      try
      {
        Socket socket = serverSocket.accept();
        ChatClientHandler handler = new ChatClientHandler(socket, model);
        Thread thread = new Thread(handler);
        thread.start();
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
  }

  public void stop(){
    running = false;
  }
}
