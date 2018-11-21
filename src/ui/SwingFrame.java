package ui;

import model.CarModel;
import ui.menu.GeneralMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;


public class SwingFrame extends JFrame
{
  private JTable table;
  private JMenuBar bar;
  private CarModel carList;
  private int changeCount;

  public SwingFrame()
  {
    setLocationByPlatform(true);

    bar = new GeneralMenu(this);
    add(bar, BorderLayout.NORTH);

    carList = new CarModel();
    table = new JTable(carList);
    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);

    WindowListener listener = new ExitFrame();
    ((ExitFrame) listener).setSwingFrame(this);
    addWindowListener(listener);

    pack();
  }//end constructor

  public JTable getTable()
  {
    return table;
  }

  public CarModel getCarList()
  {
    return carList;
  }

  public void addCange()
  {
    changeCount++;
  }

  public int getChangeCount()
  {
    return changeCount;
  }

}
