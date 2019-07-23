package gui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import swt.Assignmentday18.Delete3;

import java.sql.*;

public class Delete2 {

    public Delete2(final Display display)
    {
        Shell shell=new Shell(display);
        shell.setText("Borrower list Details");
        shell.setLayout(new FillLayout());
        final Table table=new Table(shell, SWT.BORDER);

        shell.setLayoutData(new GridLayout(1,true));
        shell.setText("All borrower details");
        TableColumn column=new TableColumn(table,SWT.LEFT);
        column.setText("book title name");
        column.setWidth(200);
        TableColumn column1=new TableColumn(table,SWT.LEFT);
        column1.setText("book author name");
        column1.setWidth(200);
        TableColumn column2=new TableColumn(table,SWT.LEFT);
        column2.setText("book isbn");
        column2.setWidth(200);
        TableColumn column3=new TableColumn(table,SWT.LEFT);
        column3.setText("total count");
        column3.setWidth(200);
        TableColumn column4=new TableColumn(table,SWT.LEFT);
        column4.setText("academic");
        column4.setWidth(200);
        table.setHeaderVisible(true);
        Menu menu=new Menu(shell,SWT.POP_UP);
        table.setMenu(menu);
        MenuItem menuItem=new MenuItem(menu,SWT.PUSH);
        menuItem.setText("Select item to delete");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
            String  query1 = "select *from bookstore";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            //query1 = "select *from bookstore";
            ResultSet resultSet = preparedStatement1.executeQuery(query1);
            while (resultSet.next())
            {
                TableItem tableItem=new TableItem(table,SWT.NONE);
                tableItem.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)});
            }
            menuItem.addListener(SWT.Selection, new Listener() {
                @Override
                public void handleEvent(Event event) {
                    int[] selectionIndices=table.getSelectionIndices();
                    TableItem item;
                    String isbnNumber = null;
                    for (int i=0;i<selectionIndices.length;i++) {
                        int selectionIndex = table.getSelectionIndex();
                        item = table.getItem(selectionIndex);
                        isbnNumber = item.getText(3);
                        table.remove(table.getSelectionIndices());
                        Long number = Long.parseLong(isbnNumber);
                        try {
                            String query1 = "delete from bookstore where book_isbn=?";
                            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                            preparedStatement1.setLong(1, number);
                            preparedStatement1.executeUpdate();
                            query1 = "select *from bookstore";
                            ResultSet resultSet1 = preparedStatement1.executeQuery(query1);
                            new Delete3(resultSet1, display);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       shell.open();
    }



}
