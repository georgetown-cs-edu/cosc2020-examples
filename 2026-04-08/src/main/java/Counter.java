/**
 * 
 * mvn compile        # compile
 * mvn javafx:run     # compile and run the app
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;

public class Counter extends Application {
    private int count = 0;

    @Override
    public void start(Stage stage) {
        Label display = new Label("Count: 0");
        Button increment = new Button("Increment");
        Button reset = new Button("Reset");

        increment.setOnAction(e -> display.setText("Count: " + ++count));
        reset.setOnAction(e -> {
            count = 0;
            display.setText("Count: 0");
        });

        VBox root = new VBox(12, display, increment, reset);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        stage.setScene(new Scene(root, 250, 200));
        stage.setTitle("Counter");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
