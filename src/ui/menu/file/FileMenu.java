package ui.menu.file;

import model.CarModel;
import ui.SwingFrame;
import ui.menu.file.items.exit.ExitItemMenu;

import javax.swing.*;

public class FileMenu extends JMenu
{
  public FileMenu(SwingFrame swingFrame,CarModel carModel)
  {
    super("File");

    add(new ExitItemMenu(swingFrame, carModel));
  }

}
