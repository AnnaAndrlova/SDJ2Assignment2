package model.FactoryModel;

public class NumberPackage
{
  private String type;
  private int value;

  public NumberPackage(String type, int value)
  {
    this.type = type;
    this.value = value;
  }

  public String getType()
  {
    return type;
  }

  public int getValue()
  {
    return value;
  }
}
