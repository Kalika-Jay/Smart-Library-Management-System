
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "George Orwell", "1984",true);
        Book book2 = new Book(2, "Harper Lee", "To Kill a Mockingbird",true);

        System.out.println(book1.getBookDetails());
        book1.unmarkAvailable();
        System.out.println(book1.getBookDetails());

        Student student1 = new Student(101, "Alice");
        student1.displayUserInfo();
    }
}