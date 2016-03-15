package Util;

import Models.Boern;
import java.io.*;
import java.util.ArrayList;


public class BoernUtil {

    private static File boerneFil;

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
            objout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(boerneFil)));


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
