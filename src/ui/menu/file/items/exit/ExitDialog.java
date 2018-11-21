package ui.menu.file.items.exit;

import ui.SwingFrame;
import writer.WriterData;

import javax.swing.*;
import java.awt.*;

public class ExitDialog extends JDialog
{
  public ExitDialog(SwingFrame parent)
  {
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
                           WriterData.write(parent.getCarList().getCarList());
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
