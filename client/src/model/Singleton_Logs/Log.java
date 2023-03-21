package model.Singleton_Logs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log
{
  private static Map<String, Log> map= new HashMap<>();
  private ArrayList<LogLine> logLines;
  private String filename;

  private Log(String key){
    logLines=new ArrayList<>();
    filename=key;
  }

  public void addLog(String text){
    LogLine log= new LogLine(text);
    logLines.add(log);
    addToFile(log);
    System.out.println(log);
  }

  public ArrayList<LogLine> getAll()
  {
    return logLines;
  }
  //Appending a logLine to a file (for date 15/3/2021, the file is: "Log-2021-03-15.txt")

  private void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter(filename, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  @Override public String toString()
  {
    return "Log{" + "logLines=" + logLines + '}';
  }

  public static Log getInstance(String key)
  {
    Log instance=map.get(key);
    if(instance==null){
      synchronized (map){
        instance=map.get(key);
        if(instance==null){
          instance=new Log(key);
        }
      }
    }
    return instance;
  }
}
