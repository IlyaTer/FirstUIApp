package ui.menu.about.items;

import ui.SwingFrame;

import javax.swing.*;

public class InfoItem extends JMenuItem
{
  public InfoItem(SwingFrame swingFrame)
  {
    super("Info");

    addActionListener(e ->
       {
         JOptionPane.showMessageDialog(swingFrame,"Creator: Terekhof Ilya!" );
       });
  }

}
