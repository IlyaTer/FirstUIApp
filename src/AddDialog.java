import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddDialog extends JDialog
{
  private JPanel dataPanel;
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
