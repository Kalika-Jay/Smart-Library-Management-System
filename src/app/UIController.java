package app;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import library.Book;
import library.Library;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class UIController {

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
    private Button toggleButton1;
    @FXML
    private Button toggleButton2;

    private final Library library = new Library();

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
        hiddenArea1.setVisible(false);
        hiddenArea1.setManaged(false);
        resultsList.setVisible(false);
        resultsList.setManaged(false);
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
    private void getAllBooks() {
        hiddenArea1.setVisible(false);
        hiddenArea1.setManaged(false);
        resultsList.setVisible(true);
        resultsList.setManaged(true);
        resultsList.getItems().clear();
        List<String> books = library.getAllBooks();
        resultsList.getItems().addAll(books);
    }
    @FXML
    private void getAllUsers() {
        hiddenArea1.setVisible(false);
        hiddenArea1.setManaged(false);
        resultsList.setVisible(true);
        resultsList.setManaged(true);
        resultsList.getItems().clear();
        List<String> users = library.getAllUsers();
        resultsList.getItems().addAll(users);
    }

    @FXML
    private void toggleArea1() {
        boolean currentlyVisible = hiddenArea1.isVisible();
        hiddenArea1.setVisible(!currentlyVisible);
        hiddenArea1.setManaged(!currentlyVisible);
        toggleButton1.setText(currentlyVisible ? "Search by Author" : "Hide Area");
    }
    @FXML
    private void toggleArea2() {
        boolean currentlyVisible = hiddenArea2.isVisible();
        hiddenArea2.setVisible(!currentlyVisible);
        hiddenArea2.setManaged(!currentlyVisible);
        toggleButton2.setText(currentlyVisible ? "Add book" : "Hide Area");
    }
}
