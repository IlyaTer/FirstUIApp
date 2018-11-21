package ui.menu.about;

import ui.SwingFrame;
import ui.menu.about.items.InfoItem;

import javax.swing.*;

public class AboutMenu extends JMenu
{
  public AboutMenu(SwingFrame swingFrame)
  {
    super("About");

    add(new InfoItem(swingFrame));
  }

}
