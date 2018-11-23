package ui.menu.edit.add;

import model.Car;
import model.CarModel;
import ui.SwingFrame;

import javax.swing.*;

public class AddMenuItem extends JMenuItem
{
  private JDialog dialog;

  public AddMenuItem(SwingFrame swingFrame,CarModel carModel)
  {
    super("Add");

    addActionListener(e->
       {
         if(dialog == null)
         {
           dialog = new AddDialog(swingFrame, carModel);
         }
         dialog.setVisible(true);
       });
  }

}
