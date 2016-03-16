package Util;

import java.io.*;
import java.util.ArrayList;

public class VenteListeUtil {

    private static File venteFile  = new File("venteFile.txt");

    public static void nytBarnTilVenteListen(String name){
        ArrayList<String> boerneListe = loadVenteListen();
        boerneListe.add(name);
        saveVenteListen(boerneListe);
    }

    public static void fjernBarnFraVenteListen(String name){
        ArrayList<String> boerneListe = loadVenteListen();
        int index = 0;
        for(String b: boerneListe){
            if(b.equals(name)){
                boerneListe.remove(boerneListe.indexOf(b));
            }
        }
        saveVenteListen(boerneListe);
    }

    public static ArrayList<String> loadVenteListen(){
        ObjectInputStream objin = null;
        ArrayList<String> returnBoern = null;
        try{
            if(venteFile.length() != 0){
                objin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(venteFile)));
                returnBoern = (ArrayList<String>) objin.readObject();
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

    public static void saveVenteListen(ArrayList<String> boerneliste){
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
