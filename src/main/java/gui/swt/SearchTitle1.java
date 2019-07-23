package gui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

//import org.eclipse.swt.layout.RowLayout;

public class SearchTitle1 {

      SearchTitle1(final Display display) {
          // Display display= Display.getDefault();
          final Shell shell = new Shell(display);
          shell.setText("Search by book title");
          shell.setSize(500, 400);

          Label label = new Label(shell, SWT.NONE);
          label.setText("Enter book title:");
          label.setBounds(30, 40, 350, 30);


          final Text booktitletext = new Text(shell, SWT.NONE);
          booktitletext.setBounds(30, 70, 200, 30);
          booktitletext.setFocus();
          booktitletext.setTextLimit(30);

          Button searchbutton = new Button(shell, SWT.PUSH);
          searchbutton.setText("Search");
          searchbutton.setBounds(30, 200, 80, 30);

          Button closebutton = new Button(shell, SWT.NONE);
          closebutton.setText("close");
          closebutton.setBounds(230, 200, 80, 30);

          final Button clearbutton = new Button(shell, SWT.PUSH);
          clearbutton.setText("Clear");
          clearbutton.setBounds(140, 200, 80, 30);

         /* final Text booktitletext = new Text(shell, SWT.NONE);
          booktitletext.setBounds(30, 70, 200, 30);
          booktitletext.setFocus();
          booktitletext.setTextLimit(30);*/
         /* RowData rowData=new RowData();
          rowData.width=200;
          booktitletext.setLayoutData(rowData);*/
          /*booktitletext.setBounds(30,700,350,30);*/
          booktitletext.addVerifyListener(new VerifyListener() {
              @Override
              public void verifyText(VerifyEvent verifyEvent) {
                  if (verifyEvent.text.isEmpty()) {
                      verifyEvent.doit = true;
                  } else if (verifyEvent.keyCode == SWT.ARROW_LEFT | verifyEvent.keyCode == SWT.ARROW_RIGHT | verifyEvent.keyCode == SWT.ARROW_DOWN | verifyEvent.keyCode == SWT.ARROW_UP | verifyEvent.keyCode == SWT.BS | verifyEvent.keyCode == SWT.SPACE | verifyEvent.keyCode == SWT.CTRL | verifyEvent.keyCode == SWT.DEL | verifyEvent.keyCode == SWT.SHIFT | verifyEvent.keyCode == SWT.SPACE) {
                      verifyEvent.doit = true;
                  } else {
                      boolean allow = false;
                      for (int i = 0; i < verifyEvent.text.length(); i++) {
                          char ch = verifyEvent.text.charAt(i);
                          allow = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                          if (!allow) {
                              break;
                          }
                      }
                      verifyEvent.doit = allow;
                  }
              }
          });

          closebutton.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent selectionEvent) {
                  shell.close();
              }
          });
          clearbutton.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent selectionEvent) {
                  booktitletext.setText("");
                 // isbntext.setText("");
              }
          });
          searchbutton.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent selectionEvent) {
                  if (booktitletext.getText() == "" ) {
                      MessageBox warningbox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
                      warningbox.setText("warning");
                      warningbox.setMessage("Enter book ISBN number");
                      int code = warningbox.open();
                      switch (code) {
                          case SWT.OK:
                              break;
                          case SWT.ICON_WARNING:
                              break;
                      }
                  }

                      else {
                             new SearchTitle2(booktitletext.getText(),display);

                  }
              }

          });
          shell.open();

      }
}

