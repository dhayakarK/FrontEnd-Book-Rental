package gui.swt.Assignmentday18;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Borrower1 {
    public Borrower1(ResultSet resultSet, Display display) throws SQLException {
        Shell shell=new Shell(display);
       Table table=new Table(shell, SWT.NONE);
       shell.setLayout(new FillLayout());
       table.setHeaderVisible(true);
       table.setLinesVisible(true);
        TableColumn column6=new TableColumn(table,SWT.NONE);
        column6.setText("Book id");
        column6.setWidth(200);
        TableColumn column1=new TableColumn(table,SWT.NONE);
        column1.setText("Book title name");
        column1.setWidth(200);
        TableColumn column2=new TableColumn(table,SWT.NONE);
        column2.setText("Book author name");
        column2.setWidth(200);
        TableColumn column3=new TableColumn(table,SWT.NONE);
        column3.setText("Book isbn");
        column3.setWidth(200);
        TableColumn column4=new TableColumn(table,SWT.NONE);
        column4.setText("totalcount");
        column4.setWidth(200);
        TableColumn column5=new TableColumn(table,SWT.NONE);
        column5.setText("academic");
        column5.setWidth(200);
        while (resultSet.next())
        {
            TableItem item=new TableItem(table,SWT.NONE);
            item.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
        }

       shell.open();


    }
}
