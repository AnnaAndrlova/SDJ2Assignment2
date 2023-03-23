package model.FactoryModel;

public class InputPackage
{
  private String type;


  public InputPackage(String type){
    this.type = type;
  }

  public String getType(){
    return this.type;
  }

  @Override public String toString(){
    return type;
  }
}
