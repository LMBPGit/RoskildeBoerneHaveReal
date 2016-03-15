package JavaFX;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BoerneMenuWindow {

    public static void BoerneScene(Stage stage, Scene preScene){

        BorderPane outerWindow = new BorderPane();


        Label label = new Label("wraef");
        outerWindow.getChildren().add(label);


        Scene newScene = new Scene(outerWindow);

        stage.setScene(newScene);
        stage.show();
    }


}
