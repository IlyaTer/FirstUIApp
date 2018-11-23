package ui.menu.edit.remove;

import model.CarModel;
import ui.SwingFrame;

import javax.swing.*;

public class RemoveMenuItem extends JMenuItem
{
  private JDialog dialog;

  public RemoveMenuItem(SwingFrame swingFrame,CarModel carModel)
  {
    super("Remove");

    addActionListener(e->
       {
         if(dialog == null)
         {
           dialog = new RemoveDialog(swingFrame, carModel);
         }
         dialog.setVisible(true);
       });
  }

}
