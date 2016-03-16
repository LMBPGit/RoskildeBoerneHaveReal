package Builders;

import JavaFX.KategoryMenuWindow;
import JavaFX.LoginBox;
import Models.Personale;
import Util.PersonaleUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

public class PersonaleMenuWindow{

    
    public Scene start(Stage primaryStage) {

        BorderPane outerWindow = new BorderPane();

    //VagtPlan Tab
        // Table
        TableView<Personale> personaleTable = new TableView<>();
        personaleTable.setPrefSize(200, 200);
        personaleTable.setItems(PersonaleUtil.getPersonale());
        personaleTable.setEditable(true);

        TableColumn<Personale, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(e -> e.getValue().nameProperty());
        nameColumn.setEditable(false);

        TableColumn<Personale, Double> mandagColumn = new TableColumn<>("Mandag");
        mandagColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        mandagColumn.setCellValueFactory(e -> e.getValue().mandagtidProperty().asObject());

        mandagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, Double> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setMandagtid(e.getNewValue());
        });

        TableColumn<Personale, Double> tirsdagColumn = new TableColumn<>("Tirsdag");
        tirsdagColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tirsdagColumn.setCellValueFactory(e -> e.getValue().tirsdagtidProperty().asObject());

        tirsdagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, Double> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setTirsdagtid(e.getNewValue());
        });

        TableColumn<Personale, Double> onsdagColumn = new TableColumn<>("Onsdag");
        onsdagColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        onsdagColumn.setCellValueFactory(e -> e.getValue().onsdagtidProperty().asObject());

        onsdagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, Double> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setOnsdagtid(e.getNewValue());
        });

        TableColumn<Personale, Double> torsdagColumn = new TableColumn<>("Torsdag");
        torsdagColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        torsdagColumn.setCellValueFactory(e -> e.getValue().torsdagtidProperty().asObject());

        torsdagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, Double> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setTorsdagtid(e.getNewValue());
        });

        TableColumn<Personale, Double> fredagColumn = new TableColumn<>("Fredag");
        fredagColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        fredagColumn.setCellValueFactory(e -> e.getValue().fredagtidProperty().asObject());

        mandagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, Double> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setMandagtid(e.getNewValue());
        });

        personaleTable.getColumns().addAll(nameColumn, mandagColumn, tirsdagColumn, onsdagColumn, torsdagColumn, fredagColumn);

        VBox vagtPlan = new VBox(personaleTable);
        personaleTable.setPadding(new Insets(20,20,20,20));

        Tab vagtPlanTab = new Tab("Vagtplan", vagtPlan);

    //Sygemeldings Tab
        ScrollPane overvindue = new ScrollPane();

        Button addsygedagbtn = new Button("ADD");
        VBox sygeMeldinger = new VBox(addsygedagbtn);

        addsygedagbtn.setOnAction(e -> {
            PersonaleUtil.addSygeDag();
        });

        overvindue.setContent(sygeMeldinger);
        overvindue.setPadding(new Insets(20,20,20,20));
        overvindue.setPrefSize(400, 400);

        Tab sygTab = new Tab("Sygemeldinger", overvindue);

// Personale Liste

        BorderPane listvindue = new BorderPane();
        ScrollPane listeScroler = new ScrollPane();
        VBox personaleVbox = new VBox();

        Button addPersonaleBtn = new Button("Tilføj Personale");

        addPersonaleBtn.setOnAction(e -> {
            personaleVbox.getChildren().add(PersonaleUtil.addPersonale());
        });

        listvindue.setPadding(new Insets(20,20,20,20));
        listvindue.setPrefSize(200, 200);
        listvindue.setLeft(listeScroler);
        listvindue.setCenter(addPersonaleBtn);
        listeScroler.setContent(personaleVbox);
        listeScroler.setPadding(new Insets(20,20,20,20));
        listeScroler.setPrefSize(260, 260);

        Tab personaleListeTab = new Tab("PersonaleListe", listvindue);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Navn");

        Button addButton = new Button("Tilføj");

// Overvindue
        TabPane personaleTabs = new TabPane(vagtPlanTab, sygTab, personaleListeTab);
        personaleTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Button tilbageBtn = new Button("Tilbage");
        tilbageBtn.setOnAction(e ->{
            KategoryMenuWindow kmw = new KategoryMenuWindow();
            primaryStage.setScene(kmw.start(primaryStage));
        });

        outerWindow.setCenter(personaleTabs);
        outerWindow.setBottom(tilbageBtn);
        outerWindow.setAlignment(tilbageBtn, Pos.CENTER_RIGHT);
        outerWindow.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(outerWindow);

        return scene;
    }

}
