
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "1984", "George Orwell", true));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", true));
        library.addBook(new Book(3, "Kill the bear", "Harper Lee", true));
        library.showBooks();

        library.addUser(new Student(1, "Alice"));
        library.addUser(new Librarian(2, "Bob"));
        library.showUsers();

        library.searchBookByTitle("kill");
        library.borrowBookByTitle("1984");
        library.borrowBookById(2);
    }
}