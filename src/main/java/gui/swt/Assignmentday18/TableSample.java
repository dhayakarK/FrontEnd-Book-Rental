package swt.Assignmentday18;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

//import javax.naming.NamingEnumeration;

public class TableSample {
    public static void main(String[] args) {
        Display display=new Display();
        Shell shell=new Shell(display);
        shell.setSize(600,600);
        shell.setText("Checking deletion of a table");
        final Table table=new Table(shell, SWT.BORDER|SWT.MULTI);
        shell.setLayout(new FillLayout());
        TableColumn tableColumn=new TableColumn(table,SWT.NONE);
        tableColumn.setText("First count");
        tableColumn.setWidth(200);
        TableColumn tableColumn1=new TableColumn(table,SWT.NONE);
        tableColumn1.setText("Second count");
        tableColumn1.setWidth(200);
        for (int i=0;i<20;i++)

        {
            TableItem item=new TableItem(table,SWT.NONE);
            item.setText("Item"+i);
        }
        Menu menu=new Menu(shell,SWT.POP_UP);
        table.setMenu(menu);
        MenuItem menuItem=new MenuItem(menu,SWT.PUSH);
        menuItem.setText("Deletion Selection");
        menuItem.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                table.remove(table.getSelectionIndices());
            }
        });
        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
        display.dispose();
    }


}
