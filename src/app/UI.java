package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import library.Library;

import java.util.List;

public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Library library = new Library();
        ListView<String> listView = new ListView<>();

        Button loadBooksButton = new Button("Load Books");
        loadBooksButton.setOnAction(e -> {
            listView.getItems().clear();
            List<String> books = library.getAllBooks();
            listView.getItems().addAll(books);
        });

        VBox root = new VBox(10, loadBooksButton, listView);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Library System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
