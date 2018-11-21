package ui.menu.file.items.exit;

import ui.SwingFrame;

import javax.swing.*;

public class ExitItemMenu extends JMenuItem
{
  private JDialog dialog;

  public ExitItemMenu(SwingFrame swingFrame)
  {
    super("Exit");

    addActionListener(e->
       {
         if(dialog == null)
         {
           dialog = new ExitDialog(swingFrame);
         }
         if(swingFrame.getChangeCount() > 0)
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
