package Builders;

import Models.Boern;
import Util.BoernUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.util.ArrayList;

/**
 * Created by svend on 15-03-2016.
 */
public class StamkortClass {

    public static void stamkort(String currentName) {

        Boern currentBarn = BoernUtil.getBarn(currentName);

        Stage stamkortstage = new Stage();
        stamkortstage.initModality(Modality.APPLICATION_MODAL);
        VBox stamkortVbox = new VBox();

//laver Hbox barn:

        HBox barn = new HBox();

        VBox barn1 = new VBox();

        Rectangle billede = new Rectangle(100,100);

        Label label = new Label("FOTO:");
        barn1.getChildren().addAll(label,billede);
        barn1.setPadding(new Insets(0, 12, 15, 0));
        barn1.setSpacing(10);

        VBox barn2 = new VBox();
        TextField navn = new TextField(currentBarn.getName());
        Label label1 = new Label("NAVN:");
        barn2.getChildren().addAll(label1,navn);
        barn2.setPadding(new Insets(0, 12, 15, 0));
        barn2.setSpacing(10);

        barn.setPadding(new Insets(0, 12, 15, 0));
        barn.setSpacing(10);

        barn.getChildren().addAll(barn1,barn2);

//laver Hbox forældre:

        HBox forældre = new HBox();

        VBox forældre1 = new VBox();
        Rectangle mor = new Rectangle(200,100);
        Label label2 = new Label("MOR:");
        forældre1.getChildren().addAll(label2,mor);
        forældre1.setPadding(new Insets(0, 12, 15, 0));
        forældre1.setSpacing(10);

        VBox forældre2 = new VBox();
        Rectangle far = new Rectangle(200,100);
        Label label3 = new Label("FAR:");
        forældre2.getChildren().addAll(label3,far);
        forældre2.setPadding(new Insets(0, 12, 15, 0));
        forældre2.setSpacing(10);

        forældre.setPadding(new Insets(0, 12, 15, 0));
        forældre.setSpacing(10);

        forældre.getChildren().addAll(forældre1,forældre2);

        //laver Hbox kontakt/komentar:

        HBox diverse = new HBox();

        Rectangle kontakt = new Rectangle(412, 100);
        TextArea komentar = new TextArea();

        Label label4 = new Label("KONTAKT:");
        Label label5 = new Label("KOMENTAR:");

        Button tilbage = new Button("TILBAGE");
        tilbage.setOnAction(event -> stamkortstage.close());

        Button saveBtn = new Button("Gem");
        saveBtn.setOnAction(e -> {
            stamkortstage.close();
            BoernUtil.changeBarnInfo(new Boern(navn.getText(), 4));
        });

        HBox buttonsBox = new HBox(tilbage, saveBtn);

        stamkortVbox.getChildren().addAll(barn, forældre, label4, kontakt, label5, komentar, buttonsBox);

        stamkortVbox.setPadding(new Insets(15, 12, 15, 12));
        stamkortVbox.setSpacing(10);


        Scene scene = new Scene(stamkortVbox);
        stamkortstage.setScene(scene);
        stamkortstage.setTitle("Stamkort");
        stamkortstage.setHeight(700);
        stamkortstage.setWidth(600);
        stamkortstage.showAndWait();

    }
}