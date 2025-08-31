package app;

import database.Tables;
import database.db;

public class Main {
    public static void main(String[] args) {
//        library.Library library = new library.Library();
//        library.addBook(new library.Book(1, "1984", "George Orwell", true));
//        library.addBook(new library.Book(2, "To Kill a Mockingbird", "Harper Lee", true));
//        library.addBook(new library.Book(3, "Kill the bear", "Harper Lee", true));
//        library.showBooks();
//
//        library.addUser(new library.Student(1, "Alice"));
//        library.addUser(new library.Librarian(2, "Bob"));
//        library.showUsers();
//
//        library.searchBookByTitle("kill");
//        library.borrowBookByTitle("1984",1);
//        library.borrowBookById(2,1);
        db.connect();
    }
}