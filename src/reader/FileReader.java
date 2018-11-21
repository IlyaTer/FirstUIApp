package reader;

import model.Car;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileReader
{
  public static void readFromFile(List<Car> carList, String path)
  {
    try(Scanner sc = new Scanner(Paths.get(path),"UTF-8"))
    {
      while(sc.hasNext())
      {
        String[] strData = sc.nextLine().split(";");
        carList.add(new Car(strData[0], strData[1], Integer.parseInt(strData[2]),
                            strData[3], Double.parseDouble(strData[4])));
      }
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
}
