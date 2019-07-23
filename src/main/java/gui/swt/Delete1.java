package gui.swt;

import entities.BookService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

//import org.eclipse.swt.layout.GridLayout;

public class Delete1 {

    public Delete1(String bookname, final Display display) {


        final Shell shell = new Shell(display);
        final Table table = new Table(shell, SWT.BORDER | SWT.MULTI);

        shell.setLayout(new FillLayout());
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        TableColumn column1 = new TableColumn(table, SWT.NONE);
        column1.setText("book_Id ");
        column1.setWidth(200);
        TableColumn column2 = new TableColumn(table, SWT.NONE);
        column2.setText("book_title_name");
        column2.setWidth(200);
        TableColumn column3 = new TableColumn(table, SWT.NONE);
        column3.setText("book_author_name");
        column3.setWidth(200);
        TableColumn column4 = new TableColumn(table, SWT.NONE);
        column4.setText("book_isbn");
        column4.setWidth(200);
        TableColumn column5 = new TableColumn(table, SWT.NONE);
        column5.setText("total_count");
        column5.setWidth(200);
        TableColumn column6 = new TableColumn(table, SWT.NONE);
        column6.setText("academic");
        column6.setWidth(200);
        BookService bookService = new BookService();
        bookService.deleteBook(bookname);
        MessageBox msgbox=new MessageBox(shell,SWT.OK);
        msgbox.setMessage("Book deleted");
        msgbox.setText("BOOK DELETION");
        msgbox.open();

    /*    try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
            String query = "select *from bookstore where book_name=?";
             PreparedStatement preparedStatement ;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookname);
           final ResultSet resultSet=preparedStatement.executeQuery();
           if (resultSet.next())
           {
              do
               {
                   TableItem tableItem=new TableItem(table,SWT.NONE);
                   tableItem.setText(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
               } while (resultSet.next());
              Menu menu=new Menu(shell,SWT.POP_UP);
              table.setMenu(menu);
              MenuItem menuItem=new MenuItem(menu,SWT.PUSH);
              menuItem.setText("Select item to delete");
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

               shell.open();
           }
           else {
              new Delete2(display);
               shell.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

     //shell.open();

    }*/
    }
}
