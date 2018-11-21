package ui;

import model.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddDialog extends JDialog
{
  private JPanel dataPanel;
  private JDialog me = this;
  public AddDialog(JFrame parent)
  {
    super(parent, "Add", true);
    setLocationByPlatform(true);

    dataPanel = new JPanel();
    dataPanel.setLayout(new GridLayout(5,2));

    addLableAndField("Mark");
    addLableAndField("Model");
    addLableAndField("Year");
    addLableAndField("Number");
    addLableAndField("Price");


    add(dataPanel, BorderLayout.CENTER);


    JButton addButton = new JButton("Ok");
    addButton.addActionListener(e->
                                {
                                  DefaultTableModel tbModel =(DefaultTableModel)
                                          ((SwingFrame) parent).getTable().getModel();
                                  Object[] data = new Object[5];
                                  int iter = 0;
                                  for(Component component: dataPanel.getComponents())
                                  {
                                    if(component instanceof JTextField)
                                    {
                                      data[iter] = ((JTextField) component).getText();
                                      iter++;
                                    }
                                  }//end for
                                  //valid data
                                  if(!((String) data[0]).matches("[a-zA-Z]+"))
                                  {
                                    clearFields();
                                    JOptionPane.showMessageDialog(me, "Bad Mark!");
                                    return;
                                  }
                                  if(!((String) data[1]).matches("[a-zA-Z_0-9]+"))
                                  {
                                    clearFields();
                                    JOptionPane.showMessageDialog(me, "Bad Model!");
                                    return;
                                  }
                                  if(!((String) data[2]).matches("[0-9]+") ||
                                          Integer.parseInt(((String) data[2])) > 1910 ||
                                          Integer.parseInt(((String) data[2])) < 2019)
                                  {
                                    clearFields();
                                    JOptionPane.showMessageDialog(me, "Bad Year!");
                                    return;
                                  }
                                  if(!((String) data[3]).matches("[a-zA-Z_0-9]+"))
                                  {
                                    clearFields();
                                    JOptionPane.showMessageDialog(me, "Bad Number!");
                                    return;
                                  }
                                  if(!((String) data[4]).matches("[0-9]+"))
                                  {
                                    clearFields();
                                    JOptionPane.showMessageDialog(me, "Bad Price!");
                                    return;
                                  }

                                  ((SwingFrame) parent).getCarList().add(
                                          new Car(((String) data[0]),((String) data[1]),
                                                  Integer.parseInt((String) data[2]),
                                                  ((String) data[3]),
                                                  Double.parseDouble((String) data[4])));
                                  tbModel.addRow(data);

                                  clearFields();
                                  setVisible(false);
                                });

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(e ->
                                   {
                                     clearFields();
                                     setVisible(false);
                                   });

    JPanel butonPanel = new JPanel();
    butonPanel.add(addButton);
    butonPanel.add(cancelButton);
    add(butonPanel, BorderLayout.SOUTH);

    pack();
  }

  private void clearFields()
  {
    for(Component component: dataPanel.getComponents())
    {
      if(component instanceof JTextField)
      {
        ((JTextField) component).setText("");
      }
    }//end for
  }//end clearFields

  private void addLableAndField(String lable)
  {
    JLabel label = new JLabel(lable, SwingConstants.RIGHT);
    JTextField textField = new JTextField();
    dataPanel.add(label);
    dataPanel.add(textField);
  }

}
