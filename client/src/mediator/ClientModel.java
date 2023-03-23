package mediator;

import model.User;
import util.UnnamedPropertyChangeSubject;

public interface ClientModel extends UnnamedPropertyChangeSubject
{
  public void getAllUsers() throws InterruptedException;
  public void getNumberOfConnectedUsers();
  public void sendMessage(String message);
  public void sendUserName();
}
