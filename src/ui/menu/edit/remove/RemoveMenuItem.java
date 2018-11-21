package ui.menu.edit.remove;

import ui.SwingFrame;

import javax.swing.*;

public class RemoveMenuItem extends JMenuItem
{
  private JDialog dialog;

  public RemoveMenuItem(SwingFrame swingFrame)
  {
    super("Remove");

    addActionListener(e->
       {
         if(dialog == null)
         {
           dialog = new RemoveDialog(swingFrame);
         }
         dialog.setVisible(true);
       });
  }

}
