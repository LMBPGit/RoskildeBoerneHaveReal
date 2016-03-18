package Builders;

import Models.Boern;
import Util.BoernUtil;
import Util.VenteListeUtil;
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

    private static boolean nytBarn;
    private static int count;


    public static void stamkort(String currentName) {
        nytBarn = true;
        count = 0;
        Boern currentBarn = new Boern("Indsæt navn", 0);

        if(!currentName.equals("Indsæt navn")){
            nytBarn = false;
            currentBarn = BoernUtil.getBarn(currentName);
        }


        Stage stamkortstage = new Stage();
        stamkortstage.initModality(Modality.APPLICATION_MODAL);
        VBox stamkortVbox = new VBox();

//laver Hbox barn:
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(0,0,0,400));

        Button sletBtn = new Button("slet");
        sletBtn.setOnAction(e -> {
            if(count == 0){
                count++;
                sletBtn.setText("SLET?!");
            }else{
                BoernUtil.removeBarnFraListen(currentName);
                stamkortstage.close();
                count = 0;
            }

        });
        hBox1.getChildren().add(sletBtn);

        HBox barn = new HBox();

        VBox barn1 = new VBox();

        Image image = new Image("file:barn.png");
        ImageView imageView = new ImageView(image);

        Label label = new Label("FOTO:");
        barn1.getChildren().addAll(label,imageView);
        barn1.setPadding(new Insets(0, 12, 15, 0));
        barn1.setSpacing(10);

        VBox barn2 = new VBox();
        TextField navn = new TextField(currentBarn.getName());
        Label navneLabel = new Label("NAVN:");
        TextField alder = new TextField(Integer.toString(currentBarn.getAlder()));
        Label alderLabel = new Label("ALDER:");
        barn2.getChildren().addAll(navneLabel,navn,alderLabel,alder);
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


        Rectangle kontakt = new Rectangle(412, 100);
        TextArea komentar = new TextArea();

        Label label4 = new Label("KONTAKT:");
        Label label5 = new Label("KOMENTAR:");

        Button tilbage = new Button("Tilbage");
        tilbage.setOnAction(event -> stamkortstage.close());

        Button saveBtn = new Button("Gem");
        saveBtn.setOnAction(e -> {
            if(nytBarn){
                BoernUtil.nytBarnTilListen(new Boern(navn.getText(), Integer.parseInt(alder.getText())));
            }else{
                BoernUtil.changeBarnInfo(new Boern(navn.getText(), Integer.parseInt(alder.getText())));
            }
            stamkortstage.close();
        });


        HBox buttonsBox = new HBox(tilbage, saveBtn);
        buttonsBox.setSpacing(20);

        stamkortVbox.getChildren().addAll(hBox1, barn, forældre, label4, kontakt, label5, komentar, buttonsBox);

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