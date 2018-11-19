import javax.swing.*;
import java.awt.*;

public class Main
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(()->
                           {
                             SwingFrame swingFrame = new SwingFrame();
                             swingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                             swingFrame.setVisible(true);
                           });
  }
}
