package JavaFX;

import Models.Personale;
import Util.PersonaleUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PersonaleMenuWindow extends Application{

    
    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage window = primaryStage;

        BorderPane outerMenu = new BorderPane();

    //VagtPlan Tab
        // Table
        TableView<Personale> personaleTable = new TableView<>();
        personaleTable.setPrefSize(10, 10);
        personaleTable.setItems(PersonaleUtil.getPersonale());
        personaleTable.setEditable(true);

        TableColumn<Personale, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(e -> e.getValue().nameProperty());
        nameColumn.setEditable(false);

        TableColumn<Personale, String> mandagColumn = new TableColumn<>("Mandag");
        mandagColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mandagColumn.setCellValueFactory(e -> e.getValue().mandagtidProperty());

        mandagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, String> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setMandagtid(e.getNewValue());
        });

        TableColumn<Personale, String> tirsdagColumn = new TableColumn<>("Tirsdag");
        tirsdagColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tirsdagColumn.setCellValueFactory(e -> e.getValue().tirsdagtidProperty());

        tirsdagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, String> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setTirsdagtid(e.getNewValue());
        });

        TableColumn<Personale, String> onsdagColumn = new TableColumn<>("Onsdag");
        onsdagColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        onsdagColumn.setCellValueFactory(e -> e.getValue().onsdagtidProperty());

        onsdagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, String> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setOnsdagtid(e.getNewValue());
        });

        TableColumn<Personale, String> torsdagColumn = new TableColumn<>("Torsdag");
        torsdagColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        torsdagColumn.setCellValueFactory(e -> e.getValue().torsdagtidProperty());

        torsdagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, String> e) -> {
            (e.getTableView().getItems().get(e.getTablePosition().getRow())).setTorsdagtid(e.getNewValue());
        });

        TableColumn<Personale, String> fredagColumn = new TableColumn<>("Fredag");
        fredagColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fredagColumn.setCellValueFactory(e -> e.getValue().fredagtidProperty());

        mandagColumn.setOnEditCommit((TableColumn.CellEditEvent<Personale, String> e) -> {
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
            //Scene newScene = BoerneMenuWindow.BoerneScene();
            //primaryStage.setScene(newScene);
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

//inputs
        TextField nameInput = new TextField();
        nameInput.setPromptText("Navn");

        Button addButton = new Button("Tilføj");

        TabPane personaleTabs = new TabPane(vagtPlanTab, sygTab, personaleListeTab);
        personaleTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Button tilbageBtn = new Button("Log ud");
        tilbageBtn.setOnAction(event -> primaryStage.close());

        outerMenu.setCenter(personaleTabs);

        personaleTable.setPrefSize(200, 200);


        Scene scene = new Scene(outerMenu);
        personaleTabs.setPrefSize(600, 600);

        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
