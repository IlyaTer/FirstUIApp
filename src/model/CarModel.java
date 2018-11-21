package model;

import reader.FileReader;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

public class CarModel extends AbstractTableModel
{
  private List<Car> carList = new LinkedList<>();

  public CarModel()
  {
    FileReader.readFromFile(carList,"Data/Cars");
  }

  public boolean add(Car car)
  {
    if(carList.contains(car))
    {
      return false;
    }

    carList.add(car);
    fireTableDataChanged();
    return true;
  }

  public boolean contains(Car car)
  {
    return carList.contains(car);
  }

  public int indexOf(Car car)
  {
    return carList.indexOf(car);
  }

  @Override
  public int getRowCount()
  {
    return carList.size();
  }

  public void remove(int index)
  {
    carList.remove(index);
    fireTableDataChanged();
  }

  @Override
  public int getColumnCount()
  {
    return 5;
  }

  @Override
  public Object getValueAt(int rowIndex,int columnIndex)
  {
    Car car = carList.get(rowIndex);
    switch(columnIndex)
    {
      case 0:
        return car.getMark();
      case 1:
        return car.getModel();
      case 2:
        return new Integer(car.getYearOfIssue());
      case 3:
        return car.getNumber();
      case 4:
        return new Double(car.getPrice());
    }
    return null;
  }

  @Override
  public String getColumnName(int column)
  {
    switch(column)
    {
      case 0:
        return "Mark";
      case 1:
        return "Model";
      case 2:
        return "Year";
      case 3:
        return "Number";
      case 4:
        return "Price";
    }
    return "";
  }

  @Override
  public Class<?> getColumnClass(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0:
        return String.class;
      case 1:
        return String.class;
      case 2:
        return Integer.class;
      case 3:
        return String.class;
      case 4:
        return Double.class;
    }
    return Object.class;
  }

  public List<Car> getCarList()
  {
    return carList;
  }

}
