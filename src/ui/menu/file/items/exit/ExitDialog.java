package ui.menu.file.items.exit;

import model.CarModel;
import ui.SwingFrame;
import writer.WriterData;

import javax.swing.*;
import java.awt.*;

public class ExitDialog extends JDialog
{
  public ExitDialog(SwingFrame parent,CarModel carModel)
  {
    super(parent);
    setLocationByPlatform(true);
    setLayout(new BorderLayout());

    JLabel saveLabel = new JLabel("Save before exit?");
    JPanel labelPanel = new JPanel();
    labelPanel.add(saveLabel);
    add(labelPanel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    JButton ok = new JButton("Yes");
    ok.addActionListener(e->
                         {
                           WriterData.write(carModel.getCarList());
                           System.exit(0);
                         });
    buttonPanel.add(ok);
    JButton no = new JButton("No");
    no.addActionListener(e->{System.exit(0);});
    buttonPanel.add(no);
    JButton cancel = new JButton("Cancel");
    cancel.addActionListener(e->
                             {
                               setVisible(false);
                             });
    buttonPanel.add(cancel);
    add(buttonPanel, BorderLayout.SOUTH);
    pack();
  }

}
