package library;

public class Student extends User{
    public Student(String fullName, String username, String password) {
        super(fullName, username, password);
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
