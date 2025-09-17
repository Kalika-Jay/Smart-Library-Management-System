package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import library.Book;
import library.Librarian;
import library.Library;

import java.sql.*;

import database.db;

import java.io.IOException;
import java.util.List;

import library.Student;

public class UIController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeLabel;

    private String loggedInUsername;

    public void setWelcomeMessage(String username) {
        this.loggedInUsername = username;
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    @FXML
    public void switchToUi(ActionEvent event,String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
        Parent root = loader.load();
        UIController controller = loader.getController();
        controller.setWelcomeMessage(username);
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void switchToAdminUi(ActionEvent event,String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminUi.fxml"));
        Parent root = loader.load();
        UIController controller = loader.getController();
        controller.setWelcomeMessage(username);
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void switchTologin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void switchTosignup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void switchToAdminLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private TextField authorField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField idField;
    @FXML
    private TextField authorField2;

    @FXML
    private ListView<String> resultsList;
    @FXML
    private AnchorPane hiddenArea1;
    @FXML
    private AnchorPane hiddenArea2;
    @FXML
    private AnchorPane hiddenArea3;
    @FXML
    private AnchorPane hiddenArea4;
    @FXML
    private AnchorPane hiddenArea5;
    @FXML
    private AnchorPane hiddenArea6;
    @FXML
    private AnchorPane hiddenArea7;
    @FXML
    private Button toggleButton1;
    @FXML
    private Button toggleButton2;
    @FXML
    private Button toggleButton3;
    @FXML
    private Button toggleButton4;
    @FXML
    private Button toggleButton5;
    @FXML
    private Button toggleButton6;
    @FXML
    private Button toggleButton7;
    @FXML
    private TextField nameFieldS;
    @FXML
    private TextField roleField;
    @FXML
    private TextField uidFieldS;
    @FXML
    private TextField uidFieldL;
    @FXML
    private TextField nameFieldL;
    @FXML
    private Label name;

    private final Library library = new Library();

    // Helper method to hide all areas and reset button text
    private void hideAllAreas() {
        if (hiddenArea1 != null) {
            hiddenArea1.setVisible(false);
            hiddenArea1.setManaged(false);
        }
        if (hiddenArea2 != null) {
            hiddenArea2.setVisible(false);
            hiddenArea2.setManaged(false);
        }
        if (hiddenArea3 != null) {
            hiddenArea3.setVisible(false);
            hiddenArea3.setManaged(false);
        }
        if (hiddenArea4 != null) {
            hiddenArea4.setVisible(false);
            hiddenArea4.setManaged(false);
        }
        if (hiddenArea5 != null) {
            hiddenArea5.setVisible(false);
            hiddenArea5.setManaged(false);
        }
        if (hiddenArea6 != null) {
            hiddenArea6.setVisible(false);
            hiddenArea6.setManaged(false);
        }
        if(hiddenArea7 != null) {
            hiddenArea7.setVisible(false);
            hiddenArea7.setManaged(false);
        }
        if (toggleButton1 != null) toggleButton1.setText("Search by Author");
        if (toggleButton2 != null) toggleButton2.setText("Add book");
        if (toggleButton3 != null) toggleButton3.setText("Add Student");
        if (toggleButton4 != null) toggleButton4.setText("Add Librarian");
        if (toggleButton5 != null) toggleButton5.setText("Search by Name");
        if (toggleButton6 != null) toggleButton6.setText("Borrow Book");
        if (toggleButton7 != null) toggleButton7.setText("Return Book");
    }

    // Helper method to hide results list
    private void hideResultsList() {
        resultsList.setVisible(false);
        resultsList.setManaged(false);
    }

    @FXML
    private void onSearchClicked() {
        resultsList.setVisible(true);
        resultsList.setManaged(true);
        String keyword = authorField.getText().trim();
        if (!keyword.isEmpty()) {
            resultsList.getItems().clear();
            List<String> books = library.getBooksByAuthor(keyword);
            resultsList.getItems().addAll(books);
        }
    }
    @FXML
    private TextField authorFieldN;
    @FXML
    private void searchByAuthor() {
        resultsList.setVisible(true);
        resultsList.setManaged(true);
        String keyword = authorField.getText().trim();
        if (!keyword.isEmpty()) {
            resultsList.getItems().clear();
            List<String> books = library.getBooksByAuthor(keyword);
            resultsList.getItems().addAll(books);
        }
    }
    @FXML
    private void searchByTitle() {
        resultsList.setVisible(true);
        resultsList.setManaged(true);
        String keyword = authorFieldN.getText().trim();
        if (!keyword.isEmpty()) {
            resultsList.getItems().clear();
            List<String> books = library.getBooksByTitle(keyword);
            resultsList.getItems().addAll(books);
        }
    }

    @FXML
    private void onAddBookClicked() {
        hideAllAreas();
        hideResultsList();

        String idText = idField.getText().trim();
        int id = Integer.parseInt(idText);
        String title = titleField.getText().trim();
        String author = authorField2.getText().trim();
        if (!title.isEmpty() && !author.isEmpty()) {
            library.addBook(new Book(id, title, author, true));
            idField.clear();
            titleField.clear();
            authorField2.clear();
        }
    }
    @FXML
    private TextField userNameFieldS;
    @FXML
    private PasswordField passwordFieldS;
    @FXML
    private void onAddStudentClicked(ActionEvent event) throws IOException {
        String fullname = nameFieldS.getText().trim();
        String name = userNameFieldS.getText().trim();
        String password = passwordFieldS.getText().trim();
        if (!fullname.isEmpty() && !name.isEmpty() && !password.isEmpty()) {
            boolean message = library.registerUser(new Student(fullname, name, password));
            if (message) {
                loginStatusLabel.setText("User Registered Successfully");
                switchToUi(event,name);
            }else {
                loginStatusLabel.setText("Username already exists");
            }
        }else {
            loginStatusLabel.setText("Signup Failed");
        }
    }
    @FXML
    private TextField userNameFieldL;
    @FXML
    private PasswordField passwordFieldL;
    @FXML
    private void onAddLibrarianClicked() {
        String name = nameFieldL.getText().trim();
        String username = userNameFieldL.getText().trim();
        String password = passwordFieldL.getText().trim();
        if (!name.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            library.registerUser(new Librarian(name,username,password));
            nameFieldL.clear();
            passwordFieldL.clear();
            userNameFieldL.clear();
        }
    }
    @FXML
    private void onAddStudentClickedL() {
        String name = nameFieldS.getText().trim();
        String username = userNameFieldS.getText().trim();
        String password = passwordFieldS.getText().trim();
        if (!name.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            library.registerUser(new Librarian(name,username,password));
            nameFieldS.clear();
            passwordFieldS.clear();
            userNameFieldS.clear();
        }
    }

    @FXML
    private void getAllBooks() {
        hideAllAreas();

        resultsList.setVisible(true);
        resultsList.setManaged(true);
        resultsList.getItems().clear();
        List<String> books = library.getAllBooks();
        resultsList.getItems().addAll(books);
    }

    @FXML
    private void getAllUsers() {
        hideAllAreas();

        resultsList.setVisible(true);
        resultsList.setManaged(true);
        resultsList.getItems().clear();
        List<String> users = library.getAllUsers();
        resultsList.getItems().addAll(users);
    }

    @FXML
    private void toggleArea1() {
        boolean currentlyVisible = hiddenArea1.isVisible();

        if (currentlyVisible) {
            // If currently visible, just hide it
            hiddenArea1.setVisible(false);
            hiddenArea1.setManaged(false);
            toggleButton1.setText("Search by Author");
            hideResultsList();
        } else {
            // If currently hidden, hide all other areas first, then show this one
            hideAllAreas();
            hideResultsList();
            hiddenArea1.setVisible(true);
            hiddenArea1.setManaged(true);
            toggleButton1.setText("Hide Area");
        }
    }
    @FXML
    private void toggleSearchByTitle() {
        boolean currentlyVisible = hiddenArea5.isVisible();
        if (currentlyVisible) {
            hiddenArea5.setVisible(false);
            hiddenArea5.setManaged(false);
            toggleButton5.setText("Search by Title");
            hideResultsList();
        }else{
            hideAllAreas();
            hideResultsList();
            hiddenArea5.setVisible(true);
            hiddenArea5.setManaged(true);
            toggleButton5.setText("Hide Area");
        }
    }

    @FXML
    private void toggleAddBookArea() {
        boolean currentlyVisible = hiddenArea2.isVisible();

        if (currentlyVisible) {
            // If currently visible, just hide it
            hiddenArea2.setVisible(false);
            hiddenArea2.setManaged(false);
            toggleButton2.setText("Add book");
            hideResultsList();
        } else {
            // If currently hidden, hide all other areas first, then show this one
            hideAllAreas();
            hideResultsList();
            hiddenArea2.setVisible(true);
            hiddenArea2.setManaged(true);
            toggleButton2.setText("Hide Area");
        }
    }

    @FXML
    private void toggleAddStudentArea() {
        boolean currentlyVisible = hiddenArea3.isVisible();

        if (currentlyVisible) {
            // If currently visible, just hide it
            hiddenArea3.setVisible(false);
            hiddenArea3.setManaged(false);
            toggleButton3.setText("Add Student");
            hideResultsList();
        } else {
            // If currently hidden, hide all other areas first, then show this one
            hideAllAreas();
            hideResultsList();
            hiddenArea3.setVisible(true);
            hiddenArea3.setManaged(true);
            toggleButton3.setText("Hide Area");
        }
    }

    @FXML
    private void toggleAddLibrarianArea() {
        boolean currentlyVisible = hiddenArea4.isVisible();

        if (currentlyVisible) {
            // If currently visible, just hide it
            hiddenArea4.setVisible(false);
            hiddenArea4.setManaged(false);
            toggleButton4.setText("Add Librarian");
            hideResultsList();
        } else {
            // If currently hidden, hide all other areas first, then show this one
            hideAllAreas();
            hideResultsList();
            hiddenArea4.setVisible(true);
            hiddenArea4.setManaged(true);
            toggleButton4.setText("Hide Area");
        }
    }
    @FXML
    private void toggleBorrowBook() {
        boolean currentlyVisible = hiddenArea6.isVisible();

        if (currentlyVisible) {
            // If currently visible, just hide it
            hiddenArea6.setVisible(false);
            hiddenArea6.setManaged(false);
            toggleButton6.setText("Borrow Book");
            hideResultsList();
        } else {
            // If currently hidden, hide all other areas first, then show this one
            hideAllAreas();
            hideResultsList();
            hiddenArea6.setVisible(true);
            hiddenArea6.setManaged(true);
            toggleButton6.setText("Hide Area");
        }
    }
    @FXML
    private void toggleReturnBook() {
        boolean currentlyVisible = hiddenArea7.isVisible();

        if (currentlyVisible) {
            // If currently visible, just hide it
            hiddenArea7.setVisible(false);
            hiddenArea7.setManaged(false);
            toggleButton7.setText("Return Book");
            hideResultsList();
        } else {
            // If currently hidden, hide all other areas first, then show this one
            hideAllAreas();
            hideResultsList();
            hiddenArea7.setVisible(true);
            hiddenArea7.setManaged(true);
            toggleButton7.setText("Hide Area");
        }
    }
    @FXML
    private Label loginStatusLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
//    @FXML
//    private void displayName(String username) {
//        name.setText("Welcome, " +username+ "!");
//    }
    @FXML
    private void onClickLogin(ActionEvent event) {
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            loginStatusLabel.setText("Please enter both username and password.");
        } else {
            Connection conn = db.connect();
            String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + usernameField.getText() + "' AND password = '" + passwordField.getText() + "'";
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(verifyLogin);
                while(rs.next()) {
                    if(rs.getInt(1)==1){
                        loginStatusLabel.setText("Login successful!");
                        switchToUi(event,usernameField.getText());
                    } else {
                        loginStatusLabel.setText("Invalid credentials.");
                    }
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    private Button logOutButton;
    @FXML
    private void onClickLogOut(ActionEvent event) throws IOException {
        switchTologin(event);
    }
    @FXML
    private TextField librarianUsernameField;
    @FXML
    private TextField librarianPasswordField;
    @FXML
    private void librarianLogin(ActionEvent event) throws SQLException, IOException {
        if (librarianUsernameField.getText().isEmpty() || librarianPasswordField.getText().isEmpty()) {
            loginStatusLabel.setText("Please enter both username and password.");
        } else {
            Connection conn = db.connect();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = 'Librarian'";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, librarianUsernameField.getText().trim());
            stmt.setString(2, librarianPasswordField.getText().trim());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                loginStatusLabel.setText("Login successful!");
                switchToAdminUi(event, librarianUsernameField.getText());
            } else {
                loginStatusLabel.setText("Invalid credentials.");
            }
        }
    }

    @FXML
    private TextField bookIdField;
    @FXML
    private void borrowBookByIdButton() throws SQLException {
        String text = bookIdField.getText().trim();
        if (text.isEmpty()) {
            StatusLabel.setText("⚠️ Please enter a Book ID.");
            return;
        }
        try {
            int bookId = Integer.parseInt(text);
            String result = library.borrowBookById(bookId,loggedInUsername);
            StatusLabel.setText(result);
            bookIdField.clear();
        } catch (NumberFormatException e) {
            StatusLabel.setText("❌ Invalid input! Please enter a valid numeric Book ID.");
        }
    }
    @FXML
    private TextField returnBookIdField;
    @FXML
    private Label StatusLabel;

    @FXML
    private void returnBookByIdButton() throws SQLException {
        String text = returnBookIdField.getText().trim();
        if (text.isEmpty()) {
            StatusLabel.setText("⚠️ Please enter a Book ID.");
            return;
        }
        try {
            int bookId = Integer.parseInt(text);
            String result = library.returnBookById(bookId, loggedInUsername);
            StatusLabel.setText(result);
            returnBookIdField.clear();
        } catch (NumberFormatException e) {
            StatusLabel.setText("❌ Invalid input! Please enter a valid numeric Book ID.");
        }
    }


}