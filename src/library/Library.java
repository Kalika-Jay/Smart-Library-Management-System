package library;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import database.db;

public class Library {

    public void addBook(Book book) {
        String sql = "INSERT INTO books(id, title, author) VALUES(?, ?, ?)";

        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, book.getBookId());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getAuthor());
            pstmt.executeUpdate();
            System.out.println("Book added: " + book.getBookDetails());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllBooks() {
        List<String> books = new ArrayList<>();
        String query = "SELECT id, title, author FROM books";

        try (Connection conn =db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");

                books.add(id + ". " + title + " by " + author);
            }
            if (books.isEmpty()) {
                System.out.println("No books found in the library.");
            } else {
                System.out.println("Books in the library:");
                for (String book : books) {
                    System.out.println(book);
                }
            }

        } catch (Exception e) {
            System.out.println("Error retrieving books: " + e.getMessage());
        }
    }

    //users
    public void registerUser(User user){
        String sql = "INSERT INTO users(id,name,role) VALUES(?,?,?)";

        try(Connection connection = db.connect();
        PreparedStatement pstmnt = connection.prepareStatement(sql)){
            pstmnt.setInt(1,user.getId());
            pstmnt.setString(2,user.getName());
            pstmnt.setString(3,user.getRole());
            pstmnt.executeUpdate();
            System.out.println("User registered successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllUsers(){
        List<String> users = new ArrayList<>();
        String query = "SELECT id,name,role FROM users";
        try (Connection conn =db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");

                users.add(id + ". " + name + " is a " + role);
            }
            if (users.isEmpty()) {
                System.out.println("No books found in the library.");
            } else {
                System.out.println("Users of the library:");
                for (String user: users) {
                    System.out.println(user);
                }
            }

        } catch (Exception e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }

    }

//    public void showBooks(){
//        for (Book book : books) {
//            System.out.println(book.getBookDetails());
//        }
//    }
//
//    public void addUser(User user) {
//        users.add(user);
//    }
//    public void showUsers(){
//        for (User user : users) {
//            user.displayUserInfo();
//        }
//    }
//    public String getNameAndIdById(int userId) {
//        for (User user : users) {
//            if (user.getId() == userId) {
//                return "library.User ID: " + user.getId() + ", Name: " + user.getName();
//            }
//        }
//        return "library.User not found.";
//    }
//
//    public void searchBookByTitle(String keyword) {
//        List<Book> result = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getBookName().toLowerCase().contains(keyword.toLowerCase())) {
//                result.add(book);
//            }
//        }
//        for (Book book : result) {
//            System.out.println("Found: " + book.getBookDetails());
//        }
//        if (result.isEmpty()) {
//            System.out.println("No books found with the given title.");
//        }
//    }
//
//    public void searchBookByAuthor(String keyword) {
//        List<Book> result = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
//                result.add(book);
//            }
//        }
//        for (Book book : result) {
//            System.out.println("Found: " + book.getBookDetails());
//        }
//        if (result.isEmpty()) {
//            System.out.println("No books found with the given title.");
//        }
//    }
//
//    public void borrowBookByTitle(String keyword,int userId) {
//        for (Book book: books){
//            if(book.getBookName().toLowerCase().equals(keyword.toLowerCase())&& book.isAvailable()){
//                book.unmarkAvailable();
//                System.out.println(getNameAndIdById(userId) +" has borrowed: " + book.getBookDetails());
//                return;
//            }
//        }
//        System.out.println("No books found with the given title.");
//    }
//
//    public void borrowBookById(int id,int userId) {
//        for (Book book: books){
//            if(book.getBookId() == id && book.isAvailable()){
//                book.unmarkAvailable();
//                System.out.println(getNameAndIdById(userId) +" has borrowed: " + book.getBookDetails());
//                return;
//            }
//        }
//        System.out.println("No books found with the given ID.");
//    }
//
//    public void returnBook(){
//    }
}
