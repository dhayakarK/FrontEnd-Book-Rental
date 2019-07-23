package entities;

public class Borrower2 {
     //private int id;
     private String firstName;
     private String lastName;
     private String email;
     private int noOfdays;
     private String bookAuthorName;
     private String bookTitleName;
     private long bookIsbn;

    public Borrower2() {
    }

    public Borrower2(String firstName, String lastName, String email, int noOfdays, String bookAuthorName, String bookTitleName, long bookIsbn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.noOfdays = noOfdays;
        this.bookAuthorName = bookAuthorName;
        this.bookTitleName = bookTitleName;
        this.bookIsbn = bookIsbn;
    }

    public Borrower2(String bookTitleName, long bookIsbn) {
        this.bookTitleName = bookTitleName;
        this.bookIsbn = bookIsbn;
    }

    public long getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(long bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoOfdays() {
        return noOfdays;
    }

    public void setNoOfdays(int noOfdays) {
        this.noOfdays = noOfdays;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public String getBookTitleName() {
        return bookTitleName;
    }

    public void setBookTitleName(String bookTitleName) {
        this.bookTitleName = bookTitleName;
    }


}
