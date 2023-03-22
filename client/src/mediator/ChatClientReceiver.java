package mediator;

import java.io.BufferedReader;

public class ChatClientReceiver implements Runnable
{
  private BufferedReader in;
  private ChatClient client;

  private boolean running;

  public ChatClientReceiver(ChatClient client, BufferedReader in)
  {
    this.in = in;
    this.client = client;
    this.running = true;
  }

  @Override public void run()
  {
    while (running)
    {
      try{
          String line = in.readLine();
          System.out.println(line);
          client.received(line);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
  }
}
