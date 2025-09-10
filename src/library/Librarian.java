package library;

public class Librarian extends User{
    public Librarian(String username, String password, String role) {
        super(username, password, role);
    }

    @Override
    public String getRole() {
        return "Librarian";
    }
}
