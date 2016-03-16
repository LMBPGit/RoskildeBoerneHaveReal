package JavaFX;

import Builders.BoerneMenuWindow;
import Builders.PersonaleMenuWindow;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by FrederikPetersen on 15/03/2016.
 */
public class LoginBox{

    Stage window;
    Button enterButton;
    Button cancelButton;
    Button kategoriBørn;
    Button kategoriPersonale;
    Button kategoriLogUd;
    TextField passText;
    TextField userText;
    HBox loginBoxBottom;
    HBox loginBoxTop;
    HBox kategoriTop;
    HBox kategoriBottom;
    VBox loginWhole;
    VBox kategoriWhole;
    Scene kategoriScene;
    BoerneMenuWindow boerneMenuWindow;



    public Scene start(Stage primaryStage){
        window = primaryStage;

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
        enterButton.setOnAction(e -> {
            KategoryMenuWindow ktm = new KategoryMenuWindow();
            window.setScene(ktm.start(window));
        });

        cancelButton = new Button();
        cancelButton.setText("Cancel");
        cancelButton.setMinSize(60,20);
        cancelButton.setOnAction(e -> {
            System.out.println("System Closed");
            window.close();
        });


        passText = new TextField();
        passText.setPromptText("Password");

        userText = new TextField();
        userText.setPromptText("Unsername");

        loginBoxBottom.getChildren().addAll(cancelButton,enterButton);
        loginBoxTop.getChildren().addAll(userText,passText);

        loginWhole.getChildren().addAll(loginBoxTop,loginBoxBottom);

        Scene scene1 = new Scene(loginWhole,400,150);

//____________________________________________________________________________//

       /* kategoriTop = new HBox();
        kategoriTop.setPadding(new Insets(20,20,20,20));
        kategoriTop.setSpacing(20);
        kategoriTop.setAlignment(Pos.CENTER);

        kategoriBottom = new HBox();
        kategoriBottom.setPadding(new Insets(20,20,20,20));
        kategoriBottom.setSpacing(20);
        kategoriBottom.setAlignment(Pos.BOTTOM_CENTER);

        kategoriWhole = new VBox();

        kategoriBørn = new Button();
        kategoriBørn.setText("Børn");
        kategoriBørn.setMinSize(60,20);

        kategoriPersonale = new Button();
        kategoriPersonale.setText("Personale");
        kategoriPersonale.setMinSize(60,20);

        BoerneMenuWindow boerneMenuWindow = new BoerneMenuWindow();
        kategoriBørn.setOnAction(e -> {
            window.setScene(boerneMenuWindow.start(window));
        });

        PersonaleMenuWindow personaleMenuWindow = new PersonaleMenuWindow();
        kategoriPersonale.setOnAction(e -> {
            window.setScene(personaleMenuWindow.start(window));

        });

        kategoriLogUd = new Button();
        kategoriLogUd.setText("Log ud");
        kategoriLogUd.setMinSize(60,20);
        kategoriLogUd.setOnAction(e -> window.setScene(scene1));

        kategoriTop.getChildren().addAll(kategoriBørn,kategoriPersonale);
        kategoriBottom.getChildren().addAll(kategoriLogUd);

        kategoriWhole.getChildren().addAll(kategoriTop,kategoriBottom);

        kategoriScene = new Scene(kategoriWhole,400,150);*/

        return scene1;
    }
}
