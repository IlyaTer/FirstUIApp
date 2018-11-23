package ui.menu.file.items.exit;

import model.CarModel;
import ui.SwingFrame;

import javax.swing.*;

public class ExitItemMenu extends JMenuItem
{
  private JDialog dialog;

  public ExitItemMenu(SwingFrame swingFrame,CarModel carModel)
  {
    super("Exit");

    addActionListener(e->
       {
         if(dialog == null)
         {
           dialog = new ExitDialog(swingFrame, carModel);
         }
         if(carModel.isChange())
         {
           dialog.setVisible(true);
         }
         else
         {
           System.exit(0);
         }
       });
  }

}
