package gui.swt;

import entities.BookService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class View {
    public View(Display display) {
        String s1, s2, s3, s4, s5;
        int arr, arr1;
        boolean b1;
        int count = 1;
        final Shell shell = new Shell(display);
       // shell.setText("All books details in catalog");
        Button closebutton = new Button(shell, SWT.NONE);
        closebutton.setText("Close");
        closebutton.setBounds(40, 600, 80, 30);
        shell.setLayoutData(new GridLayout(1, true));
        shell.setText("All Book details");
      // final Table table = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        final Table table=new Table(shell,SWT.BORDER);
        //table.setHeaderVisible(true);

        TableColumn column = new TableColumn(table, SWT.LEFT);
        column.setText("book_author_Name");
        column.setWidth(200);
        TableColumn column1 = new TableColumn(table, SWT.LEFT);
        column1.setText("book_title_name");
        column1.setWidth(200);
        TableColumn column2 = new TableColumn(table, SWT.LEFT);
        column2.setText("book_isbn");
        column2.setWidth(200);
        TableColumn column3 = new TableColumn(table, SWT.LEFT);
        column3.setText("book_count");
        column3.setWidth(200);
        TableColumn column4 = new TableColumn(table, SWT.LEFT);
        column4.setText("book_is_academic");
        column4.setWidth(200);
        table.setHeaderVisible(true);
        BookService bookService=new BookService();

      /*  List<Book> bookList=bookService.getAll();
        for (Book book:bookList) {

                TableItem tableItem=new TableItem(table,SWT.NONE);
                tableItem.setText(new String[]{String.valueOf(book.getBookIsbn()),book.getBookAuthorName(),book.getBookTitleName(), String.valueOf(book.getBookCount()),book.getIsAcademic()});
               // tableItem.setText(new String[]{book.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)});


        }*/
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookrental?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8","root","root");
            Statement statement=connection.createStatement();
            String query="Select  *from Java";
            ResultSet resultSet=statement.executeQuery(query);
            //TableItem item=new TableItem(table,SWT.NONE);

            while (resultSet.next())
            {
                TableItem tableItem=new TableItem(table,SWT.NONE);
                tableItem.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        closebutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
      shell.open();


        /*TableColumn column6=new TableColumn(table,SWT.LEFT);
        column6.setText("rent_noOf_days");
        column6.setWidth(200);
        TableColumn column5=new TableColumn(table,SWT.LEFT);
        column5.setText("book_author_name");
        column5.setWidth(200);*/
        /*String[] columns={"book_title_name","book_author_name","book_isbn","total_count","academic"};



        for (int loopindex=0;loopindex<columns.length;loopindex++)
        {
            TableColumn column=new TableColumn(table,SWT.NULL);
            column.setText(columns[loopindex]);
        }
        closebutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookrental?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8","root","root");
            Statement statement=connection.createStatement();
            String query="Select  *from Java";
            ResultSet resultSet=statement.executeQuery(query);

            while (resultSet.next())
            {
                //s1=resultSet.getString("book_id");
                s1=resultSet.getString("book_author_name");
                 s2=resultSet.getString("book_title_name");
                 s3=resultSet.getString("book_isbn");
                 s4=resultSet.getString("book_count");
                 s5=resultSet.getString("is_academic");
                 *//*arr=Integer.parseInt(s3);
                 arr1=Integer.parseInt(s4);
                 b1=Boolean.parseBoolean(s5);*//*
                for (int loopindex=0;loopindex<count;loopindex++)
                {
                    TableItem item=new TableItem(table,SWT.NONE);
                    //item.setText(0,s1);
                    item.setText(1,s1);
                    item.setText(2,s2);
                    item.setText(3,s3);
                    item.setText(4,s4);
                    item.setText(5,s5);
                }
               *//* for (int i=0;i<columns.length;i++)
                {
                    table.getColumn(i).pack();
                }
               table.setSize(table.computeSize(SWT.DEFAULT,500));*//*

            }
            for (int i=0;i<5;i++)
            {
                table.getColumn(i).pack();
            }
            table.setSize(table.computeSize(SWT.DEFAULT,500));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        shell.open();
    }*/
/*
}
    public static void main(String[] args) {
        new View();
    }*/
    }
}
