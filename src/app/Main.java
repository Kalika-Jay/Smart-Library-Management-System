package app;

import database.Tables;
import database.db;
import library.Book;
import library.Librarian;
import library.Library;
import library.Student;

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
        Library library = new Library();
//        library.addBook(new Book(1, "1984", "George Orwell",true));
//        library.addBook(new Book(2, "Madolduwa", "Martin Wikramasinghe",true));
//        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee",true));
        library.getAllBooks();
        library.getAllUsers();
        library.getBooksByAuthor("GEORGE");
        library.getBooksByTitle("ANIMAL");
        library.getBooksById(3);

//        library.registerUser(new Student(1,"Kalika Jayasinghe Arachchi"));
//        library.registerUser(new Librarian(2,"Kamal Perera"));
    }
}