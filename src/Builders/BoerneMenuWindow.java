package Builders;

import JavaFX.KategoryMenuWindow;
import JavaFX.LoginBox;
import Util.BoernUtil;
import Util.PersonaleUtil;
import Util.VenteListeUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoerneMenuWindow {

    public Scene start(Stage primaryStage){

        BorderPane outerWindow = new BorderPane();
        outerWindow.setPrefSize(450, 400);

        Tab boerneListeTab = new Tab();
        BorderPane listvindue = new BorderPane();
        ScrollPane listeScroler = new ScrollPane();
        VBox boerneVbox = new VBox();
        VBox tidligereBoernVbox = BoernUtil.tidligereBoern();
        boerneVbox.getChildren().add(tidligereBoernVbox);

        Button addBarnBtn = new Button("Tilføj Barn");
        addBarnBtn.setOnAction(e -> StamkortClass.stamkort("Indsæt navn"));

        Button reloadBtn = new Button("genindlæs listen");
        reloadBtn.setOnAction(e -> {
            tidligereBoernVbox.getChildren().clear();
            tidligereBoernVbox.getChildren().add(reloadBoerneListe());
        });

        VBox btnVbox = new VBox(addBarnBtn, reloadBtn);
        btnVbox.setSpacing(10);
        btnVbox.setPadding(new Insets(10, 10, 10, 10));

        listvindue.setPadding(new Insets(20,20,20,20));
        listvindue.setPrefSize(200, 200);
        listvindue.setLeft(listeScroler);
        listvindue.setRight(btnVbox);
        listeScroler.setContent(boerneVbox);
        listeScroler.setPadding(new Insets(20,20,20,20));
        listeScroler.setPrefSize(260, 260);

        boerneListeTab.setContent(listvindue);
        boerneListeTab.setText("BørneListe");
//__________________________________________________________________________________________//
        //Tab venteliste

        BorderPane venteListVindue = new BorderPane();
        ScrollPane ventelisteScroler = new ScrollPane();
        ListView ventelisten = new ListView();

        venteListVindue.setPadding(new Insets(20,20,20,20));
        venteListVindue.setPrefSize(200, 200);
        venteListVindue.setLeft(ventelisteScroler);
        ventelisteScroler.setContent(ventelisten);
        ventelisteScroler.setPadding(new Insets(20,20,20,20));
        ventelisteScroler.setPrefSize(260, 260);

        ObservableList obsList = FXCollections.observableArrayList();
        obsList.addAll(VenteListeUtil.loadVenteListen());
        ventelisten.setItems(obsList);
        ventelisteScroler.setContent(ventelisten);

        TextField nytBarnVenteListe = new TextField();
        nytBarnVenteListe.setPromptText("Navn");

        Button nytBarnBtn = new Button("tilføj");
        nytBarnBtn.setOnAction(e -> {
            VenteListeUtil.nytBarnTilVenteListen(nytBarnVenteListe.getText());
            ventelisten.getItems().clear();
            ventelisten.setItems(reloadVenteListen());
        });

        Button sletBarnBtn = new Button("slet barn");
        sletBarnBtn.setOnAction(e -> {
            VenteListeUtil.fjernBarnFraVenteListen(nytBarnVenteListe.getText());
            ventelisten.getItems().clear();
            ventelisten.setItems(reloadVenteListen());
        });

        HBox buttonHbox = new HBox(sletBarnBtn, nytBarnBtn);
        buttonHbox.setSpacing(20);

        VBox optionVbox = new VBox(nytBarnVenteListe, buttonHbox);
        optionVbox.setSpacing(20);

        venteListVindue.setCenter(optionVbox);

        Tab venteListeTab = new Tab("VenteListe", venteListVindue);

        TabPane boerneTabs = new TabPane(boerneListeTab, venteListeTab);
        boerneTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Button tilbageBtn = new Button("Tilbage");
        tilbageBtn.setOnAction(e ->{
            KategoryMenuWindow kmw = new KategoryMenuWindow();
            primaryStage.setScene(kmw.start(primaryStage));
        });

        outerWindow.setCenter(boerneTabs);
        outerWindow.setBottom(tilbageBtn);
        outerWindow.setAlignment(tilbageBtn, Pos.CENTER_RIGHT);
        outerWindow.setPadding(new Insets(10,10,10,10));

        Scene Scene = new Scene(outerWindow);
        return Scene;
    }

    private VBox reloadBoerneListe(){

        VBox boerneVbox = new VBox();
        VBox tidligereBoernVbox = BoernUtil.tidligereBoern();
        boerneVbox.getChildren().add(tidligereBoernVbox);

        return boerneVbox;
    }

    private ObservableList reloadVenteListen(){
        ListView tempListView = new ListView();
        ObservableList obsList = FXCollections.observableArrayList();
        obsList.addAll(VenteListeUtil.loadVenteListen());

        return obsList;
    }

}
