package ui.menu.edit.add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitAdd extends WindowAdapter
{
  private JDialog parent;

  public ExitAdd(JDialog parent)
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
        if(jPanel.getComponentCount() == 10)
        {
          for(int i = 0; i < 10; i++)
          {
            Component inComp = jPanel.getComponent(i);
            if(inComp instanceof JTextField)
            {
              ((JTextField) inComp).setText("");
            }
          }//end in for
        }//end in if
      }//end out if
    }//end for
  }

}
