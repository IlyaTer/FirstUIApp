package ui.menu.edit.add;

import model.Car;
import model.CarModel;
import ui.SwingFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class AddDialog extends JDialog
{
  public AddDialog(SwingFrame swingFrame,CarModel carModel)
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
                                    JOptionPane.showMessageDialog(this,"Incorrect characters" +
                                            " in Mark!\n" +
                                            "In this field you can enter only: A to Z or a to z!");
                                    markField.setText("");
                                    return;
                                  }
                                  if(!modelField.getText().matches("[a-zA-Z_0-9]+"))
                                  {
                                    JOptionPane.showMessageDialog(this,"Incorrect characters" +
                                            " in Model!\n" +
                                            "In this field you can enter only: A to Z or a to z and 0-9!");
                                    modelField.setText("");
                                    return;
                                  }
                                  if(!yearField.getText().matches("[0-9]+") ||
                                          Integer.parseInt(yearField.getText()) < 1910 ||
                                          Integer.parseInt(yearField.getText()) > 2019)
                                  {
                                    JOptionPane.showMessageDialog(this,"Incorrect characters" +
                                            " in Year!\n" +
                                            "In this field you can enter only:"+"\n"+" 0-9 and value must be greater 1910 " +
                                            "and smaller 2019!");
                                    yearField.setText("");
                                    return;
                                  }
                                  if(!numberField.getText().matches("[a-zA-Z_0-9]+"))
                                  {
                                    JOptionPane.showMessageDialog(this,"Incorrect characters" +
                                            " in Number!\n" +
                                            "In this field you can enter only: A to Z or a to z and 0-9!");
                                    numberField.setText("");
                                    return;
                                  }
                                  if(!priceField.getText().matches("[0-9]+"))
                                  {
                                    JOptionPane.showMessageDialog(this,"Incorrect characters" +
                                            " in Price!\n" +
                                            "In this field you can enter only:0-9!");
                                    priceField.setText("");
                                    return;
                                  }

                                  carModel.add(new Car(markField.getText(),
                                                                      modelField.getText(),
                                                                      Integer.parseInt(yearField.getText()),
                                                                      numberField.getText(),
                                                                      Double.parseDouble(priceField.getText())
                                                                      ));

                                  clearFields(dataPanel);
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

    WindowListener listener = new ExitAdd(this);
    addWindowListener(listener);

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
