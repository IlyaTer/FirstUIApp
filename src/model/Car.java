package model;

public class Car
{
  private String mark;
  private String model;
  private int yearOfIssue;
  private String number;
  private double price;

  public Car(String mark,String model,int yearOfIssue,String number, double price)
  {
    this.mark = mark;
    this.model = model;
    this.yearOfIssue = yearOfIssue;
    this.number = number;
    this.price = price;
  }


  @Override
  public boolean equals(Object obj)
  {
    if(obj == this)
    {
      return true;
    }
    else if(obj instanceof Car)
    {
      return number.equals(((Car) obj).number);
    }
    else
    {
      return false;
    }
  }

  @Override
  public int hashCode()
  {
    int res = 17;
    res = 31 * res + number.hashCode();
    return res;
  }

  public String getMark()
  {
    return mark;
  }

  public void setMark(String mark)
  {
    this.mark = mark;
  }

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public int getYearOfIssue()
  {
    return yearOfIssue;
  }

  public void setYearOfIssue(int yearOfIssue)
  {
    this.yearOfIssue = yearOfIssue;
  }

  public String getNumber()
  {
    return number;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

}
