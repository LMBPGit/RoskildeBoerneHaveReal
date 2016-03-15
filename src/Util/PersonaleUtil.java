package Util;

import Models.Personale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class PersonaleUtil {

    public static ObservableList<Personale> getPersonale(){
        ObservableList<Personale> personaleListe = FXCollections.observableArrayList();

        personaleListe.add(new Personale("John", "12345678", "Albentevej 40", "230289-2013"));// TEMPLISTE SKAL HENTE LISTE FRA FIL
        personaleListe.add(new Personale("Birgitte", "12345678", "Albentevej 40", "230289-2013"));// TEMPLISTE SKAL HENTE LISTE FRA FIL

        return personaleListe;
    }

    public static BorderPane addSygeDag(){
        BorderPane sygeSkabelon = new BorderPane();

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
