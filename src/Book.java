public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String bookName, String author, boolean isAvailable) {
        this.bookName = bookName;
        this.author = author;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
    public String getBookDetails() {
        return "Book Name: " + bookName + ", Author: " + author + ", Book ID: " + bookId+", Available: " + isAvailable;
    }
    public void markAvailable() {
        isAvailable = true;
    }
    public void unmarkAvailable() {
        isAvailable = false;
    }
}
