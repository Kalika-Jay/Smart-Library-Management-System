package app;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import library.Library; // your existing Library class
import java.util.List;
import library.Library;

public class UIController {

    @FXML
    private TextField authorField;

    @FXML
    private ListView<String> resultsList;

    private final Library library = new Library();

    @FXML
    private void onSearchClicked() {
        String keyword = authorField.getText().trim();
        if (!keyword.isEmpty()) {
            resultsList.getItems().clear();
            List<String> books = library.getBooksByAuthor(keyword); // modify to allow keyword search
            resultsList.getItems().addAll(books);
        }
    }
    @FXML
    private void getAllBooks() {
        resultsList.getItems().clear();
        List<String> books = library.getAllBooks();
        resultsList.getItems().addAll(books);
    }
    @FXML
    private void getAllUsers() {
        resultsList.getItems().clear();
        List<String> users = library.getAllUsers();
        resultsList.getItems().addAll(users);
    }
}
