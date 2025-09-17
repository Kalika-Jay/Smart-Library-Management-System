package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.db;

public class Library {

    private void space(){
        System.out.println("--------------------------------------------------");
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books(id, title, author,description) VALUES(?, ?, ?,?)";

        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, book.getBookId());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4,book.getDescription());
            pstmt.executeUpdate();
            System.out.println("Book added: " + book.getBookDetails());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBooks() {
        List<String> books = new ArrayList<>();
        String query = "SELECT id, title, author,is_available,borrowed_by FROM books";

        try (Connection conn =db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                boolean available = rs.getBoolean("is_available");
                String  borrowedBy = rs.getString("borrowed_by");

                books.add("📖 " + title + " (ID: " + id + ")\n" +
                        "   ✍ Author: " + author + "\n" +
                        "   📌 Status: " + (available ? "Available ✅" : "Borrowed ❌ by "+borrowedBy));
            }
            if (books.isEmpty()) {
                space();
                System.out.println("No books found in the library.");
                space();
            } else {
                space();
                System.out.println("Books in the library:");
                for (String book : books) {
                    System.out.println(book);
                }
                space();
            }

        } catch (Exception e) {
            System.out.println("Error retrieving books: " + e.getMessage());
        }
        return  books;
    }

    public List<String> getBooksByAuthor(String authorName) {
        List<String> books = new ArrayList<>();
        String query = "SELECT id,title,author,is_available FROM books WHERE author ILIKE ?";

        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1,  "%" + authorName + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                int id = rs.getInt("id");
                String author = rs.getString("author");
                boolean available = rs.getBoolean("is_available");
                books.add( "📖 " + title + " (ID: " + id + ")\n" +
                        "   ✍ Author: " + author + "\n" +
                        "   📌 Status: " + (available ? "Available ✅" : "Borrowed ❌"));
            }

            if (books.isEmpty()) {
                space();
                System.out.println("No books found by author: " + authorName);
                books.add("No books found by author: " + authorName);
                space();
            }else{
                space();
                System.out.println("Books by " + authorName + ":");
                for (String book : books) {
                    System.out.println(book);
                }
                space();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }

    public List<String> getBooksByTitle(String titleName) {
        List<String> books = new ArrayList<>();
        String query = "SELECT id,title,author,is_available FROM books WHERE title ILIKE ?";

        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1,  "%" + titleName + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                int id = rs.getInt("id");
                String author = rs.getString("author");
                boolean available = rs.getBoolean("is_available");
                books.add("📖 " + title + " (ID: " + id + ")\n" +
                        "   ✍ Author: " + author + "\n" +
                        "   📌 Status: " + (available ? "Available ✅" : "Borrowed ❌"));
            }

            if (books.isEmpty()) {
                space();
                System.out.println("No books found for the tittle keyword: " + titleName);
                space();
            }else{
                space();
                System.out.println("Books go with keyword " + titleName + ":");
                for (String book : books) {
                    System.out.println(book);
                }
                space();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }

    public List<String> getBooksById(int Id) {
        List<String> books = new ArrayList<>();
        String query = "SELECT id,title,author,is_available FROM books WHERE id = ?";

        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, Id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                int id = rs.getInt("id");
                String author = rs.getString("author");
                boolean available = rs.getBoolean("is_available");
                books.add("📖 " + title + " (ID: " + id + ")\n" +
                        "   ✍ Author: " + author + "\n" +
                        "   📌 Status: " + (available ? "Available ✅" : "Borrowed ❌"));
            }

            if (books.isEmpty()) {
                space();
                System.out.println("No books found with the id: " + Id);
                space();
            }else{
                space();
                System.out.println("Book for id " + Id + ":");
                for (String book : books) {
                    System.out.println(book);
                }
                space();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }


    //users
    public boolean registerUser(User user){
        String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
        String insertSql = "INSERT INTO users(fullname,username,role,password) VALUES(?,?,?,?)";

        try(Connection connection = db.connect()) {

            // Check if username exists
            try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                checkStmt.setString(1, user.getUserName());
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("Error: Username '" + user.getUserName() + "' already exists.");
                    return false;
                }
            }

            // Insert new user if username doesn't exist
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                insertStmt.setString(1, user.getName());
                insertStmt.setString(2, user.getUserName());
                insertStmt.setString(3, user.getRole());
                insertStmt.setString(4, user.getPassword());
                insertStmt.executeUpdate();
                System.out.println("User registered successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<String> getAllUsers(){
        List<String> users = new ArrayList<>();
        String query = "SELECT id,fullname,username,role FROM users";
        try (Connection conn =db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("fullname");
                String username = rs.getString("username");
                String role = rs.getString("role");

                users.add("👤 " + name + " [@" + username + "]\n" +
                        "   🔑 ID: " + id + " | 🎭 Role: " + role);
            }
            if (users.isEmpty()) {
                space();
                System.out.println("No books found in the library.");
                space();
            } else {
                space();
                System.out.println("Users of the library:");
                for (String user: users) {
                    System.out.println(user);
                }
                space();
            }

        } catch (Exception e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
        return users;
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
public String borrowBookById(int id,String username) throws SQLException {
    String searchQuery = "SELECT is_available FROM books WHERE id = ?";
    String updateQuery = "UPDATE books SET is_available = ? , borrowed_by= ? WHERE id = ?";

    try (Connection conn = db.connect();
         PreparedStatement searchStmt = conn.prepareStatement(searchQuery);
         PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

        // Search for the book
        searchStmt.setInt(1, id);
        ResultSet rs1 = searchStmt.executeQuery();

        if (rs1.next()) {
            boolean isAvailable = rs1.getBoolean("is_available");

            if (!isAvailable) {
                return "Error: Book with id " + id + " is not available.";
            }

            // Update availability
            updateStmt.setBoolean(1, false);
            updateStmt.setString (2, username);
            updateStmt.setInt(3, id);
            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                return "Book with id " + id + " has been borrowed successfully.";
            } else {
                return "Error: Could not borrow book with id " + id;
            }
        } else {
            return "Error: Book with id " + id + " not found.";
        }
    }
}

    public String returnBookById(int id, String username) throws SQLException {
        String searchQuery = "SELECT is_available, borrowed_by FROM books WHERE id = ?";
        String updateQuery = "UPDATE books SET is_available = ?, borrowed_by = NULL WHERE id = ?";

        try (Connection conn = db.connect();
             PreparedStatement searchStmt = conn.prepareStatement(searchQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            // Search for the book
            searchStmt.setInt(1, id);
            ResultSet rs1 = searchStmt.executeQuery();

            if (rs1.next()) {
                boolean isAvailable = rs1.getBoolean("is_available");
                String borrowedBy = rs1.getString("borrowed_by");

                if (isAvailable) {
                    return "Error: Book with id " + id + " is already available and cannot be returned.";
                }

                if (borrowedBy == null || !borrowedBy.equals(username)) {
                    return "Error: Book with id " + id + " was not borrowed by " + username + ".";
                }

                // Update availability
                updateStmt.setBoolean(1, true);
                updateStmt.setInt(2, id);
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    return "Book with id " + id + " has been returned successfully.";
                } else {
                    return "Error: Could not return book with id " + id;
                }
            } else {
                return "Error: Book with id " + id + " not found.";
            }
        }
    }

    public List<String> displayBookDescription(int id){
        List<String> books = new ArrayList<>();
        String query = "SELECT title,author,description FROM books WHERE id = ?";
        try {
            Connection conn = db.connect();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                books.add(
                        id + ". " +
                                "📖 Title: " + rs.getString("title") + "\n" +
                                "✍️ Author: " + rs.getString("author") + "\n" +
                                "📝 Description: " + rs.getString("description")
                );
                return books;
            }
            if (books.isEmpty()) {
                books.add("Error: No books found under the id " + id);
                return books;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }


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
