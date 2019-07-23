package gui.swt;

import entities.Borrower2;
import entities.BorrowerService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;
//import entities.Borrower;
public class Borrower {
    public Borrower(final Display display) {
        //Display display=Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setText("Rent a book to catalog");
        //Label[] labels = new Label[5];
        final Button rentbtn = new Button(shell, SWT.PUSH);
        rentbtn.setText("Rent");
        rentbtn.setBounds(400, 450, 100, 30);
        rentbtn.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
       Label firstnamelabel = new Label(shell, SWT.NONE);
        firstnamelabel.setText("Enter Firstname:");
        firstnamelabel.setBounds(30, 40, 160, 30);
        Label lastnamelabel = new Label(shell, SWT.NONE);
        lastnamelabel.setText("Enter LastName:");
        lastnamelabel.setBounds(30, 100, 160, 30);
      Label  emaillabel = new Label(shell, SWT.NONE);
        emaillabel.setText("Enter Email:");
        emaillabel.setBounds(30, 160, 160, 30);

        Label booktitlelabel = new Label(shell, SWT.NONE);
        booktitlelabel.setText("Enter book Title:");
        booktitlelabel.setBounds(30, 220, 190, 30);
        Label noOfdayslabel = new Label(shell, SWT.NONE);
        noOfdayslabel.setText("Enter noOfDays:");
        noOfdayslabel.setBounds(30, 280, 160, 30);
        Label authornamelabel=new Label(shell,SWT.NONE);
        authornamelabel.setText("Enter book author name:");
        authornamelabel.setBounds(30,340,200,30);
        Label idlabel=new Label(shell,SWT.NONE);
        idlabel.setText("Enter book ISBN :");
        idlabel.setBounds(30,400,200,30);
        final Text firstnametext = new Text(shell, SWT.NONE);
        firstnametext.setBounds(200, 40, 130, 30);
        firstnametext.setTextLimit(20);
        firstnametext.setFocus();
       final Text lastnametext = new Text(shell, SWT.NONE);
        lastnametext.setBounds(200, 100, 130, 30);
        lastnametext.setTextLimit(30);
       final Text  emailtext = new Text(shell, SWT.NONE);
        emailtext.setBounds(200, 160, 200, 30);
        emailtext.setTextLimit(40);
        final Text booktitletext = new Text(shell, SWT.NONE);
        booktitletext.setBounds(240, 230, 150, 30);
        booktitletext.setTextLimit(20);
        final Text noOfdaystext = new Text(shell, SWT.NONE);
        noOfdaystext.setBounds(190, 280, 130, 30);
        noOfdaystext.setTextLimit(20);
        final  Text authornametext=new Text(shell,SWT.NONE);
        authornametext.setBounds(240,340,130,30);
        authornametext.setTextLimit(30);
        final Text idtext=new Text(shell,SWT.NONE);
        idtext.setBounds(240,400,200,30);
        idtext.setTextLimit(30);
        Button clearbtn = new Button(shell, SWT.NONE);
        clearbtn.setText("clear");
        clearbtn.setBounds(530, 450, 100, 30);
        Button closebtn = new Button(shell, SWT.NONE);
        closebtn.setText("close");
        closebtn.setBounds(650, 450, 100, 30);
        firstnametext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean value = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char ch = verifyEvent.text.charAt(i);
                        value = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!value) {
                            break;
                        }
                    }
                    verifyEvent.doit = value;
                }


            }
        });
        lastnametext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean value1 = false;
                    for (int j = 0; j < verifyEvent.text.length(); j++) {
                        char ch = verifyEvent.text.charAt(j);
                        value1 = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!value1) {
                            break;
                        }
                    }
                    verifyEvent.doit = value1;
                }
            }
        });

        booktitletext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean value3 = false;
                    for (int j = 0; j < verifyEvent.text.length(); j++) {
                        char ch = verifyEvent.text.charAt(j);
                        value3 = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!value3) {
                            break;
                        }
                    }
                    verifyEvent.doit = value3;
                }
            }
        });
        noOfdaystext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean value4 = false;
                    for (int j = 0; j < verifyEvent.text.length(); j++) {
                        char ch = verifyEvent.text.charAt(j);
                        value4 = Character.isDigit(ch) || Character.isWhitespace(ch);
                        if (!value4) {
                            break;
                        }
                    }
                    verifyEvent.doit = value4;
                }
            }
        });
        idtext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean value4 = false;
                    for (int j = 0; j < verifyEvent.text.length(); j++) {
                        char ch = verifyEvent.text.charAt(j);
                        value4 = Character.isDigit(ch) || Character.isWhitespace(ch);
                        if (!value4) {
                            break;
                        }
                    }
                    verifyEvent.doit = value4;
                }
            }
        });
        authornametext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean value3 = false;
                    for (int j = 0; j < verifyEvent.text.length(); j++) {
                        char ch = verifyEvent.text.charAt(j);
                        value3 = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!value3) {
                            break;
                        }
                    }
                    verifyEvent.doit = value3;
                }
            }
        });


        rentbtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                MessageBox msgbox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
                try {

                    if (firstnametext.getText()== "" || lastnametext.getText()==""||emailtext.getText()== ""||booktitletext.getText()=="" ||noOfdaystext.getText()== ""||authornametext.getText()==""||idtext.getText()=="") {
                        msgbox.setText("Input Warning");
                        msgbox.setMessage("Please enter all the fields");
                        msgbox.open();
                       // BorrowerService borrowerService=new BorrowerService();

                    }
                    String noOfdays=noOfdaystext.getText();
                    int noOfdays1=Integer.parseInt(noOfdays);
                    String idtext1=idtext.getText();
                    long id=Long.parseLong(idtext1);
                    BorrowerService borrowerService=new BorrowerService();
                    Borrower2 borrower2=new Borrower2(firstnametext.getText(),lastnametext.getText(),emailtext.getText(),noOfdays1,authornametext.getText(),booktitletext.getText(),id);
                    borrowerService.rentBook(borrower2);
                    MessageBox messageBox=new MessageBox(shell,SWT.OK);
                    messageBox.setMessage("Book rented");
                    messageBox.setText("rent successful");
                    messageBox.open();
                    shell.open();
                    /* else {
                        String noOfday=idtext.getText();
                        int number=Integer.parseInt(noOfday);
                        String str=noOfdaystext.getText();
                        int a = Integer.parseInt(str);
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
                        Statement statement = connection.createStatement();
                        String query = "insert into borrower values(?,?,?,?,?,?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, idtext.getText());
                        preparedStatement.setString(2, firstnametext.getText());
                        preparedStatement.setString(3, lastnametext.getText());
                        preparedStatement.setString(4, emailtext.getText());
                        preparedStatement.setString(5, booktitletext.getText());
                        preparedStatement.setInt(6, a);
                        preparedStatement.setString(7,authornametext.getText());
                        firstnametext.setText("");
                        lastnametext.setText("");
                        emailtext.setText("");
                        booktitletext.setText("");
                        noOfdaystext.setText("");
                        authornametext.setText("");
                        idtext.setText("");
                        preparedStatement.execute();
                       String query1="update  bookstore set  total_count=total_count-1 where  book_id=?";
                       PreparedStatement preparedStatement1=connection.prepareStatement(query1);
                       //preparedStatement1.setString(1,authornametext.getText());
                       preparedStatement1.setInt(1,number);

                       preparedStatement1.executeUpdate();
                       query1="select *from bookstore";
                       connection.prepareStatement(query1);
                       ResultSet resultSet=preparedStatement1.executeQuery(query1);

                       new Borrower1(resultSet,display);
                      *//* query1="delete from bookstore where book_id=?";
                       PreparedStatement preparedStatement2=connection.prepareStatement(query1);
                       preparedStatement2.setInt(1,number);
                       preparedStatement2.executeUpdate();
                       new BorrowerList(display);*//*
                    }*/
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        closebtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        clearbtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                firstnametext.setText("");
                lastnametext.setText("");
                emailtext.setText("");
                booktitletext.setText("");
                noOfdaystext.setText("");
                authornametext.setText("");
                idtext.setText("");
            }
        });
        shell.open();
    }

}
