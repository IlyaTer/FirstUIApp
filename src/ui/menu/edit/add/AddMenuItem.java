package ui.menu.edit.add;

import model.Car;
import ui.SwingFrame;

import javax.swing.*;

public class AddMenuItem extends JMenuItem
{
  private JDialog dialog;

  public AddMenuItem(SwingFrame swingFrame)
  {
    super("Add");

    addActionListener(e->
       {
         if(dialog == null)
         {
           dialog = new AddDialog(swingFrame);
         }
         dialog.setVisible(true);
       });
  }

}
