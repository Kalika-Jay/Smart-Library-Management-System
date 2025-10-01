package library;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private boolean isAvailable;
    private String description;

    public Book(String bookId,String bookName, String author, boolean isAvailable,String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.isAvailable = isAvailable;
        this.description = description;
    }
    public String getBookID() {
        return bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public String getDescription() {
        return description;
    }
    public String getBookDetails() {
        return "library.Book Name: " + bookName + ", Author: " + author + ", library.Book ID: " + bookId+", Available: " + isAvailable;
    }
    public void markAvailable() {
        isAvailable = true;
    }
    public void unmarkAvailable() {
        isAvailable = false;
    }
}
