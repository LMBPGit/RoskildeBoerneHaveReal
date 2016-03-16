package Util;

import Models.Personale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class PersonaleUtil {

    public static ObservableList<Personale> getPersonale(){
        ObservableList<Personale> personaleListe = FXCollections.observableArrayList();

        personaleListe.add(new Personale("Sven", 32552912,"Nørregade 44", 2039123982, 08.00, 08.00, 08.00, 08.00, 08.00));
        personaleListe.add(new Personale("Erik", 28376432,"Nørregade 44", 2039123982, 08.00, 08.00, 08.00, 08.00, 08.00));
        personaleListe.add(new Personale("Mette", 32552912,"Nørregade 44", 2039123982, 08.00, 08.00, 08.00, 08.00, 08.00));
        personaleListe.add(new Personale("Karina", 32552912,"Nørregade 44", 2039123982, 08.00, 08.00, 08.00, 08.00, 08.00));
        return personaleListe;
    }

    public static VBox addSygeDag(){

        TextField nameSyg = new TextField();
        nameSyg.setPromptText("Navn paa den syge");
        TextField tidsyg = new TextField();
        tidsyg.setPromptText("SygeTid");
        TextField sygeDag = new TextField();
        sygeDag.setPromptText("SygeDag");
        TextField nameErstat = new TextField();
        nameErstat.setPromptText("Navn på erstatning");
        TextField tidErstat = new TextField();
        tidErstat.setPromptText("Erstatningstid");

        Rectangle bottomLine = new Rectangle(200, 10);
        Rectangle profilBillede = new Rectangle(70, 100);
        profilBillede.setFill(Color.LIGHTBLUE);

        HBox sygPerson = new HBox(nameSyg, tidsyg, sygeDag);
        HBox erstatPerson = new HBox(nameErstat, tidErstat);
        VBox sygeSkabelon = new VBox(sygPerson, erstatPerson);


        return sygeSkabelon;
    }

    public static BorderPane addPersonale(){
        BorderPane personaleSkabelon = new BorderPane();
        TextField nameInput = new TextField();
        nameInput.setPromptText("navn");
        TextField mobilnrInput = new TextField();
        mobilnrInput.setPromptText("mobilnr");
        TextField addressInput = new TextField();
        addressInput.setPromptText("addresse");
        TextField cprnrInput = new TextField();
        cprnrInput.setPromptText("cpr-nr");
        Rectangle bottomLine = new Rectangle(200, 10);
        Rectangle profilBillede = new Rectangle(70, 100);
        profilBillede.setFill(Color.LIGHTBLUE);

        VBox infoBox = new VBox(nameInput, mobilnrInput, addressInput, cprnrInput, bottomLine);
        personaleSkabelon.setCenter(infoBox);
        personaleSkabelon.setLeft(profilBillede);

        return personaleSkabelon;
    }


    public static VBox loadPersonale(){
        VBox oldPersonale = new VBox();

        return oldPersonale;
    }

}
