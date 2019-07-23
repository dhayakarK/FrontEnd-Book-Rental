package gui.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

public class SearchName {

      public  SearchName(final Display display) {

        final Display d= display;
        final Shell shell = new Shell(d);
        shell.setSize(500,500);

        Label booklabel = new Label(shell, SWT.NONE);
        booklabel.setText("Enter book author name:");
        booklabel.setBounds(30,20,250,30);

        final Text booknametext = new Text(shell, SWT.NONE);
        booknametext.setFocus();
        booknametext.setBounds(30, 50, 200, 40);
        booknametext.setTextLimit(30);
        Button searchbutton = new Button(shell, SWT.NONE);
        searchbutton.setBounds(50, 230, 90, 30);
        searchbutton.setText("Search");

        Button clearbutton = new Button(shell, SWT.NONE);
        clearbutton.setText("clear");
        clearbutton.setBounds(150, 230, 80, 30);

        Button closebutton = new Button(shell, SWT.NONE);
        closebutton.setText("close");
        closebutton.setBounds(250, 230, 80, 30);


        booknametext.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT | verifyEvent.keyCode == SWT.ARROW_RIGHT | verifyEvent.keyCode == SWT.ARROW_DOWN | verifyEvent.keyCode == SWT.ARROW_UP | verifyEvent.keyCode == SWT.BS | verifyEvent.keyCode == SWT.SPACE | verifyEvent.keyCode == SWT.CTRL | verifyEvent.keyCode == SWT.DEL | verifyEvent.keyCode == SWT.SHIFT | verifyEvent.keyCode == SWT.SPACE) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow1 = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char ch = verifyEvent.text.charAt(i);
                        allow1 = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!allow1) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow1;
                }
            }
        });
        clearbutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                booknametext.setText("");

            }
        });
        closebutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        searchbutton.addSelectionListener(new SelectionAdapter() {
           /* String s2 = booknametext.getText();
            String s3=isbntext.getText();*/
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (booknametext.getText()== "") {
                    MessageBox msgbox=new MessageBox(shell,SWT.OK|SWT.ICON_WARNING);
                    msgbox.setText("input warning");
                    msgbox.setMessage("Please enter book name");
                    msgbox.open();
                }
                else {
                       new SearchName1(booknametext.getText(),display);

                }


            } });
        shell.open();

    }
}

