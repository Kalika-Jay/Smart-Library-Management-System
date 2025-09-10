package library;

public abstract class User {
    private String fullName;
    private String userName;
    private String password;

    public User(String fullName,String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }
    public String getName() {
        return fullName;
    }
    public String getUserName() {return userName;}
    public String getPassword() {return password;}
    public abstract String getRole();

}
