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
import javafx.scene.image.Image;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();


        // Create scene with minimum size
        Scene login = new Scene(root,800,600);
//        Scene scene = new Scene(root, 800, 600);

        // Set up the stage for resizing
        primaryStage.setTitle("Library Management System");
        Image icon = new Image(getClass().getResourceAsStream("Library.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(login);

        // Set minimum window size to prevent UI from breaking
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(500);

        // Optional: Set maximum size if you want to limit how large it can get
        // primaryStage.setMaxWidth(1200);
        // primaryStage.setMaxHeight(900);

        // Make the window resizable (this is true by default)
        primaryStage.setResizable(true);

        // Optional: Center the window on screen
        primaryStage.centerOnScreen();

        primaryStage.show();
    }
}
