package gui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SearchBook {
    public SearchBook(final Display display) {
        final Shell shell = new Shell(display);
        shell.setSize(500, 500);
        shell.setText("Search Book ");
         Button closebtn=new Button(shell,SWT.NONE);
         closebtn.setText("close");
         closebtn.setBounds(50,110,90,30);
        Button btnSearchByName = new Button(shell, SWT.TOGGLE);
        btnSearchByName.setText("Search By book Author name");
        btnSearchByName.setBounds(20, 20, 350, 30);

        Button btnSearchByTitle = new Button(shell, SWT.TOGGLE);
        btnSearchByTitle.setText("Search By book Title name");
        btnSearchByTitle.setBounds(20, 70, 350, 30);
        closebtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });

        btnSearchByName.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                new SearchName(display);
            }
        });

        btnSearchByTitle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                 new SearchTitle1(display);
            }
        });

        shell.open();

    }
}

