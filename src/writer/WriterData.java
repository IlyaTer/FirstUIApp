package writer;

import model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterData
{
  public static void write(List<Car> carList)
  {
    try(FileWriter writer = new FileWriter("Data/Cars",false))
    {
      String writeStr = "";
      for(Car car: carList)
      {
        writeStr += car.getMark()+";"+car.getModel()+
                ";"+car.getYearOfIssue()+
                ";"+car.getNumber()+
                ";"+car.getPrice();
        writeStr += "\n";
      }

      writer.write(writeStr);
      writer.flush();
    }
    catch(IOException ex){

      System.out.println(ex.getMessage());
    }
  }
}
