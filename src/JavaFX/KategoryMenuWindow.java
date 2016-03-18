package JavaFX;

import Builders.BoerneTab;
import Builders.PersonaleTab;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class KategoryMenuWindow {

    Stage window;
    Button kategoriLogUd;
    HBox kategoriTop;
    HBox kategoriBottom;
    VBox kategoriWhole;
    Scene kategoriScene;

    public Scene start(Stage primaryStage){

        window = primaryStage;

        kategoriTop = new HBox();
        kategoriTop.setPrefSize(400, 500);
        kategoriTop.setAlignment(Pos.CENTER);

        kategoriBottom = new HBox();
        kategoriBottom.setAlignment(Pos.CENTER_LEFT);
        kategoriBottom.setPadding(new Insets(10,10,10,10));

        kategoriWhole = new VBox();

        BoerneTab boerneTab = new BoerneTab();
        PersonaleTab personaleTab = new PersonaleTab();
        TabPane kategoriTabs = new TabPane(boerneTab.start(), personaleTab.start());

        kategoriLogUd = new Button();
        kategoriLogUd.setText("Log ud");
        kategoriLogUd.setOnAction(e -> {
            LoginBox loginBox = new LoginBox();
            window.setScene(loginBox.start(primaryStage));
        });

        kategoriTop.getChildren().addAll(kategoriTabs);
        kategoriTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        kategoriBottom.getChildren().addAll(kategoriLogUd);
        kategoriWhole.getChildren().addAll(kategoriTop,kategoriBottom);
        kategoriScene = new Scene(kategoriWhole,430,500);
        window.setScene(kategoriScene);

        return kategoriScene;

    }
}
