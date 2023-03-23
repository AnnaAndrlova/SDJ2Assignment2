package model.Singleton_Logs;

import model.User;

public class LogLine
{
  private String text;
  private DateTime dateTime;
  private User user;

  public LogLine(String text){
    this.text = text;
    dateTime = new DateTime();
  }

  public String getText()
  {
    return text;
  }

  public DateTime getDateTime()
  {
    return dateTime;
  }

  @Override public String toString()
  {
    return user+"\t"+dateTime+"\t"+text ;
  }
}
