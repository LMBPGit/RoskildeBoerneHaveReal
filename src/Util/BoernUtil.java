package Util;

import Builders.StamkortClass;
import Models.Boern;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.ArrayList;


public class BoernUtil {

    private static int currentIndex;

    private static File boerneFil = new File("boernefil.txt");

    public static void nytBarnTilListen(Boern nytBarn){
        ArrayList<Boern> boerneListe = loadBoern();
        boerneListe.add(nytBarn);
        saveBoern(boerneListe);
    }

    public static void removeBarnFraListen(String name){
        ArrayList<Boern> boerneListe = loadBoern();
        int index = 0;
        for(Boern b: boerneListe){
            if(b.getName().equals(name)){
                index = boerneListe.indexOf(b);
            }
        }
        boerneListe.remove(index);
        saveBoern(boerneListe);


    }

    public static ArrayList<Boern> loadBoern(){
        ObjectInputStream objin = null;
        ArrayList<Boern> returnBoern = null;
        try{
            if(boerneFil.length() != 0){
                objin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(boerneFil)));
                returnBoern = (ArrayList<Boern>) objin.readObject();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                    if(objin != null){
                        objin.close();
                    }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return returnBoern;
    }

    public static void saveBoern(ArrayList<Boern> boerneliste){
        ObjectOutputStream objout = null;
        try{
            objout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("boernefil.txt"))));
            objout.writeObject(boerneliste);

        }catch (IOException e){
            e.printStackTrace();

        }finally {
            try {
                if (objout != null){
                    objout.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void changeBarnInfo(Boern barn){
        ArrayList<Boern> boerneListe = BoernUtil.loadBoern();
        boerneListe.set(currentIndex, barn);
        saveBoern(boerneListe);
    }
//javafx utils
    public static Boern getBarn(String name){

        ArrayList<Boern> boerneListe = BoernUtil.loadBoern();

        Boern currentBarn = null;
        for(Boern b: boerneListe){
            if(b.getName().equals(name)){
                currentBarn = b;
                currentIndex = boerneListe.indexOf(b);
            }
        }
        return currentBarn;
    }

    public static VBox tidligereBoern(){
        VBox tidligereBoernVBox = new VBox();
        ArrayList<Boern> boerneListe = loadBoern();

        if(boerneListe != null){

            for(Boern b: boerneListe){
                BorderPane barnSkabelon = new BorderPane();
                Label nameLabel = new Label(b.getName());
                Image profilBillede = new Image("file:barn.png");
                ImageView imageView = new ImageView(profilBillede);
                Button infoBtn = new Button("Info");
                infoBtn.setOnAction(e -> {
                    StamkortClass.stamkort(nameLabel.getText());
                });
                barnSkabelon.setPadding(new Insets(10, 0, 0, 0));
                barnSkabelon.setLeft(imageView);
                barnSkabelon.setTop(nameLabel);
                barnSkabelon.setCenter(infoBtn);
                tidligereBoernVBox.getChildren().add(barnSkabelon);
            }

        }
        return tidligereBoernVBox;
    }
}
