package ui;

import model.Car;
import reader.FileReader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SwingFrame extends JFrame
{
  private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  private JDialog infoDialog;
  private JDialog addDialog;
  private JDialog exitDialog;
  private JTable table;
  private List<Car> carList = new LinkedList<>();
  private int firstLength = 0;

//todo добавить сохранение при закрытии
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
                             if(exitDialog == null)
                             {
                               exitDialog = new ExitDialog(this);
                             }
                             exitDialog.setVisible(true);
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

    //insert data from file
    FileReader.readFromFile(carList,"Data/Cars");
    for(Car car:carList)
    {
      Object[] data = {car.getMark(), car.getModel(), car.getYearOfIssue(), car.getNumber(), car.getPrice()};
      ((DefaultTableModel) table.getModel()).addRow(data);
    }//end for

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);
    firstLength = carList.size();
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
