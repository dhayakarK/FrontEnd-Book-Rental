package gui.swt;

import entities.Book;
import entities.BookService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;
import java.util.Optional;

public class SearchName1 {
    SearchName1(String booknametext, Display display) {
        //display=Display.getDefault();
        Shell shell = new Shell(display);
        boolean flag=true;

        Table table = new Table(shell, SWT.BORDER);
        shell.setLayout(new GridLayout(1, true));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        //column5.setWidth(150);
        TableColumn column = new TableColumn(table, SWT.LEFT);
        column.setText("book_author_name");
        column.setWidth(150);
        TableColumn column1 = new TableColumn(table, SWT.LEFT);
        column1.setText("book_title_name");
        column1.setWidth(150);
        TableColumn column2 = new TableColumn(table, SWT.LEFT);
        column2.setText("book_count");
        column2.setWidth(150);
        TableColumn column3 = new TableColumn(table, SWT.LEFT);
        column3.setText("book_isbn");
        column3.setWidth(150);
        TableColumn column4 = new TableColumn(table, SWT.LEFT);
        column4.setText("is_academic");
        column4.setWidth(150);
           /* Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book",
                    "root", "root");
            String query = "select *from Java where book_author_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, booknametext);
            ResultSet resultSet = preparedStatement.executeQuery();
            //System.out.println(preparedStatement.toString());*/
        BookService bookService=new BookService();
           Optional<List<Book>> book1=bookService.searchByAuthorName(booknametext);
           List<Book> bookList=book1.get();
           if (bookList!=null) {
               for (Book book:bookList) {

                   TableItem tableItem=new TableItem(table,SWT.NONE);
                   tableItem.setText(new String[]{book.getBookTitleName(),book.getBookAuthorName(), String.valueOf(book.getBookCount()), String.valueOf(book.getBookIsbn()),book.getIsAcademic()});

               }


      /*     if (book1.isPresent())
           {
          *//* for (Optional<List<Book>> book:book1) {


               TableItem tableItem = new TableItem(table, SWT.NONE);
               tableItem.setText(1, book1.get().getBookAuthorName());
               tableItem.setText(2, book1.get().getBookTitleName());
               tableItem.setText(3, String.valueOf(book1.get().getBookCount()));
               tableItem.setText(4, String.valueOf(book1.get().getBookIsbn()));
               tableItem.setText(5, book1.get().getIsAcademic());

           }*//*
               for (:) {

           }*/

       }
       else
       {
           List<Book>bookList1 =bookService.getAll();
           for (Book book:bookList1) {
               TableItem tableItem=new TableItem(table,SWT.NONE);
               tableItem.setText(new String[]{book.getBookTitleName(),book.getBookAuthorName(), String.valueOf(book.getBookCount()), String.valueOf(book.getBookIsbn()),book.getIsAcademic()});
           }

       }
        //System.out.println();
           /* boolean flag1;
            if (resultSet.next()) {
                do {
                    TableItem tableItem = new TableItem(table, SWT.NONE);
                    tableItem.setText(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6)});
                    flag1=true;
                    shell.open();
                }while (resultSet.next());
            } else {
                new View(display);
                shell.close();

            }*/
               shell.open();


    }
}