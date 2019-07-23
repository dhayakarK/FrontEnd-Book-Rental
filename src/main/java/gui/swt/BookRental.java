package gui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

//import org.eclipse.swt.graphics.Image;
//import org.eclipse.swt.graphics.Rectangle;

//import static java.awt.Toolkit.ToolkitEventMulticaster.add;

public class BookRental {
    public static void main(String[] args)
    {
        //creating display to  hold all GUI components
        final Display display=new Display();
        final Shell shell=new Shell(display,SWT.CLOSE);
        /*Image bg_Image = new Image(display, "C:\\Users\\Admin\\Downloads\\Books.jpg");
        shell.setBackgroundImage(bg_Image);
        shell.setBackgroundMode(SWT.INHERIT_FORCE);*/
        shell.setMaximized(true);
        //shell.setBackground(display.getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT));
        // Setting Title of Shell
        shell.setText("Book Rental Store Home Page");
       /* //placing a background image for shell
        Image bg_img=new Image(display,"Books.jpg");
        shell.setBackgroundImage(bg_img);*/
        //creating a label to place the text
        Label label=new Label(shell, SWT.NONE);
        label.setText("Welcome To Book Rental Store");
        label.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
        label.setSize(500,50);
        label.setBounds(100,30,350,30);
        Label label1=new Label(shell,SWT.NONE);
        label1.setText("Select any one of the options below");
        label1.setBounds(40,70,300,30);
        label1.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
        //Creating an array of Radio Buttons
        Button[] button=new Button[8];

        //styling first button
        button[0]=new Button(shell,SWT.NONE);
        button[0].setSelection(true);
        button[0].setText("Add book to catalog");
        button[0].setBounds(50,130,250,30);
        button[0].setBackground(display.getSystemColor(SWT.COLOR_DARK_MAGENTA));
        // styling second button
       button[1]=new Button(shell,SWT.NONE);
        button[1].setText("Search book in catalog");
        button[1].setBounds(50,200,250,30);
        button[1].setBackground(display.getSystemColor(SWT.COLOR_DARK_GREEN));
        //styling second button
        /*button[2]=new Button(shell,SWT.NONE|SWT.CHECK);
        button[2].setText("View books in catalog");
        button[2].setBounds(50,300,250,30);
        button[2].setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));*/
        //styling third button
        button[3]=new Button(shell,SWT.NONE);
        button[3].setText("Delete book from catalog");
        button[3].setBounds(50,300,250,30);
        button[3].setBackground(display.getSystemColor(SWT.COLOR_BLUE));
        //styling fourth button
        button[4]=new Button(shell,SWT.NONE);
        button[4].setText("Rent book from catalog");
        button[4].setBounds(50,400,250,30);
        button[4].setBackground(display.getSystemColor(SWT.COLOR_CYAN));
        //styling fifth button
        button[5]=new Button(shell,SWT.NONE);
        button[5].setText("Return book to catalog");
        button[5].setBounds(50,500,250,30);
        button[5].setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
        //Styling sixth button
        button[6]=new Button(shell,SWT.NONE);
        button[6].setText("Print borrower list");
        button[6].setBounds(50,600,250,30);
        button[6].setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
        //styling seventh button
        button[7]=new Button(shell,SWT.NONE);
        button[7].setText("Cancel");
        button[7].setBounds(50,700,250,30);
        button[7].setBackground(display.getSystemColor(SWT.COLOR_DARK_RED));
        shell.addListener(SWT.CLOSE, new Listener() {
            @Override
            public void handleEvent(Event event) {
                shell.dispose();
            }
        });
       button[0].addSelectionListener(new SelectionAdapter() {
           @Override
           public void widgetSelected(SelectionEvent selectionEvent) {
               new Add(display);
           }

           @Override
           public void widgetDefaultSelected(SelectionEvent selectionEvent) {
               widgetSelected(selectionEvent);
           }
       });
       button[1].addSelectionListener(new SelectionAdapter() {
           @Override
           public void widgetSelected(SelectionEvent selectionEvent) {
               new SearchBook(display);
           }


          /* public void widgetDefaultSelected(SelectionEvent selectionEvent) {
               widgetSelected(selectionEvent);
           }*/
       });
       /* button[2].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                new View(display);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                super.widgetDefaultSelected(selectionEvent);
            }
        });*/


        button[3].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                new Delete(display);
            }
        });
        button[4].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                new Borrower(display);
            }
        });
        button[5].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
               new ReturnBook(display);
            }
        });
        button[6].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                new BorrowerList(display);

            }
        });
        button[7].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
