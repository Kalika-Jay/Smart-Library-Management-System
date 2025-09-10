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
import java.sql.Connection;
import database.db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javafx.scene.layout.VBox;
import library.Student;

public class UIController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeLabel;

    public void setWelcomeMessage(String username) {
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
    private Button toggleButton1;
    @FXML
    private Button toggleButton2;
    @FXML
    private Button toggleButton3;
    @FXML
    private Button toggleButton4;
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
        hiddenArea1.setVisible(false);
        hiddenArea1.setManaged(false);
        hiddenArea2.setVisible(false);
        hiddenArea2.setManaged(false);
        hiddenArea3.setVisible(false);
        hiddenArea3.setManaged(false);
        hiddenArea4.setVisible(false);
        hiddenArea4.setManaged(false);

        toggleButton1.setText("Search by Author");
        toggleButton2.setText("Add book");
        toggleButton3.setText("Add Student");
        toggleButton4.setText("Add Librarian");
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
            library.registerUser(new Student(fullname, name, password));
            switchToUi(event,name);
        }else {
            loginStatusLabel.setText("Signup Failed");
        }
    }

//    @FXML
//    private void onAddLibrarianClicked() {
//        hideAllAreas();
//        hideResultsList();
//
//        String uidText = uidFieldL.getText().trim();
//        int id = Integer.parseInt(uidText);
//        String name = nameFieldL.getText().trim();
//        if (!name.isEmpty() && !uidText.isEmpty()) {
//            library.registerUser(new Librarian(fu));
//            uidFieldL.clear();
//            nameFieldL.clear();
//        }
//    }

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
            String verifyLogin = "SELECT count(1) FROM users WHERE name = '" + usernameField.getText() + "' AND password = '" + passwordField.getText() + "'";
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

}