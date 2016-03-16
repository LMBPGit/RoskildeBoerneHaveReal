package Util;

import Models.Boern;

import java.io.*;
import java.util.ArrayList;

public class VenteListeUtil {

    private static File venteFile  = new File("boernefil.txt");

    public static void nytBarnTilVenteListen(Boern nytBarn){
        ArrayList<Boern> boerneListe = loadVenteListen();
        boerneListe.add(nytBarn);
        saveVenteListen(boerneListe);
    }

    public static void fjernBarnFraVenteListen(String name){
        ArrayList<Boern> boerneListe = loadVenteListen();
        int index = 0;
        for(Boern b: boerneListe){
            if(b.getName().equals(name)){
                index = boerneListe.indexOf(b);
            }
        }
        boerneListe.remove(index);
        saveVenteListen(boerneListe);
    }

    public static ArrayList<Boern> loadVenteListen(){
        ObjectInputStream objin = null;
        ArrayList<Boern> returnBoern = null;
        try{
            if(venteFile.length() != 0){
                objin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(venteFile)));
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

    public static void saveVenteListen(ArrayList<Boern> boerneliste){
        ObjectOutputStream objout = null;
        try{
            objout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("venteFile.txt"))));
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

}
