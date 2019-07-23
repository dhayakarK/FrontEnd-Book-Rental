package gui.swt;

import entities.Book;
import entities.BookService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

public class Add {
    public Add(final Display display) {
        //Display display1=Display.getDefault();
        final Shell shell=new Shell(display);
        shell.setText("Add book to catalog homepage");
        Label[] labels=new Label[6];
        final Text[] texts=new Text[6];
        Button addbutton=new Button(shell,SWT.PUSH);
        addbutton.setText("Add");
        addbutton.setBounds(400,430,100,30);
        addbutton.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
        texts[0]=new Text(shell,SWT.NONE);
        texts[0].setBounds(200,40,130,30);
        texts[0].setFocus();
        texts[1]=new Text(shell,SWT.NONE);
        texts[1].setBounds(250,100,170,30);
        texts[1].setTextLimit(30);
        texts[2]=new Text(shell,SWT.NONE);
        texts[2].setBounds(200,160,130,30);
        texts[2].setTextLimit(30);
        texts[3]=new Text(shell,SWT.NONE);
        texts[3].setBounds(200,220,130,30);
        texts[3].setTextLimit(30);
       /* texts[4]=new Text(shell,SWT.NONE);
        texts[4].setBounds(200,360,160,30);
        texts[4].setTextLimit(30);*/
       /* texts[4]=new Text(shell,SWT.NONE);
        texts[4].setBounds(370,280,130,30);*/
        Button closebutton=new Button(shell,SWT.PUSH);
        closebutton.setText("Close");
        closebutton.setBounds(160,430,100,30);
        Button clearbutton=new Button(shell,SWT.PUSH);
        clearbutton.setText("Clear");
        clearbutton.setBounds(280,430,100,30);
       /* labels[5]=new Label(shell,SWT.NONE);
        labels[5].setText("Enter book id:");
        labels[5].setBounds(30,360,160,30);*/
        labels[0]=new Label(shell, SWT.NONE);
        labels[0].setText("Enter book Title * :");
        labels[0].setBounds(30,40,160,30);
        labels[1]=new Label(shell,SWT.NONE);
        labels[1].setText("Enter book author name * :");
        labels[1].setBounds(30,100,230,30);
        labels[2]=new Label(shell,SWT.NONE);
        labels[2].setText("Enter book ISBN * :");
        labels[2].setBounds(30,160,160,30);
        labels[3]=new Label(shell,SWT.NONE);
        labels[3].setText("Enter book count :");
        labels[3].setBounds(30,220,160,30);
        labels[4]=new Label(shell,SWT.NONE);
        labels[4].setText("Enter book is isAcademic(choose Yes) (or) NonAcademic(choose No):");
        labels[4].setBounds(30,280,720,30);
        final Combo academicCombo=new Combo(shell,SWT.READ_ONLY);
        academicCombo.setBounds(30,320,130,30);
        final String[] items={"Yes","No"};
        academicCombo.setItems(items);
        closebutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        clearbutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                texts[0].setText("");
                texts[1].setText("");
                texts[2].setText("");
                texts[3].setText("");
                academicCombo.deselectAll();
                //texts[4].setText("");
            }
        });
        shell.addListener(SWT.Close, new Listener() {
            @Override
            public void handleEvent(Event event) {
                shell.dispose();
            }
        });
        texts[0].addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
               if (verifyEvent.text.isEmpty())
               {
                   verifyEvent.doit=true;
               }
               else if (verifyEvent.keyCode==SWT.ARROW_LEFT||verifyEvent.keyCode==SWT.ARROW_RIGHT||verifyEvent.keyCode== SWT.ARROW_UP||verifyEvent.keyCode==SWT.ARROW_DOWN||verifyEvent.keyCode==SWT.DEL||verifyEvent.keyCode==SWT.CTRL||verifyEvent.keyCode==SWT.BS||verifyEvent.keyCode==SWT.SHIFT||verifyEvent.keyCode==SWT.SPACE)
               {
                   verifyEvent.doit=true;
               }
               else
               {
                   boolean search=false;
                   for (int i=0;i<verifyEvent.text.length();i++)
                   {
                      char ch=verifyEvent.text.charAt(i);
                      search=Character.isAlphabetic(ch)||Character.isWhitespace(ch);
                      if (!search)
                      {
                          break;
                      }
                   }
                   verifyEvent.doit=search;
               }
            }
        });
        texts[1].addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode==SWT.ARROW_LEFT||verifyEvent.keyCode==SWT.ARROW_RIGHT||verifyEvent.keyCode== SWT.ARROW_UP||verifyEvent.keyCode==SWT.ARROW_DOWN||verifyEvent.keyCode==SWT.DEL||verifyEvent.keyCode==SWT.CTRL||verifyEvent.keyCode==SWT.BS||verifyEvent.keyCode==SWT.SHIFT||verifyEvent.keyCode==SWT.SPACE)
                {
                    verifyEvent.doit=true;
                }
                else
                {
                    boolean search=false;
                    for (int i=0;i<verifyEvent.text.length();i++)
                    {
                        char ch=verifyEvent.text.charAt(i);
                        search=Character.isAlphabetic(ch)||Character.isWhitespace(ch);
                        if (!search)
                        {
                            break;
                        }
                    }
                    verifyEvent.doit=search;
                }

            }
        });
        texts[2].addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode==SWT.ARROW_LEFT||verifyEvent.keyCode==SWT.ARROW_RIGHT||verifyEvent.keyCode== SWT.ARROW_UP||verifyEvent.keyCode==SWT.ARROW_DOWN||verifyEvent.keyCode==SWT.DEL||verifyEvent.keyCode==SWT.CTRL||verifyEvent.keyCode==SWT.BS||verifyEvent.keyCode==SWT.SHIFT||verifyEvent.keyCode==SWT.SPACE)
                {
                    verifyEvent.doit=true;
                }
                else
                {
                    boolean search=false;
                    for (int i=0;i<verifyEvent.text.length();i++)
                    {
                        char ch=verifyEvent.text.charAt(i);
                        search=Character.isDigit(ch)||Character.isWhitespace(ch);
                        if (!search)
                        {
                            break;
                        }
                    }
                    verifyEvent.doit=search;
                }
            }
        });
        texts[3].addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode==SWT.ARROW_LEFT||verifyEvent.keyCode==SWT.ARROW_RIGHT||verifyEvent.keyCode== SWT.ARROW_UP||verifyEvent.keyCode==SWT.ARROW_DOWN||verifyEvent.keyCode==SWT.DEL||verifyEvent.keyCode==SWT.CTRL||verifyEvent.keyCode==SWT.BS||verifyEvent.keyCode==SWT.SHIFT||verifyEvent.keyCode==SWT.SPACE)
                {
                    verifyEvent.doit=true;
                }
                else
                {
                    boolean search=false;
                    for (int i=0;i<verifyEvent.text.length();i++)
                    {
                        char ch=verifyEvent.text.charAt(i);
                        search=Character.isDigit(ch)||Character.isWhitespace(ch);
                        if (!search)
                        {
                            break;
                        }
                    }
                    verifyEvent.doit=search;
                }
            }
        });
        addbutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {

                if (texts[0].getText()==""||texts[1].getText()==""||texts[2].getText()=="")
                {
                    MessageBox msgbox=new MessageBox(shell,SWT.YES|SWT.CANCEL|SWT.ICON_WARNING);
                    msgbox.setMessage("mandatory fields are required");
                    msgbox.setText("Warning");
                    int buttonId=msgbox.open();
                    switch (buttonId)
                    {
                        case SWT.OK:
                            break;
                        case SWT.CANCEL:
                            break;
                    }
                }
                else {
                    /* Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
                     //Statement statement = connection.createStatement();
                     String query = "insert into bookstore values(?,?,?,?,?,?)";
                     PreparedStatement preparedStatement = connection.prepareStatement(query);
                     preparedStatement.setInt(1,new Integer(texts[4].getText()));
                     preparedStatement.setString(2, texts[0].getText());
                     preparedStatement.setString(3, texts[1].getText());
                     preparedStatement.setLong(4, new Long(texts[2].getText()));
                     preparedStatement.setInt(5, new Integer(texts[3].getText()));
                     preparedStatement.setString(6,academicCombo.getText() );

                     preparedStatement.execute();*/
                    String number=texts[2].getText();
                    long number1=Long.parseLong(number);
                    String integerCount=texts[3].getText();
                    int number2=Integer.parseInt(integerCount);
                    Book book=new Book(texts[0].getText(),texts[1].getText(),number1,number2,academicCombo.getText());
                    BookService bookService=new BookService();
                    bookService.createBook(book);
                    MessageBox messageBox=new MessageBox(shell,SWT.OK);
                    messageBox.setMessage("book inserted");
                    messageBox.setText("OK");
                    messageBox.open();
                   // new View(display);
                    //connection.close();

                }
            }
        });
        shell.open();

    }

}
