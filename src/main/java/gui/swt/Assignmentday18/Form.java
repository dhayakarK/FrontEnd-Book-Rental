package swt.Assignmentday18;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

import java.sql.*;

//import org.eclipse.swt.internal.win32.BUTTON_IMAGELIST;

public class Form {
    Display display=new Display();
    final  Shell shell=new Shell(display);
         Text Cardholdertxt;

         Text txtCreditDebit=new Text(shell,SWT.NONE);
        final Text securitycodetext=new Text(shell,SWT.NONE);
        final Text address1text=new Text(shell,SWT.NONE);
        final Text getAddress2text=new Text(shell,SWT.NONE);
        final Text zipcodetext=new Text(shell,SWT.NONE);
        final Text citytext=new Text(shell,SWT.NONE);
        final Text statustext=new Text(shell,SWT.NONE);
        final Combo combo=new Combo(shell,SWT.NONE);
    final Combo combo1=new Combo(shell,SWT.NONE);
        public  static void saveDetails(String Cardholdertxt,String txtCreditDebit,String Addresstext,String address2text,String citytext,String combo,String securitycodetext,String combo1,String zipcodetext,String statustext,Display display)
        {
            Shell shell=new Shell();
            String str1=Cardholdertxt;
            String str2=txtCreditDebit;
            String str3=Addresstext;
            String str4=address2text;
            String str5=citytext;
            String str6=combo;
            String str7=combo1;
            MessageBox msgbox1=new MessageBox(shell,SWT.OK|SWT.ICON_WARNING);
            // Display display1=Display.getDefault();
            Shell shell1=new Shell();
            Label label10=new Label(shell1,SWT.NONE);
            label10.setBounds(50,100,300,40);
            if (Cardholdertxt==""||txtCreditDebit==""||Addresstext==""||address2text==""||citytext==""||combo==""||combo1=="")
            {
                MessageBox msgbox=new MessageBox(shell1,SWT.OK|SWT.ICON_WARNING);
                msgbox.setText("Mandatory details required");
                msgbox.setMessage("Please enter the required details");
                msgbox.open();

            }
            else
            {
                String first=Cardholdertxt;
                String second=txtCreditDebit;
                // int a=Integer.parseInt(second);
                String third=securitycodetext;
                int b=Integer.parseInt(third);
                String fourth=combo;
                String fifth=combo1;
                int c= Integer.parseInt(fifth);
                String sixt=Addresstext;
                String seventh=address2text;
                String eigth=zipcodetext;
                int d=Integer.parseInt(eigth);
                String ningth=citytext;
                String tenth=statustext;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","root");
                    Statement statement=connection.createStatement();
                    String query="insert into user_details values(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStatement=connection.prepareStatement(query);
                    preparedStatement.setString(1,first);
                    preparedStatement.setString(2,second);
                    preparedStatement.setString(3,fourth);
                    preparedStatement.setInt(4,c);
                    preparedStatement.setInt(5,b);
                    preparedStatement.setString(6,sixt);
                    preparedStatement.setString(7,seventh);
                    preparedStatement.setInt(8,d);
                    preparedStatement.setString(9,ningth);
                    preparedStatement.setString(10,tenth);
                    preparedStatement.execute();
                    preparedStatement.close();
                    /*MessageBox msgbox1=new MessageBox(shell,SWT.OK);*/
                    msgbox1.setText("Card Details saved successfully");
                    msgbox1.setMessage("Your card details saved successfully");
                    msgbox1.open();
                    /*int response=msgbox1.open();
                    switch (response)
                    {
                        case SWT.OK:
                            Cardholdertxt.setText("");
                            txtCreditDebit.setText("");
                            securitycodetext.setText("");
                            combo.setText("");
                            combo1.setText("");
                            Addresstext.setText("");
                            address2text.setText("");
                            citytext.setText("");
                            statustext.setText("");
                            zipcodetext.setText("");
                            break;
                    }*/

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }

    public static void main(String[] args) {
        final Display display=new Display();
        final Shell shell=new Shell(display);
        shell.setText("Credit card");
        Button showallcreditcardsbutton=new Button(shell,SWT.PUSH);
        showallcreditcardsbutton.setText("Show all credit Cards(F11)");
        showallcreditcardsbutton.setBounds(30,20,250,40);
        Label label=new Label(shell, SWT.NONE);
        label.setText("Card Holder *");
        label.setBounds(35,100,150,30);
        final Text Cardholdertxt=new Text(shell,SWT.NONE);
        Cardholdertxt.setBounds(35,140,500,40);

        Cardholdertxt.setFocus();
        Label label1=new Label(shell,SWT.NONE);// label lblCreditCardOrDebitCard, txt, btn
        label1.setText("Credit card or Debit Card *");
        label1.setBounds(35,200,230,40);
        final Text txtCreditDebit=new Text(shell,SWT.NONE);
        txtCreditDebit.setBounds(35,240,230,40);
        txtCreditDebit.setTextLimit(16);

        Label label2=new Label(shell,SWT.NONE);
        label2.setText("Expiration Date *");
        label2.setBounds(35,300,250,40);
        final Combo combo=new Combo(shell,SWT.READ_ONLY);
        combo.setBounds(35,340,75,40);
         String[] items={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        combo.setItems(items);
         final Combo combo1=new Combo(shell,SWT.READ_ONLY);
        combo1.setBounds(120,340,75,40);
         String[] items1={"1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
        combo1.setItems(items1);
        Label label3=new Label(shell,SWT.NONE);
        label3.setText("Security Code *");
        label3.setBounds(300,300,200,40);
        final Text securitycodetext=new Text(shell,SWT.NONE);
        securitycodetext.setBounds(300,340,130,38);
        Label label4=new Label(shell,SWT.NONE);
        label4.setBounds(35,400,140,38);
        label4.setText("Address * :");
        final Text Addresstext=new Text(shell,SWT.NONE);
        Addresstext.setBounds(35,440,250,38);
        //Addresstext.setFocus();
        Label label5=new Label(shell,SWT.NONE);
        label5.setBounds(35,480,250,38);
        label5.setText("Address 2 :");
        final Text address2text=new Text(shell,SWT.NONE);
        address2text.setBounds(35,520,250,40);
        Label label6=new Label(shell,SWT.NONE);
        label6.setText("Zip Code* :");
        label6.setBounds(35,560,200,30);
        final Text zipcodetext=new Text(shell,SWT.NONE);
        zipcodetext.setBounds(35,600,250,38);
        Label label7=new Label(shell,SWT.NONE);
        label7.setText("City :");
        label7.setBounds(35,640,100,30);
        final Text citytext=new Text(shell,SWT.NONE);
        citytext.setBounds(35,680,200,38);
        citytext.setTextLimit(30);
        Label label8=new Label(shell,SWT.NONE);
        label8.setBounds(35,720,200,38);
        label8.setText("Status :");
        final Text statustext=new Text(shell,SWT.NONE);
        statustext.setBounds(35,760,200,38);
        Button showallcreditcardsbutton1=new Button(shell,SWT.CHECK);
        showallcreditcardsbutton1.setBounds(35,795,20,38);
        Label label9=new Label(shell,SWT.NONE);
        label9.setText("Set as default");
        label9.setBounds(58,800,200,38);
        Button savshowallcreditcardsbutton=new Button(shell,SWT.NONE);
       savshowallcreditcardsbutton.setText("Save F10");
       savshowallcreditcardsbutton.setBounds(35,840,150,38);
        Button cancelshowallcreditcardsbutton=new Button(shell,SWT.ICON_WARNING|SWT.NONE);
        cancelshowallcreditcardsbutton.setText("Cancel F9");
        cancelshowallcreditcardsbutton.setBounds(200,840,150,38);
        final Label label10=new Label(shell,SWT.NONE);
        label10.setBounds(35,260,100,20);

       /* cancelshowallcreditcardsbutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });*/
       Cardholdertxt.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent keyEvent) {
               if (keyEvent.keyCode==SWT.CR)
               {
                   txtCreditDebit.setFocus();
               }
               else if (keyEvent.keyCode==SWT.ESC)
               {

               }
           }
       });
       txtCreditDebit.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent keyEvent) {
               if (keyEvent.keyCode==SWT.CR)
               {
                   combo.setFocus();
               }
               else if (keyEvent.keyCode==SWT.ESC)
               {
                   Cardholdertxt.setFocus();
               }
           }
       });
      combo.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent keyEvent) {
              if (keyEvent.keyCode==SWT.CR)
              {
                  combo1.setFocus();
              }
              else if (keyEvent.keyCode==SWT.ESC)
              {
                  txtCreditDebit.setFocus();
              }
          }
      });
       combo1.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent keyEvent) {
               if (keyEvent.keyCode==SWT.CR)
               {
                   securitycodetext.setFocus();
               }
               else if (keyEvent.keyCode==SWT.ESC)
               {
                   combo.setFocus();
               }
           }
       });
     securitycodetext.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent keyEvent) {
             if (keyEvent.keyCode==SWT.CR)
             {
                 Addresstext.setFocus();
             }
             else if (keyEvent.keyCode==SWT.ESC)
             {
                 combo1.setFocus();
             }
         }
     });
      Addresstext.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent keyEvent) {
              if (keyEvent.keyCode==SWT.CR)
              {
                  address2text.setFocus();
              }
              else if (keyEvent.keyCode==SWT.ESC)
              {
                  securitycodetext.setFocus();
              }
          }
      });
      address2text.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent keyEvent) {
              if (keyEvent.keyCode==SWT.CR)
              {
                  zipcodetext.setFocus();
              }
              else if (keyEvent.keyCode==SWT.ESC)
              {
                  Addresstext.setFocus();
              }
          }
      });
      zipcodetext.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent keyEvent) {
              if (keyEvent.keyCode==SWT.CR)
              {
                  citytext.setFocus();
              }
              else if (keyEvent.keyCode==SWT.ESC)
              {
                  address2text.setFocus();
              }
          }
      });
     citytext.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent keyEvent) {
             if (keyEvent.keyCode==SWT.CR)
             {
                 statustext.setFocus();
             }
             else if (keyEvent.keyCode==SWT.ESC)
             {
                 zipcodetext.setFocus();
             }
         }
     });


      statustext.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent keyEvent) {
              if (keyEvent.keyCode==SWT.CR)
              {
                  Cardholdertxt.setFocus();
              }
              else if (keyEvent.keyCode==SWT.ESC)
              {
                  citytext.setFocus();
              }
          }
      });

        Cardholdertxt.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode==SWT.ARROW_LEFT||verifyEvent.keyCode==SWT.ARROW_RIGHT||verifyEvent.keyCode==SWT.ARROW_DOWN||verifyEvent.keyCode==SWT.SPACE||verifyEvent.keyCode==SWT.SHIFT||verifyEvent.keyCode==SWT.DEL||verifyEvent.keyCode==SWT.CTRL)
                {
                    verifyEvent.doit=true;
                }
                else
                {
                    boolean allow=false;
                    for (int i=0;i<verifyEvent.text.length();i++)
                    {
                        char ch=verifyEvent.text.charAt(i);
                        allow=Character.isAlphabetic(ch)||Character.isWhitespace(ch);
                        if (!allow)
                        {
                            break;
                        }
                    }
                    verifyEvent.doit=allow;
                }
            }
        });
        shell.open();
        txtCreditDebit.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.SHIFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);
                        if (!allow) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }
                if (!txtCreditDebit.getText().isEmpty()) {
                    if (txtCreditDebit.getText().startsWith("5")) {
                        securitycodetext.setTextLimit(3);
                    } else {
                        securitycodetext.setTextLimit(4);
                    }
                }

            }

        });
        securitycodetext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.SHIFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);
                        if (!allow) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }

            }

        });
        zipcodetext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode == SWT.ARROW_LEFT || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.SHIFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);
                        if (!allow) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }
            }
        });
        citytext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode == SWT.ARROW_LEFT || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.SHIFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isAlphabetic(c) || Character.isWhitespace(c);
                        if (!allow) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }
            }
        });
        statustext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty())
                {
                    verifyEvent.doit=true;
                }
                else if (verifyEvent.keyCode == SWT.ARROW_LEFT || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.SHIFT) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isAlphabetic(c) || Character.isWhitespace(c);
                        if (!allow) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }
            }
        });
        cancelshowallcreditcardsbutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
               Cardholdertxt.setText("");
               txtCreditDebit.setText("");
               securitycodetext.setText("");
               Addresstext.setText("");
               address2text.setText("");
               zipcodetext.setText("");
               citytext.setText("");
               statustext.setText("");
               combo.deselectAll();
               combo1.deselectAll();
            }
        });
        savshowallcreditcardsbutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {


                saveDetails(Cardholdertxt.getText(), Addresstext.getText(), address2text.getText(), citytext.getText(), combo.getText(), securitycodetext.getText(), combo1.getText(), zipcodetext.getText(), statustext.getText(), statustext.getText(),display);
            }
        });


       /* savshowallcreditcardsbutton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {

                    saveDetails(Cardholdertxt.getText(), Addresstext.getText(), address2text.getText(), citytext.getText(), combo.getText(), securitycodetext.getText(), combo1.getText(), zipcodetext.getText(), statustext.getText(), statustext.getText(),display);

            }
        });*/

                /*String str1=Cardholdertxt.getText();
                String str2=txtCreditDebit.getText();
                String str3=Addresstext.getText();
                String str4=address2text.getText();
                String str5=citytext.getText();
                String str6=combo.getText();
                String str7=combo1.getText();
               // Display display1=Display.getDefault();
                Shell shell1=new Shell();
                Label label10=new Label(shell1,SWT.NONE);
                label10.setBounds(50,100,300,40);
                if (str1==""||str2==""||str3==""||str4==""||str4==""||str5==""||str6==""||str6==""||str7=="")
                {
                        MessageBox msgbox=new MessageBox(shell,SWT.OK|SWT.ICON_WARNING);
                        msgbox.setText("Mandatory details required");
                        msgbox.setMessage("Please enter the required details");
                        msgbox.open();

                }
                else
                {
                    String first=Cardholdertxt.getText();
                    String second=txtCreditDebit.getText();
                   // int a=Integer.parseInt(second);
                    String third=securitycodetext.getText();
                    int b=Integer.parseInt(third);
                    String fourth=combo.getText();
                    String fifth=combo1.getText();
                    int c= Integer.parseInt(fifth);
                    String sixt=Addresstext.getText();
                    String seventh=address2text.getText();
                    String eigth=zipcodetext.getText();
                    int d=Integer.parseInt(eigth);
                    String ningth=citytext.getText();
                    String tenth=statustext.getText();
                     try {
                         Class.forName("com.mysql.cj.jdbc.Driver");
                         Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","root");
                         Statement statement=connection.createStatement();
                         String query="insert into user_details values(?,?,?,?,?,?,?,?,?,?)";
                         PreparedStatement preparedStatement=connection.prepareStatement(query);
                         preparedStatement.setString(1,first);
                         preparedStatement.setString(2,second);
                         preparedStatement.setString(3,fourth);
                         preparedStatement.setInt(4,c);
                         preparedStatement.setInt(5,b);
                         preparedStatement.setString(6,sixt);
                         preparedStatement.setString(7,seventh);
                         preparedStatement.setInt(8,d);
                         preparedStatement.setString(9,ningth);
                         preparedStatement.setString(10,tenth);
                         preparedStatement.execute();
                         preparedStatement.close();
                         MessageBox msgbox1=new MessageBox(shell,SWT.OK);
                         msgbox1.setText("Card Details saved successfully");
                         msgbox1.setMessage("Your card details saved successfully");
                         int response=msgbox1.open();
                         switch (response)
                         {
                             case SWT.OK:
                                 Cardholdertxt.setText("");
                                 txtCreditDebit.setText("");
                                 securitycodetext.setText("");
                                 combo.setText("");
                                 combo1.setText("");
                                 Addresstext.setText("");
                                 address2text.setText("");
                                 citytext.setText("");
                                 statustext.setText("");
                                 zipcodetext.setText("");
                                 break;
                         }

                     } catch (ClassNotFoundException e) {
                         e.printStackTrace();
                     } catch (SQLException e) {
                         e.printStackTrace();
                     }


                }*/



        while (!shell.isDisposed())
        {
            if(!display.readAndDispatch())
            {
                display.sleep();
            }

        }
        display.dispose();

    }
}
