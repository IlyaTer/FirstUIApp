package ui.menu.edit.remove;

import model.Car;
import ui.SwingFrame;

import javax.swing.*;
import java.awt.*;

public class RemoveDialog extends JDialog
{
  public RemoveDialog(SwingFrame swingFrame)
  {
    setLocationByPlatform(true);

    JPanel fieldPanel = new JPanel();
    fieldPanel.setLayout(new GridLayout(1,2));

    JLabel search = new JLabel("Remove by number ", SwingConstants.RIGHT);
    fieldPanel.add(search);

    JTextField textField = new JTextField();
    fieldPanel.add(textField);

    add(fieldPanel, BorderLayout.CENTER);

    JButton okButton = new JButton("Ok");
    okButton.addActionListener(e->
             {
               Car remCar = new Car("Car", "Car",
                                    2010,textField.getText(),
                                    1234567);
               if(!swingFrame.getCarList().contains(remCar))
               {
                 JOptionPane.showMessageDialog(this, "No such car!");
                 textField.setText("");
               }
               else
               {
                 int listIndex = swingFrame.getCarList().indexOf(remCar);
                 swingFrame.getCarList().remove(listIndex);
                 textField.setText("");
                 swingFrame.addCange();
                 setVisible(false);
               }
             });

    JButton cancel = new JButton("Cancel");
    cancel.addActionListener(e->
           {
             setVisible(false);
           });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(okButton);
    buttonPanel.add(cancel);

    add(buttonPanel, BorderLayout.SOUTH);

    pack();
  }

}
