import model.CarModel;
import ui.SwingFrame;

import javax.swing.*;
import java.awt.*;

public class Main
{
  public static void main(String[] args)
  {
    CarModel carModel = new CarModel();
    EventQueue.invokeLater(()->
                           {
                             SwingFrame swingFrame = new SwingFrame(carModel);
                             swingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                             swingFrame.setVisible(true);
                           });
  }
}
