package ui.menu.edit;

import ui.SwingFrame;
import ui.menu.edit.add.AddMenuItem;
import ui.menu.edit.remove.RemoveMenuItem;

import javax.swing.*;

public class EditMenu extends JMenu
{
  public EditMenu(SwingFrame swingFrame)
  {
    super("Edit");

    add(new AddMenuItem(swingFrame));
    add(new RemoveMenuItem(swingFrame));
  }

}
