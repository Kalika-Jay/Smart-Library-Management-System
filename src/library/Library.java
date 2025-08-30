package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks(){
        for (Book book : books) {
            System.out.println(book.getBookDetails());
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
    public void showUsers(){
        for (User user : users) {
            user.displayUserInfo();
        }
    }
    public String getNameAndIdById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return "library.User ID: " + user.getId() + ", Name: " + user.getName();
            }
        }
        return "library.User not found.";
    }

    public void searchBookByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        for (Book book : result) {
            System.out.println("Found: " + book.getBookDetails());
        }
        if (result.isEmpty()) {
            System.out.println("No books found with the given title.");
        }
    }

    public void searchBookByAuthor(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        for (Book book : result) {
            System.out.println("Found: " + book.getBookDetails());
        }
        if (result.isEmpty()) {
            System.out.println("No books found with the given title.");
        }
    }

    public void borrowBookByTitle(String keyword,int userId) {
        for (Book book: books){
            if(book.getBookName().toLowerCase().equals(keyword.toLowerCase())&& book.isAvailable()){
                book.unmarkAvailable();
                System.out.println(getNameAndIdById(userId) +" has borrowed: " + book.getBookDetails());
                return;
            }
        }
        System.out.println("No books found with the given title.");
    }

    public void borrowBookById(int id,int userId) {
        for (Book book: books){
            if(book.getBookId() == id && book.isAvailable()){
                book.unmarkAvailable();
                System.out.println(getNameAndIdById(userId) +" has borrowed: " + book.getBookDetails());
                return;
            }
        }
        System.out.println("No books found with the given ID.");
    }

    public void returnBook(){
    }
}
