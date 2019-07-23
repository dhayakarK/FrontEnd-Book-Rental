package gui.swt;

import entities.Book;
import entities.BookService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;
import java.util.Optional;

public class SearchTitle2 {
    SearchTitle2(String booktitletext, Display display) {
         {
            Shell shell = new Shell();
            Table table = new Table(shell, SWT.BORDER);
            shell.setLayout(new FormLayout());
            table.setHeaderVisible(true);
            // table.setLinesVisible(true);
            TableColumn column = new TableColumn(table, SWT.LEFT);
            column.setText("book_title_name");
            column.setWidth(150);
            TableColumn column1 = new TableColumn(table, SWT.LEFT);
            column1.setText("book_author_name");
            column1.setWidth(150);
            TableColumn column2 = new TableColumn(table, SWT.LEFT);
            column2.setText("book_isbn");
            column2.setWidth(150);
            TableColumn column3 = new TableColumn(table, SWT.LEFT);
            column3.setText("book_totalcount");
            column3.setWidth(150);
            TableColumn column4 = new TableColumn(table, SWT.LEFT);
            column4.setText("is_academic");
            column4.setWidth(150);
            /*TableColumn column5 = new TableColumn(table, SWT.LEFT);
            column5.setText("");
            column5.setWidth(150);*/
            BookService bookservice=new BookService();
           Optional<List<Book>> optionalBook =bookservice.searchByBookName(booktitletext);
           List<Book> bookList=optionalBook.get();
           if (bookList!=null)
           {
               for (Book book:bookList) {

                   TableItem tableItem=new TableItem(table,SWT.NONE);
                   tableItem.setText(new String[]{book.getBookTitleName(),book.getBookAuthorName(), String.valueOf(book.getBookCount()), String.valueOf(book.getBookIsbn()),book.getIsAcademic()});

               }
           }
          else
           {
              List<Book> bookList1=bookservice.getAll();
              for (Book book:bookList1) {
                 TableItem tableItem=new TableItem(table,SWT.NONE);
                 tableItem.setText(new String[]{book.getBookTitleName(),book.getBookAuthorName(), String.valueOf(book.getBookIsbn()), String.valueOf(book.getBookCount()),book.getIsAcademic()});
              }
           }
          shell.open();


         /*   Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book",
                    "root", "root");
            String query="select *from bookstore where book_name=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);

            preparedStatement.setString(1,booktitletext);

            ResultSet resultSet=preparedStatement.executeQuery();
            boolean flag1=false;
            if (resultSet.next())
            {
                do {
                    TableItem tableItem=new TableItem(table,SWT.NONE);
                    tableItem.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
                    shell.open();
                    flag1=true;
                }while (resultSet.next());
                //shell.open();
            }
            else
            {
                new View(display);
                shell.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
         }   
    }
}