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
      StringBuffer writeStr = new StringBuffer();
      for(Car car: carList)
      {
        writeStr.append(car.getMark());
        writeStr.append(";");
        writeStr.append(car.getModel());
        writeStr.append(";");
        writeStr.append(car.getYearOfIssue());
        writeStr.append(";");
        writeStr.append(car.getNumber());
        writeStr.append(";");
        writeStr.append(car.getPrice());
        writeStr.append("\n");
      }

      writer.write(writeStr.toString());
    }
    catch(IOException ex){

      System.out.println(ex.getMessage());
    }
  }
}
