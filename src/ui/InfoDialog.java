package ui;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog
{
  public InfoDialog(JFrame parent)
  {//todo доработать
    super(parent, "Info", true);
    setLayout(new BorderLayout());
    setLocationByPlatform(true);

    JLabel label = new JLabel("Creator: Terekhof Ilya!");
    JPanel labelPanel = new JPanel();
    labelPanel.setLayout(new FlowLayout(10,10,10));
    labelPanel.add(label);
    add(labelPanel, BorderLayout.CENTER);

    JButton okButton = new JButton("Ok");
    okButton.addActionListener(e ->
                               {
                                 setVisible(false);
                               });
    JPanel panel = new JPanel();
    panel.add(okButton);
    add(panel, BorderLayout.SOUTH);

    pack();
  }

}
