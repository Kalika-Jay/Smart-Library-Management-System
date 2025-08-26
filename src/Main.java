
public class Main {
    public static void main(String[] args) {
        Books book1 = new Books(1, "George Orwell", "1984",true);
        Books book2 = new Books(2, "Harper Lee", "To Kill a Mockingbird",true);

        System.out.println(book1.getBookDetails());
    }
}