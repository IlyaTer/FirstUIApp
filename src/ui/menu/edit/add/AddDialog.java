package ui.menu.edit.add;

import model.Car;
import ui.SwingFrame;

import javax.swing.*;
import java.awt.*;

public class AddDialog extends JDialog
{
  public AddDialog(SwingFrame swingFrame)
  {
    super(swingFrame,"Add ",true);
    setLocationByPlatform(true);

    JPanel dataPanel = new JPanel();
    dataPanel.setLayout(new GridLayout(5,2));

    JLabel mark = new JLabel("Mark ",SwingConstants.RIGHT);
    JTextField markField = new JTextField();
    dataPanel.add(mark);
    dataPanel.add(markField);

    JLabel model = new JLabel("Model ",SwingConstants.RIGHT);
    JTextField modelField = new JTextField();
    dataPanel.add(model);
    dataPanel.add(modelField);

    JLabel year = new JLabel("Year ",SwingConstants.RIGHT);
    JTextField yearField = new JTextField();
    dataPanel.add(year);
    dataPanel.add(yearField);

    JLabel number = new JLabel("Number ",SwingConstants.RIGHT);
    JTextField numberField = new JTextField();
    dataPanel.add(number);
    dataPanel.add(numberField);

    JLabel price = new JLabel("Price ",SwingConstants.RIGHT);
    JTextField priceField = new JTextField();
    dataPanel.add(price);
    dataPanel.add(priceField);

    add(dataPanel,BorderLayout.CENTER);


    JButton addButton = new JButton("Ok");
    addButton.addActionListener(e ->
                                {
                                  //valid data
                                  if(!markField.getText().matches("[a-zA-Z]+"))
                                  {
                                    clearFields(dataPanel);
                                    JOptionPane.showMessageDialog(this,"Bad Mark!");
                                    return;
                                  }
                                  if(!modelField.getText().matches("[a-zA-Z_0-9]+"))
                                  {
                                    clearFields(dataPanel);
                                    JOptionPane.showMessageDialog(this,"Bad Model!");
                                    return;
                                  }
                                  if(!yearField.getText().matches("[0-9]+") ||
                                          Integer.parseInt(yearField.getText()) < 1910 ||
                                          Integer.parseInt(yearField.getText()) > 2019)
                                  {
                                    clearFields(dataPanel);
                                    JOptionPane.showMessageDialog(this,"Bad Year!");
                                    return;
                                  }
                                  if(!numberField.getText().matches("[a-zA-Z_0-9]+"))
                                  {
                                    clearFields(dataPanel);
                                    JOptionPane.showMessageDialog(this,"Bad Number!");
                                    return;
                                  }
                                  if(!priceField.getText().matches("[0-9]+"))
                                  {
                                    clearFields(dataPanel);
                                    JOptionPane.showMessageDialog(this,"Bad Price!");
                                    return;
                                  }

                                  swingFrame.getCarList().add(new Car(markField.getText(),
                                                                      modelField.getText(),
                                                                      Integer.parseInt(yearField.getText()),
                                                                      numberField.getText(),
                                                                      Double.parseDouble(priceField.getText())
                                                                      ));

                                  clearFields(dataPanel);
                                  swingFrame.addCange();
                                  setVisible(false);
                                });

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(e ->
                                   {
                                     clearFields(dataPanel);
                                     setVisible(false);
                                   });

    JPanel butonPanel = new JPanel();
    butonPanel.add(addButton);
    butonPanel.add(cancelButton);
    add(butonPanel,BorderLayout.SOUTH);

    pack();
  }

  private void clearFields(JPanel dataPanel)
  {
    for(Component component : dataPanel.getComponents())
    {
      if(component instanceof JTextField)
      {
        ((JTextField) component).setText("");
      }
    }//end for
  }//end clearFields

}
