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

  public SwingFrame(CarModel carModel)
  {
    setLocationByPlatform(true);

    bar = new GeneralMenu(this, carModel);
    add(bar, BorderLayout.NORTH);

    table = new JTable(carModel);
    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);

    WindowListener listener = new ExitFrame(this, carModel);
    addWindowListener(listener);

    pack();
  }//end constructor

  public JTable getTable()
  {
    return table;
  }

}
