package ui.menu;

import ui.SwingFrame;
import ui.menu.about.AboutMenu;
import ui.menu.edit.EditMenu;
import ui.menu.file.FileMenu;

import javax.swing.*;

public class GeneralMenu extends JMenuBar
{
  public GeneralMenu(SwingFrame swingFrame)
  {
    super();

    add(new FileMenu(swingFrame));
    add(new EditMenu(swingFrame));
    add(new AboutMenu(swingFrame));
  }

}
