package ui;

import model.CarModel;
import writer.WriterData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitFrame extends WindowAdapter
{
  private SwingFrame swingFrame;
  private CarModel carModel;

  public ExitFrame(SwingFrame swingFrame,CarModel carModel)
  {
    this.swingFrame = swingFrame;
    this.carModel = carModel;
  }

  @Override
  public void windowClosing(WindowEvent e)
  {
    if(carModel.isChange())
    {
      int i = JOptionPane.showConfirmDialog(swingFrame,"Save before exit?", "Exit window",
                                            JOptionPane.YES_NO_OPTION);
      switch(i)
      {
        case 0:
          WriterData.write(carModel.getCarList());
          System.exit(0);
        default:
          System.exit(0);
      }
    }
    else
    {
      System.exit(0);
    }
  }//end windowC;osing

}
