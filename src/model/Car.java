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

}
