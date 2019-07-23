package entities;

public class Book {
   // private int id;
    private String bookTitleName;
    private String bookAuthorName;
    private long bookIsbn;
    private int bookCount;
    private String isAcademic;
   ;
    

    public Book() {
    }

    public Book(String bookTitleName, String bookAuthorName, long bookIsbn, int bookCount, String isAcademic) {
        //this.id = id;
        this.bookTitleName = bookTitleName;
        this.bookAuthorName = bookAuthorName;
        this.bookIsbn = bookIsbn;
        this.bookCount = bookCount;
        this.isAcademic = isAcademic;

    }

    public String getBookTitleName() {
        return bookTitleName;
    }

    public void setBookTitleName(String bookTitleName) {
        this.bookTitleName = bookTitleName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public long getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(long bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public String getIsAcademic() {
        return isAcademic;
    }

    public void setIsAcademic(String isAcademic) {
        this.isAcademic = isAcademic;
    }

   /* public int getBookId() {
        return id;
    }

    public void setBookId(int id) {
        this.id = id;
    }*/

    @Override
    public String toString() {
        return "Book{" +

                " bookTitleName='" + bookTitleName + '\'' +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookCount=" + bookCount +
                ", isAcademic='" + isAcademic + '\'' +
                '}';
    }
}
