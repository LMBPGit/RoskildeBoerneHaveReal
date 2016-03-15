import Models.Boern;
import Util.BoernUtil;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Boern> liste = new ArrayList<>();
        liste.add(new Boern("Jan", 4));
        liste.add(new Boern("Line", 5));

        BoernUtil.saveBoern(liste);
        System.out.println(BoernUtil.loadBoern());
    }

}
