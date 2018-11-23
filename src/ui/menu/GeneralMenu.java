package ui.menu;

import model.CarModel;
import ui.SwingFrame;
import ui.menu.about.AboutMenu;
import ui.menu.edit.EditMenu;
import ui.menu.file.FileMenu;

import javax.swing.*;

public class GeneralMenu extends JMenuBar
{
  public GeneralMenu(SwingFrame swingFrame,CarModel carModel)
  {
    super();

    add(new FileMenu(swingFrame, carModel));
    add(new EditMenu(swingFrame, carModel));
    add(new AboutMenu(swingFrame));
  }

}
