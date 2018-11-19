import model.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SwingFrame extends JFrame
{
  private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  private JDialog infoDialog;
  private JDialog addDialog;
  private JTable table;
  private List<Car> carList;


  public SwingFrame()
  {

    setLocationByPlatform(true);

    //create menu
    JMenuBar menuBar = new JMenuBar();
    add(menuBar, BorderLayout.NORTH);
    JMenu fileMenu = new JMenu("File");
    menuBar.add(fileMenu);

    //create File menu
    JMenuItem exit = new JMenuItem("Exit");
    exit.addActionListener((e) ->
                           {
                             System.exit(0);
                           });
    fileMenu.add(exit);

    //create Edit menu
    JMenu edit = new JMenu("Edit");
    menuBar.add(edit);

    //add element
    JMenuItem addMenu = new JMenuItem("Add");
    addMenu.addActionListener((e)->
                          {
                            if(addDialog == null)
                            {
                              addDialog = new AddDialog(this);
                            }
                            addDialog.setVisible(true);
                          });
    edit.add(addMenu);

    //add About menu
    JMenu about = new JMenu("About");
    menuBar.add(about);

    JMenuItem infoAbout = new JMenuItem("Info");
    infoAbout.addActionListener((e)->
                                {
                                  if(infoDialog == null)
                                  {
                                    infoDialog = new InfoDialog(this);
                                  }
                                  infoDialog.setVisible(true);
                                });
    about.add(infoAbout);


    //add Table
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Mark");
    model.addColumn("Model");
    model.addColumn("Year");
    model.addColumn("Number");
    model.addColumn("Price");
    table = new JTable(model);

    //todo refactor code
    //insert data from file
    for(int i = 0; i < 10; i++)
    {
      Object[] data = new Object[5];
      int iter = 0;
      for(; iter < 5; iter++)
      {
        data[iter] = String.valueOf((int) (Math.random()*1000000));
      }//end for
      ((DefaultTableModel) table.getModel()).addRow(data);
    }//end for

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);
    pack();
  }//end constructor

  public JTable getTable()
  {
    return table;
  }

  public List<Car> getCarList()
  {
    return carList;
  }

}
