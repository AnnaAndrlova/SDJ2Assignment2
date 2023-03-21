package model.FactoryModel;

public class MessagePackage extends InputPackage
{
  private String message;
  public MessagePackage(String type, String message){
    super(type);
    this.message = message;
  }

  public String getMessage(){
    return message;
  }


}
