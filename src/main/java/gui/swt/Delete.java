package gui.swt;

//import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

public class Delete
{
    public Delete(final Display display) {
        //Display display=Display.getDefault();
        final Shell shell = new Shell(display);
        Label namelabel = new Label(shell, SWT.NONE);
        namelabel.setText("Enter book title name:");
        namelabel.setBounds(30, 40, 250, 30);
        final Text NAMETEXT = new Text(shell, SWT.NONE);
        NAMETEXT.setBounds(30, 70, 200, 30);
        NAMETEXT.setTextLimit(40);
        NAMETEXT.setFocus();
        Button deletebutton = new Button(shell, SWT.NONE);
        deletebutton.setBounds(50, 220, 90, 30);
        deletebutton.setText("Search");
        Button clearbtn = new Button(shell, SWT.NONE);
        clearbtn.setText("clear");
        clearbtn.setBounds(170, 220, 90, 30);
        Button closebtn = new Button(shell, SWT.NONE);
        closebtn.setText("close");
        closebtn.setBounds(280, 220, 90, 30);

        shell.open();
        NAMETEXT.addVerifyListener(new VerifyListener() {
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
                NAMETEXT.setText("");
            }
        });
        closebtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        deletebutton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                //MessageBox msgbox = new MessageBox(shell, SWT.OK);
              /* String bookname = NAMETEXT.getText();
                String isbnnumber = ISBNTEXT.getText();
               int isbnnumber1 = Integer.parseInt(isbnnumber);*/
                if (NAMETEXT.getText() == "") {
                    MessageBox msgbox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
                    msgbox.setText("Warning");
                    msgbox.setMessage("please enter bookname");
                    int response = msgbox.open();
                    switch (response) {
                        case SWT.OK:

                            break;
                        case SWT.ICON_WARNING:
                            break;
                    }
                } else {
                    new Delete1(NAMETEXT.getText(), display);
                }
            }
        });
    }
}
