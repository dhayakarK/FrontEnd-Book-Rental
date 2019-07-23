package gui.swt;

import entities.Borrower2;
import entities.BorrowerService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

public class ReturnBook {
    public ReturnBook(final Display display) {
        //Display display=Display.getDefault();
        final Shell shell = new Shell(display);
        Label titlelabel = new Label(shell, SWT.NONE);
        shell.setText("Returning book to catalog");
        titlelabel.setText("Enter book title:");
        titlelabel.setBounds(30, 40, 200, 30);
        final Label idlabel=new Label(shell,SWT.NONE);
        idlabel.setText("Enter book_Isbn :");
        idlabel.setBounds(30,110,200,30);
        final Text titletext = new Text(shell, SWT.NONE);
        titletext.setFocus();
        titletext.setTextLimit(30);
        titletext.setBounds(30, 80, 200, 30);
        final Text idtext=new Text(shell,SWT.NONE);
        idtext.setBounds(30,150,200,30);
        idtext.setTextLimit(40);
        Label firstnamelabel=new Label(shell,SWT.NONE);
        /*firstnamelabel.setText("Enter firstname:");
        firstnamelabel.setBounds(30,200,200,30);
        final Text firstnametext=new Text(shell,SWT.NONE);
        firstnametext.setBounds(30,240,200,30);*/
        Button returnbtn = new Button(shell, SWT.NONE);
        returnbtn.setText("Return");
        returnbtn.setBounds(50, 290, 90, 30);
        Button closebtn = new Button(shell, SWT.NONE);
        closebtn.setText("close");
        closebtn.setBounds(150, 290, 90, 30);
        Button clearbtn = new Button(shell, SWT.NONE);
        clearbtn.setText("clear");
        clearbtn.setBounds(250, 290, 90, 30);
        titletext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow2 = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char ch = verifyEvent.text.charAt(i);
                        allow2 = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!allow2) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow2;
                }
            }
        });
        clearbtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                titletext.setText("");
                idtext.setText("");
            }
        });
        closebtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        returnbtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {

                if (titletext.getText()==""||idtext.getText()=="") {
                    MessageBox msgbox1 = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
                    msgbox1.setText("Input message warning");
                    msgbox1.setMessage("Please enter all the fields");
                    msgbox1.open();
                }
                BorrowerService borrowerService=new BorrowerService();
                String bookISBN=idtext.getText();
                long bookIsbnNumber=Long.parseLong(bookISBN);
                Borrower2 borrower2=new Borrower2(titletext.getText(),bookIsbnNumber);
                borrowerService.returnBook(borrower2);
                MessageBox messageBox=new MessageBox(shell,SWT.OK);
                messageBox.setMessage("Book Returned successfully ");
                messageBox.setText("book returned");
                messageBox.open();
                shell.open();
                /* else {
                    try {
                        String idnumber=idtext.getText();
                        int idumber1=Integer.parseInt(idnumber);
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
                        Statement statement = connection.createStatement();
                        String query = "update bookstore set total_count=total_count+1 where book_id=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1,idumber1);
                        //preparedStatement.setString(2, idtext.getText());
                        //preparedStatement.setString(3,firstnametext.getText());
                        preparedStatement.executeUpdate();
                        new View(display);
                         query="delete from borrower where book_id=?";
                       PreparedStatement preparedStatement2=connection.prepareStatement(query);
                       preparedStatement2.setInt(1,idumber1);
                       preparedStatement2.executeUpdate();
                       new BorrowerList(display);
                       // preparedStatement.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }*/
            }
        });
        shell.open();
    }
}
