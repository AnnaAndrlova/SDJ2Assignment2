package model.FactoryModel.Packages;

public class MessagePackage extends InputPackage
{
  private String message;

  public MessagePackage(String type, String message)
  {
    super(type);
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }

  @Override public String toString()
  {
    return "MessagePackage{" + "message='" + message + '\'' + '}';
  }
}
