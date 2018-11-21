package ui;

import writer.WriterData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitFrame extends WindowAdapter
{
  private SwingFrame swingFrame;

  public void setSwingFrame(SwingFrame swingFrame)
  {
    this.swingFrame = swingFrame;
  }

  @Override
  public void windowClosing(WindowEvent e)
  {
    if(swingFrame.getChangeCount() > 0)
    {
      int i = JOptionPane.showConfirmDialog(swingFrame,"Save before exit?");
      switch(i)
      {
        case 0:
          WriterData.write(swingFrame.getCarList().getCarList());
          System.exit(0);
        case 1:
          System.exit(0);
        case 3:
          System.exit(0);
      }
    }
    else
    {
      System.exit(0);
    }
  }

}
