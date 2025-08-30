package library;

public abstract class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public abstract String getRole();


    public void displayUserInfo() {
        System.out.println("library.User ID: " + id + ", Name: " + name + ", Role: " + getRole());
    }
}
