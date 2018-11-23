package ui.menu.edit;

import model.CarModel;
import ui.SwingFrame;
import ui.menu.edit.add.AddMenuItem;
import ui.menu.edit.remove.RemoveMenuItem;

import javax.swing.*;

public class EditMenu extends JMenu
{
  public EditMenu(SwingFrame swingFrame,CarModel carModel)
  {
    super("Edit");

    add(new AddMenuItem(swingFrame, carModel));
    add(new RemoveMenuItem(swingFrame, carModel));
  }

}
