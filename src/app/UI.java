package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import library.Library;

import java.io.IOException;
import java.util.List;

public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
        Parent root = loader.load();
//        VBox root = new VBox(10, loadBooksButton, listView);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Library System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
