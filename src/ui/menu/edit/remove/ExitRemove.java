package ui.menu.edit.remove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitRemove extends WindowAdapter
{
  private JDialog parent;

  public ExitRemove(JDialog parent)
  {
    this.parent = parent;
  }

  @Override
  public void windowClosing(WindowEvent e)
  {
    for(Component c : parent.getContentPane().getComponents())
    {
      if(c instanceof JPanel)
      {
        JPanel jPanel = (JPanel) c;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
        {
          Component inComp = jPanel.getComponent(i);
          if(inComp instanceof JTextField)
          {
            ((JTextField) inComp).setText("");
          }
        }//end in for
      }//end out if
    }//end for
  }
}
