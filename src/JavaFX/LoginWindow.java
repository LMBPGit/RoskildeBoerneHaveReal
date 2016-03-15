package JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.layout.HBox;


public class LoginWindow  extends Application {

    Stage window;

    Button enterButton;
    Button cancelButton;

    TextField passText;
    TextField userText;

    HBox loginBoxBottom;
    HBox loginBoxTop;

    VBox loginWhole;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Roskilde Børnehave");

        loginBoxBottom = new HBox();
        loginBoxBottom.setPadding(new Insets(20,20,20,20));
        loginBoxBottom.setSpacing(20);
        loginBoxBottom.setAlignment(Pos.BOTTOM_RIGHT);

        loginBoxTop = new HBox();
        loginBoxTop.setPadding(new Insets(20,20,20,20));
        loginBoxTop.setSpacing(20);
        loginBoxTop.setAlignment(Pos.BOTTOM_CENTER);

        loginWhole = new VBox();


        enterButton = new Button();
        enterButton.setText("Enter");
        enterButton.setMinSize(60,20);


        cancelButton = new Button();
        cancelButton.setText("Cancel");
        cancelButton.setMinSize(60,20);
        cancelButton.setOnAction(e -> window.close());


        passText = new TextField();
        passText.setPromptText("Password");


        userText = new TextField();
        userText.setPromptText("Unsername");

        loginBoxBottom.getChildren().addAll(cancelButton,enterButton);

        loginBoxTop.getChildren().addAll(userText,passText);

        loginWhole.getChildren().addAll(loginBoxTop,loginBoxBottom);

        Scene scene1 = new Scene(loginWhole,400,150);
        window.setScene(scene1);
        window.show();
    }
}
