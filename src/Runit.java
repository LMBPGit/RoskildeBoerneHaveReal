import JavaFX.LoginBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runit extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginBox loginBox = new LoginBox();
        primaryStage.setScene(loginBox.start(primaryStage));
        primaryStage.setTitle("Roskilde BoerneHave");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
