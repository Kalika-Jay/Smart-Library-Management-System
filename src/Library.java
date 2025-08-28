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

}
