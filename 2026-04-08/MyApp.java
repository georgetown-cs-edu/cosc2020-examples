/**
 * 
 * mvn compile        # compile
 * mvn javafx:run     # compile and run the app
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyApp extends Application {

    @Override
    public void start(Stage stage) {
        // Build the scene graph
        Label label = new Label("Hello!");
        StackPane root = new StackPane(label);

        // Create a scene (width x height)
        Scene scene = new Scene(root, 400, 300);

        // Configure and show the window
        stage.setTitle("My First JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);   // starts the JavaFX runtime
    }
}

