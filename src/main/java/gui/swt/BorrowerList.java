package gui.swt;


import entities.Borrower2;
import entities.BorrowerService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;
import java.util.Optional;

public class BorrowerList {
    public BorrowerList(Display display)
    {
        //Display display=Display.getDefault();
        Shell shell=new Shell(display);
        //shell.setSize(800,800);
        shell.setText("Borrower list Details");
        shell.setLayout(new GridLayout(1,false));
        final Table table=new Table(shell,SWT.BORDER);

       // shell.setLayoutData(new GridLayout(1,true));
        shell.setText("All borrower details");
        TableColumn column=new TableColumn(table,SWT.LEFT);
        column.setText("book_isbn");
        column.setWidth(200);
        TableColumn column1=new TableColumn(table,SWT.LEFT);
        column1.setText("firstname");
        column1.setWidth(200);
        TableColumn column2=new TableColumn(table,SWT.LEFT);
        column2.setText("lastname");
        column2.setWidth(200);
        TableColumn column3=new TableColumn(table,SWT.LEFT);
        column3.setText("email");
        column3.setWidth(200);
        TableColumn column4=new TableColumn(table,SWT.LEFT);
        column4.setText("book_title_name");
        column4.setWidth(200);
        TableColumn column6=new TableColumn(table,SWT.LEFT);
        column6.setText("rent_noOf_days");
        column6.setWidth(200);
        TableColumn column5=new TableColumn(table,SWT.LEFT);
        column5.setText("book_author_name");
        column5.setWidth(200);

        table.setHeaderVisible(true);
        BorrowerService borrowerService=new BorrowerService();
        Optional<List<Borrower2>> optionalBorrower2s=borrowerService.allBorrowerDetails();
        List<Borrower2> borrower2List=optionalBorrower2s.get();
        if (borrower2List!=null)
        {
            for (Borrower2 borrower2:borrower2List) {
                TableItem tableItem=new TableItem(table,SWT.NONE);
                //tableItem.setText(new String[]{borrower2.getBookTitleName(),borrower2.getBookAuthorName(), String.valueOf(borrower2.getBookCount()), String.valueOf(borrower2.getBookIsbn()),borrower2.getIsAcademic()});
             tableItem.setText(new String[]{String.valueOf(borrower2.getBookIsbn()),borrower2.getFirstName(),borrower2.getLastName()
             ,borrower2.getEmail(),borrower2.getBookTitleName(), String.valueOf(borrower2.getNoOfdays()),borrower2.getBookAuthorName()});

            }
        }
        //borrowerService.returnBook();
            //int count=1;
       /* try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","root");
            Statement statement=connection.createStatement();
            String query="Select  *from borrower";
            ResultSet resultSet=statement.executeQuery(query);
            //TableItem item=new TableItem(table,SWT.NONE);

            while (resultSet.next())
            {
                TableItem tableItem=new TableItem(table,SWT.NONE);
                tableItem.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)});


            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        shell.open();
    }
}
