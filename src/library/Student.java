package library;

public class Student extends User{
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
