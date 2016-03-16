package Builders;

import Util.BoernUtil;
import Util.PersonaleUtil;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoerneMenuWindow {

    public Scene start(Stage primaryStage){

        BorderPane outerWindow = new BorderPane();
        outerWindow.setPrefSize(400, 400);

        BorderPane listvindue = new BorderPane();
        ScrollPane listeScroler = new ScrollPane();
        VBox boerneVbox = new VBox();
        VBox tidligereBoernVbox = BoernUtil.tidligereBoern();
        boerneVbox.getChildren().add(tidligereBoernVbox);

        Button addBarnBtn = new Button("Tilføj Barn");

        addBarnBtn.setOnAction(e -> {
            boerneVbox.getChildren().add(BoernUtil.addBarn());
        });

        listvindue.setPadding(new Insets(20,20,20,20));
        listvindue.setPrefSize(200, 200);
        listvindue.setLeft(listeScroler);
        listvindue.setRight(addBarnBtn);
        listeScroler.setContent(boerneVbox);
        listeScroler.setPadding(new Insets(20,20,20,20));
        listeScroler.setPrefSize(260, 260);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Navn");

        Button addButton = new Button("Tilføj");

        Tab boerneListeTab = new Tab("BørneListe", listvindue);
        Tab venteListeTab = new Tab("");

        TabPane boerneTabs = new TabPane(boerneListeTab, venteListeTab);
        boerneTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        outerWindow.setCenter(boerneTabs);

        Scene Scene = new Scene(outerWindow);
        return Scene;
    }
}
