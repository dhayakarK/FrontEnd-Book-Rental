package swt.Assignmentday18;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete3 {
    public Delete3(ResultSet resultSet, Display display) throws SQLException {
        Shell shell=new Shell(display);
        Table table= new Table(shell, SWT.BORDER);
        shell.setLayout(new FillLayout());
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        TableColumn column1=new TableColumn(table,SWT.NONE);
        column1.setText("book_id");
        column1.setWidth(200);
        TableColumn column2=new TableColumn(table,SWT.NONE);
        column2.setText("book_title_name");
        column2.setWidth(200);
        TableColumn column3=new TableColumn(table,SWT.NONE);
        column3.setText("book_author_name");
        column3.setWidth(200);
        TableColumn column4=new TableColumn(table,SWT.NONE);
        column4.setText("book_isbn");
        column4.setWidth(200);
        TableColumn column5=new TableColumn(table,SWT.NONE);
        column5.setText("total_count");
        column5.setWidth(200);
        TableColumn column6=new TableColumn(table,SWT.NONE);
        column6.setText("academic");
        column6.setWidth(200);
        while (resultSet.next())
        {
            TableItem tableItem=new TableItem(table,SWT.NONE);
            tableItem.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
        }
        shell.open();
    }
}
