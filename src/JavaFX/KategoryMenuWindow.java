package JavaFX;

import Builders.BoerneMenuWindow;
import Builders.PersonaleMenuWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class KategoryMenuWindow {

    Stage window;
    Button kategoriBørn;
    Button kategoriPersonale;
    Button kategoriLogUd;
    HBox kategoriTop;
    HBox kategoriBottom;
    VBox kategoriWhole;
    Scene kategoriScene;

    public Scene start(Stage primaryStage){

        window = primaryStage;

        kategoriTop = new HBox();
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
        kategoriLogUd.setOnAction(e -> {
            LoginBox loginBox = new LoginBox();
            window.setScene(loginBox.start(primaryStage));
        });

        kategoriTop.getChildren().addAll(kategoriBørn,kategoriPersonale);

        kategoriBottom.getChildren().addAll(kategoriLogUd);

        kategoriWhole.getChildren().addAll(kategoriTop,kategoriBottom);

        kategoriScene = new Scene(kategoriWhole,400,150);

        window.setScene(kategoriScene);

        return kategoriScene;

    }
}
