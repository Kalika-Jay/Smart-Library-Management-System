package library;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private boolean isAvailable;
    private String description;

    public Book(String bookName, String author, boolean isAvailable,String description) {
        this.bookName = bookName;
        this.author = author;
        this.isAvailable = isAvailable;
        this.description = description;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthor() {
        return author;
    }
    public int getBookId() {
        return bookId;
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
